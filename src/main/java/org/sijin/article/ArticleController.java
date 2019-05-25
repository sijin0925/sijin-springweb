package org.sijin.article;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.sijin.book.chap11.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ArticleController {
	
	@Autowired
	ArticleDao articleDao;

	
	static final Logger logger = LogManager.getLogger();

	
	@PostMapping("/article/EndAddAticle")
	public String articleAdd(Article article,@SessionAttribute("MEMBER") Member member) {
		article.setUserId(member.getMemberId());
		article.setName(member.getName());
		articleDao.addArticle(article);
		return "redirect:/app/article/articles";
	}
	
	@GetMapping("/article/view")
    public void view(@RequestParam("articleId") String articleId, Model model,@SessionAttribute("MEMBER") Member member) {
        Article article = articleDao.getArticle(articleId);
        model.addAttribute("article", article);
    }
	
	@GetMapping("/article/AddArticle")
	public String AddArticle(Article article,@SessionAttribute("MEMBER") Member member) {
		return "article/AddArticle";
		}
	
	@GetMapping("/article/articles")
	public String articles(
			@RequestParam(value = "page", defaultValue = "1") int page,	Model model) {

		// 페이지 당 가져오는 행의 수
		final int COUNT = 100;
		// 시작점
		int offset = (page - 1) * COUNT;

		List<Article> aritcleList = articleDao.selectAll(offset, COUNT);

		int totalCount = articleDao.countAll();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("articles", aritcleList);
		return "article/articles";
	}
	
	@GetMapping("/article/updateArticle")
	public String updateArticle(@RequestParam("articleId") String articleId,
			Model model,
			HttpSession session,
			@SessionAttribute("MEMBER") Member member){
			
			Article article = articleDao.getArticle(articleId);
			if(!member.getMemberId().equals(article.getUserId()))
				return "redirect:/app/article/view?articleId="+articleId;
			
			model.addAttribute("article",article);
			return "article/updateArticle";
	}
	
	@PostMapping("/article/update")
	public String update(Article article,@RequestParam("articleId") String articleId,
						@SessionAttribute("MEMBER") Member member){
		
			articleDao.updateArticle(article);
			return "redirect:/app/article/articles";
	}
	
	@GetMapping("/article/deleteArticle")
	public String deleteArticle(@RequestParam("articleId") String articleId,
			@SessionAttribute("MEMBER") Member member)
	{
			Article article = articleDao.getArticle(articleId);
			if(!member.getMemberId().equals(article.getUserId()))
				return "redirect:/app/article/view?articleId="+articleId;
			
			articleDao.deleteArticle(article);
			return "redirect:/app/article/articles";
	}
		
}
