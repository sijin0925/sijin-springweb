package org.sijin.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("ArticleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {
	
	static final String LIST_ARTICLES = "SELECT articleId, title, name, cdate FROM article ORDER BY articleId desc LIMIT ?,?";
	
	static final String GET_ARTICLE = "SELECT articleId, title, content, name, cdate FROM article WHERE articleId=?";
	
	static final String ADD_ARTICLE = "INSERT INTO article(title, content, userId, name) VALUES (?,?,?,?)";
	
	static final String COUNT_ALL = "SELECT count(articleId) count FROM article";
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	final RowMapper<Article> articleRowMapper = new BeanPropertyRowMapper<>(Article.class);

	//목록
	@Override
    public List<Article> selectAll(int offset, int count) {
        // TODO Auto-generated method stub
        return jdbcTemplate.query(LIST_ARTICLES, articleRowMapper, offset, count);
    }
	//글쓰기
	@Override
	public void addArticle(Article article) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(ADD_ARTICLE, article.getTitle(), article.getContent(), article.getUserId(), article.getName());
	}
	//글1개조회
	@Override
	public Article getArticle(String articleId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(GET_ARTICLE,new BeanPropertyRowMapper<>(Article.class), articleId);
	}
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}

}
