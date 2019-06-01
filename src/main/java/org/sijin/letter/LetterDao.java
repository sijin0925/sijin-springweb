package org.sijin.letter;

import java.util.List;

public interface LetterDao {
	
	List<Letter> listLettersReceived(String receiverId, int offset,int count);
	
	List<Letter> listLettersSent(String senderId, int offset,int count);
	
	int countLettersReceived(String receiverId);
	
	int countLettersSent(String senderId);
	
	Letter getLetter(String letterId, String memberId);
	
	int addLetter(Letter letter);
	
	int deleteLetter(String letterId, String memberId);

}
