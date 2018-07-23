package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.impl.ArticleDao;
import com.neuedu.lvcity.dao.impl.ArticleDaoImpl;
import com.neuedu.lvcity.dao.impl.ContactDao;
import com.neuedu.lvcity.dao.impl.ContactDaoImpl;
import com.neuedu.lvcity.dao.impl.NoticeDao;
import com.neuedu.lvcity.dao.impl.NoticeDaoImpl;
import com.neuedu.lvcity.model.Admin;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.NoticeType;

public class NoticeServiceImpl {
	//测试常量，返回当前类名以定位Bug发生位置
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();
	/**
	 * 动态页Service类唯一实例(饿汉式)
	 */
	private static NoticeServiceImpl service = new NoticeServiceImpl();
	/**
	 * 获取唯一的Service实例
	 * @return Service实例
	 */
	public static NoticeServiceImpl getInstance() {
		return service;
	}

	public List<Article> findArticleByntid(int ntid) {
		List<Article> list = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			list = dao.findArticleByntid(ntid);
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	public String getNoticetypeByntid(int ntid) {
		String typeName = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			typeName = dao.getNoticetypeByntid(ntid);
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return typeName;
	}

	public int getNoticeNumByntid(int ntid) {
		int num = 0;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			num = dao.getNoticeNumByntid(ntid);
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return num;
	}
	
	public List<Notice> findNoticeByntid(int ntid,int star){
		List<Notice> list = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			list = dao.findNoticeByntid(ntid, star, 9);
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	
	public List<NoticeType> findNoticeType() {
		List<NoticeType> list = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			list = dao.findNoticeType();
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	
	public List<NoticeType> findNoticeType(int ntid) {
		List<NoticeType> list = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			list = dao.findNoticeType(ntid);
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	
	public List<Notice> findNoticeByType(int type, int num) {
		List<Notice> list = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			list = dao.findNoticeByType(type, num);
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return list;
	}

	public Contact findContact() {
		List<Contact> list = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取历史页面dao，用以请求获取数据
			ContactDao dao = new ContactDaoImpl(conn); 
			//获取请求数据
			list = dao.findContact();
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return list.get(0);
	}
	
	public Article getArticleByaid(int aid) {
		Article dto = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			dto = dao.getArticleByaid(aid);
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return dto;
	}
	public Admin getAdmin() {
		Admin dto = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			dto = dao.getAdmin();
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return dto;
	}

	public List<Notice> findNoticeBynname(String gjc) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Article> findArticleBynname(String gjc) {
		List<Article> list = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取动态页面dao，用以请求获取数据
			NoticeDao dao = new NoticeDaoImpl(conn); 
			//获取请求数据
			list = dao.findArticleBynname(gjc);
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return list;
	}
	
	public static void main(String[] args) {
		NoticeServiceImpl service = new NoticeServiceImpl();
		
//		List<NoticeType> list = service.findNoticeType();
//		for(int i=0;i<list.size();i++) {
//			NoticeType dto = list.get(i);
//			System.out.println(dto.getNt());
//			System.out.println(dto.getNtid());
//			
//		}
		
//		List<Notice> list = service.findNoticeByntid(1,0);
//		for(int i=0;i<list.size();i++) {
//			Notice dto = list.get(i);
//			System.out.println(dto.getAid());
//			System.out.println(dto.getNname());
//			System.out.println(dto.getNid());
//			System.out.println(dto.getNtid());
//		}
		

//		List<Notice> list = service.findNoticeByntid(1,0,5);
//		for(int i=0;i<list.size();i++) {
//			Notice dto = list.get(i);
//			System.out.println(dto.getNid());
//			System.out.println(dto.getAid());
//			System.out.println(dto.getNname());
//			System.out.println(dto.getNtid());
//		}
		
//		System.out.println(service.getNoticeNumByntid(1));
		

//		List<Article> list = service.findArticleByntid(1);
//		for(int i=0;i<list.size();i++) {
//			Article dto = list.get(i);
//			System.out.println(dto.getAid());
//			System.out.println(dto.getArticlename());
//			System.out.println(dto.getAtid());
//			System.out.println(dto.getContent());
//			System.out.println(dto.getImage());
//			System.out.println(dto.getPublisher());
//			System.out.println(dto.getReleasetime());
//		}
		
//		Article dto = service.getArticleByaid(14);
//		System.out.println(dto.getAid());
//		System.out.println(dto.getArticlename());
//		System.out.println(dto.getAtid());
//		System.out.println(dto.getContent());
//		System.out.println(dto.getImage());
//		System.out.println(dto.getPublisher());
//		System.out.println(dto.getReleasetime());
		

//		Admin dto = service.getAdmin();
//		System.out.println(dto.getAdminid());
//		System.out.println(dto.getAdminname());
//		System.out.println(dto.getPasswd());
		
		List<Article> list = service.findArticleBynname("网");
		for(int i=0;i<list.size();i++) {
			Article dto = list.get(i);
			System.out.println(dto.getAid());
			System.out.println(dto.getArticlename());
			System.out.println(dto.getAtid());
			System.out.println(dto.getContent());
			System.out.println(dto.getImage());
			System.out.println(dto.getPublisher());
			System.out.println(dto.getReleasetime());
		}
	}
}
