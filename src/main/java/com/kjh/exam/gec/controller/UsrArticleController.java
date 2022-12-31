package com.kjh.exam.gec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.exam.gec.service.ArticleService;
import com.kjh.exam.gec.util.Utility;
import com.kjh.exam.gec.vo.Article;
import com.kjh.exam.gec.vo.ResultData;

@Controller
public class UsrArticleController {
	
	private ArticleService articleServise;
	
	@Autowired
	public UsrArticleController(ArticleService articleServise) {
		this.articleServise = articleServise;
	}

	@RequestMapping("/usr/article/doAdd")
	@ResponseBody
	public Article doAdd(String title, String body) {
		
		int id = articleServise.writeArticle(title, body);
		
		Article article = articleServise.getArticle(id);
		
		return article;
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public List<Article> getArticles() {
		
		return articleServise.getArticles();
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(int id) {
		
		Article article = articleServise.getArticle(id);
		
		if(article == null) {
			return id + "번 게시물은 존재하지 않습니다";
		}
		
		articleServise.deleteArticle(id);
		
		return id + "번 게시물을 삭제했습니다";
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public Object diModify(int id, String title, String body) {
		
		Article article = articleServise.getArticle(id);
		
		if(article == null) {
			return id + "번 게시물은 존재하지 않습니다";
		}
		
		articleServise.modifyArticle(id, title, body);
		
		return article;
	}
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData getArticle(int id) {
		
		Article article = articleServise.getArticle(id);
		
		if(article == null) {
			return ResultData.from("F-1", Utility.f("%d번 게시물은 존재하지 않습니다", id));
		}
		
		return ResultData.from("S-1", Utility.f("%d번 게시물 입니다", id), article);
	}

}
