package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.model.Admin;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.model.NoticeType;

public class NoticeDaoImpl implements NoticeDao {
	/**
	 * 动态页Dao类连接对象
	 */
	private Connection conn = null;
	//测试常量，返回当前类名以定位Bug发生位置
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();
	/**
	 * 构造方法
	 * 获取数据库连接对象
	 * @param conn
	 */
	public NoticeDaoImpl(Connection conn) {
		this.conn = conn;
	}
	

	@Override
	public String getNoticetypeByntid(int ntid) {
		//预编译对象
		PreparedStatement prestmt = null;
		String typeName = null;
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select nt from NOTICETYPE where ntid = ?");
			prestmt.setInt(1, ntid);
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息数量转移到typeName
			if(rs.next()) {
				typeName = rs.getString("nt");
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Notice信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return typeName;
	}
	

	public List<Article> findArticleByntid(int ntid){
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Banar集合
		List<Article> list = new ArrayList<Article>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select ARTICLE.* from ARTICLE,NOTICE where ntid=? and NOTICE.aid=ARTICLE.aid");
			prestmt.setInt(1, ntid);
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

	@Override
	public int getNoticeNumByntid(int ntid) {
		//预编译对象
		PreparedStatement prestmt = null;
		int num = 0;
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select count(*) from NOTICE where ntid = ? group by ntid");
			prestmt.setInt(1, ntid);
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息数量转移到num
			if(rs.next()) {
				num = rs.getInt(1);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Notice信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return num;
	}
	
	public List<Notice> findNoticeByntid(int ntid,int star,int num){
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Notice集合
		List<Notice> list = new ArrayList<Notice>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from NOTICE where ntid=? order by nid LIMIT ?,? ");
			prestmt.setInt(1, ntid);
			prestmt.setInt(2, star);
			prestmt.setInt(3, num);
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到Notice并添加到Notice集合
			while(rs.next()) {
				//媒介用户模型
				Notice dto = new Notice();
				dto.setAid(rs.getInt("aid"));
				dto.setNid(rs.getInt("nid"));
				dto.setNname(rs.getString("nname"));
				dto.setNtid(rs.getInt("ntid"));
				list.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Notice信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return list;
	}
	
	@Override
	public List<Notice> findNoticeByType(int type, int num) {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Notice集合
		List<Notice> list = new ArrayList<Notice>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from NOTICE where ntid=? LIMIT ?");
			prestmt.setInt(1, type);
			prestmt.setInt(2, num);
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到Notice并添加到Notice集合
			while(rs.next()) {
				//媒介用户模型
				Notice dto = new Notice();
				dto.setAid(rs.getInt("aid"));
				dto.setNid(rs.getInt("nid"));
				dto.setNname(rs.getString("nname"));
				dto.setNtid(rs.getInt("ntid"));
				list.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Notice信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return list;
	}
	@Override
	public List<NoticeType> findNoticeType() {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Notice集合
		List<NoticeType> list = new ArrayList<NoticeType>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from NOTICETYPE");
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到NoticeType并添加到NoticeType集合
			while(rs.next()) {
				//媒介用户模型
				NoticeType dto = new NoticeType();
				dto.setNt(rs.getString("nt"));
				dto.setNtid(rs.getInt("ntid"));
				list.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取NoticeType信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return list;
	}
	
	public List<NoticeType> findNoticeType(int ntid) {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Notice集合
		List<NoticeType> list = new ArrayList<NoticeType>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from NOTICETYPE where ntid=?");
			prestmt.setInt(1, ntid);
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到NoticeType并添加到NoticeType集合
			while(rs.next()) {
				//媒介用户模型
				NoticeType dto = new NoticeType();
				dto.setNt(rs.getString("nt"));
				dto.setNtid(rs.getInt("ntid"));
				list.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取NoticeType信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return list;
	}

	@Override
	public Article getArticleByaid(int aid) {
		//预编译对象
		PreparedStatement prestmt = null;
		Article dto = null;
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from Article where aid=?");
			//执行查询语句再利用结果集接收查询结果
			prestmt.setInt(1, aid);
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息数量转移到dto
			if(rs.next()) {
				dto = new Article();
				dto.setAid(rs.getInt("aid"));
				dto.setArticlename(rs.getString("articleName"));
				dto.setAtid(rs.getInt("atid"));
				dto.setContent(rs.getString("content"));
				dto.setImage(rs.getString("image"));
				dto.setPublisher(rs.getInt("publisher"));
				dto.setReleasetime(rs.getDate("releaseTime"));
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Notice信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return dto;
	}


	@Override
	public Admin getAdmin() {
		//预编译对象
		PreparedStatement prestmt = null;
		Admin dto = null;
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from ADMIN_");
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息数量转移到typeName
			if(rs.next()) {
				dto = new Admin();
				dto.setAdminid(rs.getInt("adminid"));
				dto.setAdminname(rs.getString("adminname"));
				dto.setPasswd(rs.getString("passwd"));
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Notice信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return dto;
	}


	@Override
	public List<Article> findArticleBynname(String gjc) {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Article集合
		List<Article> list = new ArrayList<Article>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			String sql = "select article.* from article,notice where nname like '%网%' and article.aid=notice.aid";
			sql =  "select article.* from article where articlename like "+"'"+"%网%"+"'";
			System.out.println(sql);
			prestmt = conn.prepareStatement(sql);
			System.out.println(gjc);
//			prestmt.setString(1,gjc);
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到Article并添加到Article集合
			System.out.println(rs.next());
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

}
