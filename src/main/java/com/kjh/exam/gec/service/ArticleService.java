package com.kjh.exam.gec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kjh.exam.gec.repository.ArticleRepository;
import com.kjh.exam.gec.util.Utility;
import com.kjh.exam.gec.vo.Article;
import com.kjh.exam.gec.vo.ResultData;

@Service
public class ArticleService {
	private ArticleRepository articleRepository;

	
	@Autowired
	public ArticleService(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
		
	}

	public Article getArticle(int id) {
		return articleRepository.getArticle(id);
	}
	
	public void deleteArticle(int id) {
		articleRepository.deleteArticle(id);
	}
	
	public void modifyArticle(int id, String title, String body) {
		articleRepository.modifyArticle(id, title, body);
	}

	public List<Article> getArticles() {
		return articleRepository.getArticles();
	}

	public ResultData writeArticle(String title, String body) {
		articleRepository.writeArticle(title, body);
		int id = articleRepository.getLastInsertId();
		return ResultData.from("S-1", Utility.f("%d번 게시물이 생성되었습니다", id), id);
	}

}
