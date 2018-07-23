package com.neuedu.lvcity.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.lvcity.common.DBUtils;
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.Scenic;

public class ContactDaoImpl implements ContactDao {
	/**
	 * 联系方式Dao类连接对象
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
	public ContactDaoImpl(Connection conn) {
		this.conn = conn;
	}

	@Override
	public List<Contact> findContact() {
		//预编译对象
		PreparedStatement prestmt = null;
		//定义一个Scenic集合
		List<Contact> list = new ArrayList<Contact>();
		//结果集
		ResultSet rs = null;
		try {
			//设置查询语句
			prestmt = conn.prepareStatement("select * from CONTACT");
			//执行查询语句再利用结果集接收查询结果
			rs = prestmt.executeQuery();
			//判断结果集是否为空,不为空则读取一个结果，将信息转移到Contact并添加到Contact集合
			while(rs.next()) {
				//媒介用户模型
				Contact dto = new Contact();
				dto.setAddress(rs.getString("address"));
				dto.setContactid(rs.getInt("contactid"));
				dto.setContactname(rs.getString("contactname"));
				dto.setFax(rs.getString("fax"));
				dto.setQq(rs.getString("qq"));
				dto.setTel(rs.getString("tel"));
				dto.setWeb(rs.getString("web"));
				dto.setZipcode(rs.getString("zipcode"));
				list.add(dto);
			}
		}catch(SQLException e) {
			System.err.println(Ca+":获取Scenic信息异常");
			e.printStackTrace();
		}finally {
			//关闭结果集以及数据库Statement
			DBUtils.closeStatement(rs,prestmt);
		}
		return list;
	}

}
