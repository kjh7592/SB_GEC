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
	public ResultData<Article> doAdd(String title, String body) {
		
		if(Utility.empty(title)) {
			return ResultData.from("F-1", "제목을 입력해주세요");
		}
		
		if(Utility.empty(body)) {
			return ResultData.from("F-2", "내용을 입력해주세요");
		}
		
		ResultData writeArticleRd = articleServise.writeArticle(title, body);
		
		Article article = articleServise.getArticle((int) writeArticleRd.getData1());
		
		return ResultData.from(writeArticleRd.getResultCode(), writeArticleRd.getMsg(), article);
	}
	
	@RequestMapping("/usr/article/getArticles")
	@ResponseBody
	public ResultData<List<Article>> getArticles() {
		
		List<Article> articles = articleServise.getArticles();
		
		return ResultData.from("S-1", "게시물 리스트", articles);
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData<Integer> doDelete(int id) {
		
		Article article = articleServise.getArticle(id);
		
		if(article == null) {
			return ResultData.from("F-1", Utility.f("%d번 게시물은 존재하지 않습니다", id));
		}
		
		articleServise.deleteArticle(id);
		
		return ResultData.from("S-1", Utility.f("%d번 게시물을 삭제했습니다", id), id);
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData<Integer> diModify(int id, String title, String body) {
		
		Article article = articleServise.getArticle(id);
		
		if(article == null) {
			return ResultData.from("F-1", Utility.f("%d번 게시물은 존재하지 않습니다", id));
		}
		
		articleServise.modifyArticle(id, title, body);
		
		return ResultData.from("S-1", Utility.f("%d번 게시물을 삭제했습니다", id), id);
	}
	
	@RequestMapping("/usr/article/getArticle")
	@ResponseBody
	public ResultData<Article> getArticle(int id) {
		
		Article article = articleServise.getArticle(id);
		
		if(article == null) {
			return ResultData.from("F-1", Utility.f("%d번 게시물은 존재하지 않습니다", id));
		}
		
		return ResultData.from("S-1", Utility.f("%d번 게시물 입니다", id), article);
	}

}
