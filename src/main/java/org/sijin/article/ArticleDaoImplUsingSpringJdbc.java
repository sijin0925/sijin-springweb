package org.sijin.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("ArticleDao")
public class ArticleDaoImplUsingSpringJdbc implements ArticleDao {

	//목록 조회
	static final String LIST_ARTICLES = "SELECT articleId, title, name, cdate FROM article ORDER BY articleId desc LIMIT ?,?";
	//상세 조회
	static final String GET_ARTICLE = "SELECT articleId, userId, title, content, name, cdate FROM article WHERE articleId=?";
	//글 쓰기
	static final String ADD_ARTICLE = "INSERT INTO article(title, content, userId, name) VALUES (?,?,?,?)";
	//글 목록 넘기기
	static final String COUNT_ALL = "SELECT count(articleId) count FROM article";
	//글 수정
	static final String UPDATE_ARTICLE = "UPDATE article SET title=?, content=? WHERE articleId=?";
	//글 삭제
	static final String DELETE_ARTICLE = "DELETE FROM article WHERE articleId=?";
	
	
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
	//글 목록 넘기기
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(COUNT_ALL, Integer.class);
	}
	//글 수정
	@Override
	public void updateArticle(Article article) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(UPDATE_ARTICLE, article.getTitle(),article.getContent(),article.getArticleId());
	}
	@Override
	public void deleteArticle(Article article) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(DELETE_ARTICLE, article.getArticleId());
		
	}

}
