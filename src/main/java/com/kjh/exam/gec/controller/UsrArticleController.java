package com.kjh.exam.gec.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public ResultData<Article> doAdd(HttpSession httpSession, String title, String body) {
		
		if(httpSession.getAttribute("loginedMemberId") == null) {
			return ResultData.from("F-A", "로그인 후 이용해주세요");
		}
		
		int loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		
		if(Utility.empty(title)) {
			return ResultData.from("F-1", "제목을 입력해주세요");
		}
		
		if(Utility.empty(body)) {
			return ResultData.from("F-2", "내용을 입력해주세요");
		}
		
		ResultData writeArticleRd = articleServise.writeArticle(loginedMemberId, title, body);
		
		Article article = articleServise.getArticle((int) writeArticleRd.getData1());
		
		return ResultData.from(writeArticleRd.getResultCode(), writeArticleRd.getMsg(), "article", article);
	}
	
	@RequestMapping("/usr/article/list")
	public String showList(Model model) {
		
		List<Article> articles = articleServise.getArticles();
		
		model.addAttribute("articles", articles);
		
		return "usr/article/list";
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public ResultData<Integer> doDelete(HttpSession httpSession, int id) {
		
		if(httpSession.getAttribute("loginedMemberId") == null) {
			return ResultData.from("F-A", "로그인 후 이용해주세요");
		}
		
		int loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		
		Article article = articleServise.getArticle(id);
		
		if(article == null) {
			return ResultData.from("F-1", Utility.f("%d번 게시물은 존재하지 않습니다", id));
		}
		
		if(loginedMemberId != article.getMemberId()) {
			return ResultData.from("F-B", "해당 게시물에 대한 권한이 없습니다"); 
		}
		
		articleServise.deleteArticle(id);
		
		return ResultData.from("S-1", Utility.f("%d번 게시물을 삭제했습니다", id), "id", id);
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public ResultData<Article> doModify(HttpSession httpSession, int id, String title, String body) {
		
		if(httpSession.getAttribute("loginedMemberId") == null) {
			return ResultData.from("F-A", "로그인 후 이용해주세요");
		}
		
		int loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		
		Article article = articleServise.getArticle(id);
		
		if(article == null) {
			return ResultData.from("F-1", Utility.f("%d번 게시물은 존재하지 않습니다", id));
		}
		
		ResultData actorCanModifyRd = articleServise.actorCanMD(loginedMemberId, article);
		
		return articleServise.modifyArticle(id, title, body);
	}
	
	@RequestMapping("/usr/article/detail")
	public String detail(HttpSession httpSession, Model model, int id) {
		
		int loginedMemberId = 0;
		
		if(httpSession.getAttribute("loginedMemberId") != null) {
			loginedMemberId = (int) httpSession.getAttribute("loginedMemberId");
		}
		
		Article article = articleServise.getForPrintArticle(loginedMemberId, id);
		
		model.addAttribute("article", article);
		
		return "usr/article/detail";
	}

}
