package com.neuedu.lvcity.dao.impl;

import java.util.List;

import com.neuedu.lvcity.model.Article;

public interface ArticleDao {
	/**
	 * 根据文章类型和数量查找文章获取
	 * 
	 * @param type 文章类型
	 * @param num 获取数量
	 * @return Article集合
	 */
	public List<Article> findArticleByType(int type,int num);
}
