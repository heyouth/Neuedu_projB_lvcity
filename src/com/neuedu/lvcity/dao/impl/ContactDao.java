package com.neuedu.lvcity.dao.impl;

import java.util.List;

import com.neuedu.lvcity.model.Contact;

/**
 * 联系方式类Dao
 * @author Administrator
 *
 */
public interface ContactDao {
	/**
	 * 获取所以联系方式记录
	 * @return Contact集合
	 */
	public List<Contact> findContact();
}
