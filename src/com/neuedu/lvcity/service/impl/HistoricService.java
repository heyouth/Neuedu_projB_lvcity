package com.neuedu.lvcity.service.impl;

import java.util.List;

import com.neuedu.lvcity.model.Article;
/**
 * 历史Service类
 * @author Heyouth
 *
 */
import com.neuedu.lvcity.model.Contact;
public interface HistoricService {
	/**
	 * 获取历史类的文章
	 * @return Article集合
	 */
	public List<Article> findHistoricArtcile();
	/**
	 * 获取联系方式
	 * @return Contact模型
	 */
	public Contact findContact();
}
