package org.sijin.letter;

import java.util.List;

public interface LetterDao {
	
	//보낸메일함
	List<Letter> sendEmail(int offset, int count);
	
	//받은메일함
	List<Letter> receiv(int offset, int count);
		
	//편지보내기
	void addEmail(Letter letter);
	
	//편지삭제
	void deleteEmail(Letter letter);
	
	//편지상세조회
	Letter getLetter(String letterId, String senderId, String receiverId);
	
	//목록넘기기
	int countAll();
	
	
		

}
