package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;

public class IndexDaoImpl implements IndexDao {
	/**
	 * 首页Dao类连接对象
	 */
	private Connection conn = null;
	/**
	 * 测试用户常量，返回当前类名以定位Bug发生位置
	 */
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();
	/**
	 * 首页Dao类构造方法
	 * 获取数据库连接对象
	 * @param conn
	 */
	public IndexDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Banar> findBanar() {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Banar集合
		List<Banar> lBanar = new ArrayList<Banar>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from BANAR LIMIT 5");
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到Banar并添加到Banar集合
			while(rs.next()) {
				//媒介用户模型
				Banar dto = new Banar();
				dto.setBanarid(rs.getInt("banarId"));
				dto.setImage(rs.getString("image"));
				dto.setState(rs.getInt("state"));
				lBanar.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Banar信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return lBanar;
	}

	@Override
	public List<Article> findIndexArticle() {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Article集合
		List<Article> lArticle = new ArrayList<Article>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from ARTICLE where image is not null and image != '' LIMIT 3 ");
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到Article并添加到Article集合
			while(rs.next()) {
				//媒介用户模型
				Article dto = new Article();
				dto.setAid(rs.getInt("aid"));
				dto.setArticlename(rs.getString("articleName"));
				dto.setAtid(rs.getInt("atid"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("image"));
				dto.setPublisher(rs.getInt("publisher"));
				dto.setReleasetime(rs.getDate("releaseTime"));
				lArticle.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Article信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return lArticle;
	}

	@Override
	public List<Food> findIndexFood() {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Food集合
		List<Food> lFood = new ArrayList<Food>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from FOOD  LIMIT 10");
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到Food并添加到Food集合
			while(rs.next()) {
				//媒介用户模型
				Food dto = new Food();
				dto.setAid(rs.getInt("aid"));
				dto.setFid(rs.getInt("fid"));
				dto.setFname(rs.getString("fname"));
				dto.setFtid(rs.getInt("ftid"));
				dto.setImage(rs.getString("image"));
				lFood.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Food信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return lFood;
	}

	@Override
	public List<Scenic> findIndexScenic() {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Scenic集合
		List<Scenic> lScenic = new ArrayList<Scenic>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from SCENIC LIMIT 5");
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到Scenic并添加到Scenic集合
			while(rs.next()) {
				//媒介用户模型
				Scenic dto = new Scenic();
				dto.setAid(rs.getInt("aid"));
				dto.setImage(rs.getString("image"));
				dto.setLx(rs.getString("lx"));
				dto.setSid(rs.getInt("sid"));
				dto.setSname(rs.getString("sname"));
				dto.setStid(rs.getInt("stid"));
				lScenic.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Scenic信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return lScenic;
	}
	public static void main(String[] args) {
		Connection conn = DBUtils.getConnection();
		IndexDao dao = new IndexDaoImpl(conn);
		
		//findBanar测试
//		List<Banar> lBanar = dao.findBanar();
//		for(int i=0;i<lBanar.size();i++) {
//			Banar banar = lBanar.get(i);
//			System.out.println(banar.getBanarId());
//			System.out.println(banar.getImage());
//			System.out.println(banar.getState());
//		}
		
		//findIndexArticle测试
		List<Article> lArticle = dao.findIndexArticle();
		for(int i=0;i<lArticle.size();i++) {
			Article dto = lArticle.get(i);
			System.out.println(dto.getAid());
//			System.out.println(dto.getArticlename());
//			System.out.println(dto.getAtid());
//			System.out.println(dto.getContent());
			System.out.println(dto.getImage());
//			System.out.println(dto.getPublisher());
//			System.out.println(dto.getReleasetime());
		}
		
		//findIndexScenic测试
//		List<Scenic> lScenic = dao.findIndexScenic();
//		for(int i=0;i<lScenic.size();i++) {
//			Scenic dto = lScenic.get(i);
//			System.out.println(dto.getAid());
//			System.out.println(dto.getImage());
//			System.out.println(dto.getLx());
//			System.out.println(dto.getSid());
//			System.out.println(dto.getSname());
//			System.out.println(dto.getStid());
//		}
		
		//findIndexScenic测试
//		List<Food> lFood = dao.findIndexFood();
//		for(int i=0;i<lFood.size();i++) {
//			Food dto = lFood.get(i);
//			System.out.println(dto.getAid());
//			System.out.println(dto.getFid());
//			System.out.println(dto.getFname());
//			System.out.println(dto.getFtid());
//			System.out.println(dto.getImage());
//		}
		
		DBUtils.closeConnection(conn);
	}
}
