package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.impl.ArticleDao;
import com.neuedu.lvcity.dao.impl.ArticleDaoImpl;
import com.neuedu.lvcity.dao.impl.ContactDao;
import com.neuedu.lvcity.dao.impl.ContactDaoImpl;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Contact;

public class HistoricServiceImpl implements HistoricService {
	//测试常量，返回当前类名以定位Bug发生位置
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();
	/**
	 * 主页Service类唯一实例(饿汉式)
	 */
	private static HistoricServiceImpl historicservice = new HistoricServiceImpl();
	/**
	 * 获取唯一的Service实例
	 * @return Service实例
	 */
	public static HistoricService getInstance() {
		return historicservice;
	}
	
	@Override
	public List<Article> findHistoricArtcile() {
		List<Article> list = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取历史页面dao，用以请求获取数据
			ArticleDao dao = new ArticleDaoImpl(conn); 
			//获取请求数据
			list = dao.findArticleByType(1,3);
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

	@Override
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

	public static void main(String[] args) {
		HistoricService service = new HistoricServiceImpl();
		
		//findHistoricArtcile测试
//		List<Article> list = service.findHistoricArtcile();
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
		
		//findHistoricArtcile测试
		Contact dto = service.findContact();
		System.out.println(dto.getAddress());
		System.out.println(dto.getContactid());
		System.out.println(dto.getContactname());
		System.out.println(dto.getFax());
		System.out.println(dto.getQq());
		System.out.println(dto.getTel());
		System.out.println(dto.getWeb());
		System.out.println(dto.getZipcode());
	}
}
