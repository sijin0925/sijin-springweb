package org.sijin.letter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("LetterDao")
public class LetterDaoImplUsingSpringJdbc implements LetterDao {


	static final String LIST_LETTERS_RECEIVED = "select letterId,title,senderId,senderName,left(cdate,19) cdate from letter where receiverId=? order by letterId desc limit ?,?";
	static final String LIST_LETTERS_SENT = "select letterId,title,receiverId,receiverName,left(cdate,19) cdate from letter where senderId=? order by letterId desc limit ?,?";

	static final String COUNT_LETTERS_RECEIVED = "select count(letterId) from letter where receiverId=?";
	static final String COUNT_LETTERS_SENT = "select count(letterId) from letter where senderId=?";

	static final String GET_LETTER = "select letterId,title,content,senderId,senderName,receiverId,receiverName,left(cdate,19) cdate from letter where letterId=? and (senderId=? or receiverId=?)";
	static final String ADD_LETTER = "insert letter(title,content,senderId,senderName,receiverId,receiverName) values(?,?,?,?,?,?)";
	static final String DELETE_LETTER = "delete from letter where letterId=? and (senderId=? or receiverId=?)";

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	final RowMapper<Letter> letterRowMapper = new BeanPropertyRowMapper<>(Letter.class);
	

	@Override
	public List<Letter> listLettersReceived(String receiverId, int offset,
			int count) {
		return jdbcTemplate.query(LIST_LETTERS_RECEIVED, letterRowMapper,
				receiverId, offset, count);
	}

	@Override
	public List<Letter> listLettersSent(String senderId, int offset,
			int count) {
		return jdbcTemplate.query(LIST_LETTERS_SENT, letterRowMapper, senderId,
				offset, count);
	}
	
	@Override
	public int countLettersReceived(String receiverId) {
		return jdbcTemplate.queryForObject(COUNT_LETTERS_RECEIVED,
				Integer.class, receiverId);
	}
	
	@Override
	public int countLettersSent(String senderId) {
		return jdbcTemplate.queryForObject(COUNT_LETTERS_SENT, Integer.class,
				senderId);
	}
	
	@Override
	public Letter getLetter(String letterId, String memberId) {
		return jdbcTemplate.queryForObject(GET_LETTER, letterRowMapper,
				letterId, memberId, memberId);
	}

	@Override
	public int addLetter(Letter letter) {
		return jdbcTemplate.update(ADD_LETTER, letter.getTitle(),
				letter.getContent(), letter.getSenderId(),
				letter.getSenderName(), letter.getReceiverId(),
				letter.getReceiverName());
	}
	@Override
	public int deleteLetter(String letterId, String memberId) {
		return jdbcTemplate.update(DELETE_LETTER, letterId, memberId, memberId);
	}

}