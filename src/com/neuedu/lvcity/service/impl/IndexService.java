package com.neuedu.lvcity.service.impl;

import java.util.List;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;

/**
 * 主页Service类
 * @author Heyouth
 *
 */
public interface IndexService {
	/**
	 * 连接数据库并调用主页Dao获取主页广告图集合
	 * @return Banar集合
	 */
	List<Banar> findBanar();
	/**
	 * 连接数据库并调用主页Dao获取主页文章集合
	 * @return Article集合
	 */
	List<Article> findArticle();
	/**
	 * 连接数据库并调用主页Dao获取主页美食图集合
	 * @return Food集合
	 */
	List<Food> findFood();
	/**
	 * 连接数据库并调用主页Dao获取主页风景图集合
	 * @return Scenic集合
	 */
	List<Scenic> findScenic();
}
