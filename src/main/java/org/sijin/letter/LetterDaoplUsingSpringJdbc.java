package org.sijin.letter;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class LetterDaoplUsingSpringJdbc implements LetterDao {


	static final String ADD_EMAIL = "insert letter(title,content,senderId,senderName,receiverId,receiverName)values(?,?,?,?,?,?)";
	
	static final String SEND_EMAIL = "select letterId,title,receiverId,receiverName,cdate, where senderId = ? desc LIMIT ?,?";
	
	static final String RECEIV_EMAIL = "select letterId,title,senderId,senderName,cdate, from letter where receiverId = ?";
	
	static final String VIEW_EMAIL = "select letterId,title,content,senderId,senderName,receiverId,receiverName,cdata from letter where letterId =? and (senderId =? or receiverId = ?)";
	
	static final String DELETE_EMAIL = "delete from letter where letterId=? and(senderId=? or receiverId=?)";
	
	static final String COUNT_ALL = "SELECT count(letterId) count FROM letterId";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	final RowMapper<Letter> letterRowMapper = new BeanPropertyRowMapper<>(Letter.class);
	
	//편지 쓰기
	@Override
	public void addEmail(Letter letter) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(ADD_EMAIL,letter.getTitle(),letter.getContent(),letter.getSenderId(),letter.getSenderName(),letter.getReceiverId(),letter.getReceiverName());	
	}

	//편지 삭제
	@Override
	public void deleteEmail(Letter letter) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE_EMAIL,letter.getLetterId(),letter.getSenderId(),letter.getReceiverId());

	}
	
	//편지 상세조회
	@Override
	public Letter getLetter(String letterId, String senderId, String receiverId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(VIEW_EMAIL,new BeanPropertyRowMapper<>(Letter.class), letterId, senderId, receiverId);
	}
	//보낸편지함
	@Override
	public List<Letter> sendEmail(int offset, int count) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(SEND_EMAIL, letterRowMapper, offset, count);
	}
	//받은편지함
	@Override
	public List<Letter> receiv(int offset, int count) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query(RECEIV_EMAIL, letterRowMapper, offset, count);
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}

}
