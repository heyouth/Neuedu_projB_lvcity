package com.neuedu.lvcity.service.impl;

import java.sql.Connection;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.dao.impl.IndexDao;
import com.neuedu.lvcity.dao.impl.IndexDaoImpl;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;

public class IndexServiceImpl implements IndexService {
	/**
	 * 测试用户常量，返回当前类名以定位Bug发生位置
	 */
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();
	
	public List<Banar> findBanar(){
		List<Banar> lBanar = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取主页dao，用以请求获取数据
			IndexDao dao = new IndexDaoImpl(conn); 
			//获取请求数据
			lBanar = dao.findBanar();
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return lBanar;
	}

	@Override
	public List<Article> findArticle() {
		List<Article> lArticle = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取主页dao，用以请求获取数据
			IndexDao dao = new IndexDaoImpl(conn); 
			//获取请求数据
			lArticle = dao.findIndexArticle();
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return lArticle;
	}

	@Override
	public List<Food> findFood() {
		List<Food> lFood = null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取主页dao，用以请求获取数据
			IndexDao dao = new IndexDaoImpl(conn); 
			//获取请求数据
			lFood = dao.findIndexFood();
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return lFood;
	}

	@Override
	public List<Scenic> findScenic() {
		List<Scenic> lScenic= null;
		Connection conn = null;
		try {
			//连接数据库
			conn = DBUtils.getConnection();
			//开启数据库事务
			DBUtils.beginTransaction(conn);
			//获取主页dao，用以请求获取数据
			IndexDao dao = new IndexDaoImpl(conn); 
			//获取请求数据
			lScenic = dao.findIndexScenic();
		}catch (Exception e) {
			System.err.println(">"+Ca);
			e.printStackTrace();
		}finally {
			//提交数据库事务
			DBUtils.commit(conn);
			//关闭数据库事务
			DBUtils.closeConnection(conn);
		}
		return lScenic;
	}
	
	public static void main(String[] args) {
		
		//测试
//		IndexService src = new IndexServiceImpl();
//		List<Banar> list = src.findBanar();
//		for(int i=0;i<list.size();i++) {
//			Banar dto = list.get(i);
//			System.out.println(dto.getBanarId());
//			System.out.println(dto.getImage());
//			System.out.println(dto.getState());
//		}
		
	}
}
