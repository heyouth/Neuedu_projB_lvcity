package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.service.impl.NoticeServiceImpl;


/**
 * Servlet implementation class NoticeShowListServlet
 */
@WebServlet("/NoticeShowListServlet")
public class NoticeShowListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//测试用户常量，返回当前类名以定位Bug发生位置
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeShowListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(">"+Ca);
		//获取请求会话
		HttpSession se = request.getSession();
		//获取动态页Service，用以请求获取数据
		int pageNow = Integer.parseInt(request.getParameter("pageNow"));
		int ntid = Integer.parseInt(request.getParameter("ntid"));
		//获取动态页Service实例，用以请求获取数据
		NoticeServiceImpl serv = NoticeServiceImpl.getInstance();
		//一页9条数据
		int pageSize = 9;
		//该类型一共有几条数据
		int rowCount = serv.getNoticeNumByntid(ntid);
		if(rowCount == 0) {
			//设置“暂无记录”标准
			se.setAttribute("zwjl", "1");
		}
		else {
	        //将“暂无记录”标志先设置清空
	        se.setAttribute("zwjl", null);
		}
		//总页数
		int pageCount;
		if(rowCount % pageSize == 0){
		    pageCount = rowCount/pageSize;
		}
		else{
		    pageCount = rowCount/pageSize + 1;
		}
		//不足一页，默认显示第一页
		if(pageNow<1){
			pageNow=1;
		}
		//当前页超过最大页，设置当前页为最大页
		if(pageNow>pageCount){
			pageNow=pageCount;
		}
		
		int start=0;
		if(pageNow==1){
			//如果是第一页，从0开始
			start=0;
		}
		else if (pageNow==0) {
			start=(pageNow)*pageSize;
			pageNow = 1;
			pageCount= 1;
		}
		else{
			start=(pageNow-1)*pageSize;
		}
		//获取请求数据
		List<Notice> noticelist = serv.findNoticeByntid(ntid, start);
		List<Article> articlelist = serv.findArticleByntid(ntid);
		String noticeType = serv.getNoticetypeByntid(ntid);
		//设置会话对象
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("rowCount",rowCount);
		se.setAttribute("pageCount",pageCount);
		se.setAttribute("pageSize",pageSize);
		se.setAttribute("ntid",ntid);
		se.setAttribute("like","null");
		se.setAttribute("noticetype", noticeType);
		se.setAttribute("noticelist", noticelist);
		se.setAttribute("articlelist", articlelist);
		//请求重定向到结果页面
		response.sendRedirect(request.getContextPath()+"/User/noticelist.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
