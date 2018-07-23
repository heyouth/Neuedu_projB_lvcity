package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.model.Admin;
import com.neuedu.lvcity.model.Article;
import com.neuedu.lvcity.model.Notice;
import com.neuedu.lvcity.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeWatchServlet
 */
@WebServlet("/NoticeWatchServlet")
public class NoticeWatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//测试用户常量，返回当前类名以定位Bug发生位置
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		article
//		admin
//		ntid
//		pageNow

		System.out.println(">"+Ca);
		//获取请求会话
		HttpSession se = request.getSession();
		//获取动态页Service，用以请求获取数据
		int pageNow = Integer.parseInt(request.getParameter("pageNow"));
		int ntid = Integer.parseInt(request.getParameter("ntid"));
		int aid = Integer.parseInt(request.getParameter("aid"));
		//获取动态页Service实例，用以请求获取数据
		NoticeServiceImpl serv = NoticeServiceImpl.getInstance();
		//获取请求数据
		Admin admin = serv.getAdmin();
		Article article = serv.getArticleByaid(aid);
		//设置会话对象
		se.setAttribute("pageNow",pageNow);
		se.setAttribute("admin",admin);
		se.setAttribute("ntid",ntid);
		se.setAttribute("article",article);
		//请求重定向到结果页面
		response.sendRedirect(request.getContextPath()+"/User/noticetext.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
