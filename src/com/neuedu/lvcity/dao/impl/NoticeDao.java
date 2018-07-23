package com.neuedu.lvcity.dao.impl;

import java.util.List;

import com.neuedu.lvcity.model.Admin;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.NoticeType;

public interface NoticeDao {
	/**
	 * 根据文章类型和数量查找文章获取
	 * @param type 文章类型
	 * @param num 获取数量
	 * @return Notice集合
	 */
	public List<Notice> findNoticeByType(int type,int num);
	
	/**
	 * 获取所有动态页新闻分类
	 * @return NoticeType集合
	 */
	public List<NoticeType> findNoticeType();
	/**
	 * 根据ntid获取动态页新闻分类
	 * @param ntid 分类号
	 * @return NoticeType集合
	 */
	public List<NoticeType> findNoticeType(int ntid);
	/**
	 * 
	 * @param ntid
	 * @return
	 */
	public List<Notice> findNoticeByntid(int ntid,int star,int num);
	/**
	 * 
	 * @param ntid
	 * @return
	 */
	public List<Article> findArticleByntid(int ntid);
	/**
	 * 
	 * @param ntid
	 * @return
	 */
	public int getNoticeNumByntid(int ntid);
	/**
	 * 
	 * @param ntid
	 * @return
	 */
	public String getNoticetypeByntid(int ntid);
	
	public Article getArticleByaid(int aid);
	public Admin getAdmin();
	public List<Article> findArticleBynname(String gjc);
}
