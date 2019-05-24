package org.sijin.article;

import java.util.List;

public interface ArticleDao {
	
	List<Article> selectAll(int offset, int count);
	
	void addArticle(Article article);
			
	Article getArticle(String articleId);
	
	int countAll();
	

	int updateArticle(Article article);

	void deleteArticle(String articleId);

}

