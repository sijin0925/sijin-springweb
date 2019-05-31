package org.sijin.article;

import java.util.List;

public interface ArticleDao {
	
	List<Article> selectAll(int offset, int count);
	
	void addArticle(Article article);
			
	Article getArticle(String articleId);
	
	void updateArticle(Article article);
	
	int deleteArticle(Article article);
	
	int countAll();

}

