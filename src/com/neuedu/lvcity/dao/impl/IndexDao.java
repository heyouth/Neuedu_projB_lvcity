package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;

/**
 * 主页Dao类
 * @author heyouth
 *
 */
public interface IndexDao {
	/**
	 * 获取主页广告图方法
	 * @return Banar集合
	 */
	public List<Banar> findBanar();	
	/**
	 * 获取主页文章方法
	 * @return Article集合
	 */
	public List<Article> findIndexArticle();
	/**
	 * 获取主页获取主页美食图片方法
	 * @return Food集合
	 */
	public List<Food> findIndexFood();
	/**
	 * 获取主页风景图片方法
	 * @return Scenic集合
	 */
	public List<Scenic> findIndexScenic();				
}
