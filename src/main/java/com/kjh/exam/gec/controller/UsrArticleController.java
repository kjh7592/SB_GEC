package com.kjh.exam.gec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kjh.exam.gec.service.ArticleService;
import com.kjh.exam.gec.util.Utility;
import com.kjh.exam.gec.vo.Article;
import com.kjh.exam.gec.vo.ResultData;
import com.kjh.exam.gec.vo.Rq;

@Controller
public class UsrArticleController {
	
	private ArticleService articleServise;
	
	@Autowired
	public UsrArticleController(ArticleService articleServise) {
		this.articleServise = articleServise;
	}

	@RequestMapping("/usr/article/write")
	public String showWrite() {
		return "usr/article/write";
	}
	
	@RequestMapping("/usr/article/doWrite")
	@ResponseBody
	public String doWrite(HttpServletRequest req, String title, String body) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		if(Utility.empty(title)) {
			return Utility.jsHistoryBack("제목을 입력해주세요");
		}
		
		if(Utility.empty(body)) {
			return Utility.jsHistoryBack("내용을 입력해주세요");
		}
		
		ResultData writeArticleRd = articleServise.writeArticle(rq.getLoginedMemberId(), title, body);
		
		int id = (int) writeArticleRd.getData1();
		
		return Utility.jsReplace(Utility.f("%d번 글이 생성되었습니다", id), Utility.f("detail?id=%d", id));
	}
	
	@RequestMapping("/usr/article/list")
	public String showList(Model model) {
		
		List<Article> articles = articleServise.getArticles();
		
		model.addAttribute("articles", articles);
		
		return "usr/article/list";
	}
	
	@RequestMapping("/usr/article/doDelete")
	@ResponseBody
	public String doDelete(HttpServletRequest req, int id) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		Article article = articleServise.getArticle(id);
		
		ResultData actorCanMDRd = articleServise.actorCanMD(rq.getLoginedMemberId(), article);
		
		if(actorCanMDRd.isFail()) {
			return Utility.jsHistoryBack(actorCanMDRd.getMsg());
		}
		
		articleServise.deleteArticle(id);
		
		return Utility.jsReplace(Utility.f("%d번 게시물을 삭제했습니다", id), "list");
	}
	
	@RequestMapping("/usr/article/modify")
	public String showModify(HttpServletRequest req, Model model, int id) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		Article article = articleServise.getForPrintArticle(rq.getLoginedMemberId(), id);
		
		ResultData actorCanMDRd = articleServise.actorCanMD(rq.getLoginedMemberId(), article);
		
		if(actorCanMDRd.isFail()) {
			return rq.jsReturnOnView(actorCanMDRd.getMsg(), true);
		}
		
		model.addAttribute("article", article);
		
		return "usr/article/modify";
	}
	
	@RequestMapping("/usr/article/doModify")
	@ResponseBody
	public String doModify(HttpServletRequest req, int id, String title, String body) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		Article article = articleServise.getArticle(id);
		
		ResultData actorCanMDRd = articleServise.actorCanMD(rq.getLoginedMemberId(), article);
		
		if(actorCanMDRd.isFail()) {
			return Utility.jsHistoryBack(actorCanMDRd.getMsg());
		}
		
		articleServise.modifyArticle(id, title, body);
		
		return Utility.jsReplace(Utility.f("%d번 게시물을 수정했습니다", id), Utility.f("detail?id=%d", id));
	}
	
	@RequestMapping("/usr/article/detail")
	public String showDetail(HttpServletRequest req, Model model, int id) {
		
		Rq rq = (Rq) req.getAttribute("rq");
		
		Article article = articleServise.getForPrintArticle(rq.getLoginedMemberId(), id);
		
		model.addAttribute("article", article);
		
		return "usr/article/detail";
	}

}
