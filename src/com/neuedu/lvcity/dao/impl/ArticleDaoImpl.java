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

public class ArticleDaoImpl implements ArticleDao {
	/**
	 * 首页Dao类连接对象
	 */
	private Connection conn = null;
	/**
	 * 测试用户常量，返回当前类名以定位Bug发生位置
	 */
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();
	/**
	 * 构造方法
	 * 获取数据库连接对象
	 * @param conn
	 */
	public ArticleDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Article> findArticleByType(int type,int num) {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Banar集合
		List<Article> list = new ArrayList<Article>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from ARTICLE where atid=? LIMIT ?");
			prestmt.setInt(1, type);
			prestmt.setInt(2, num);
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
				list.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Article信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return list;
	}
	public static void main(String[] args) {
		
	}
}
