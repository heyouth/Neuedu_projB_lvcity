package com.neuedu.lvcity.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.model.NoticeType;
import com.neuedu.lvcity.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/NoticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//测试用户常量，返回当前类名以定位Bug发生位置
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();   
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
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
		//获取动态页Service实例，用以请求获取数据
		NoticeServiceImpl serv = NoticeServiceImpl.getInstance();
		
		//获取请求数据
		List<NoticeType> noticetypelist = serv.findNoticeType();
		Contact contact = serv.findContact();
		int firstnoticetypeid = noticetypelist.get(0).getNtid();
		//设置会话对象
		se.setAttribute("noticetypelist", noticetypelist);
		se.setAttribute("contact", contact);
		se.setAttribute("firstnoticetypeid", firstnoticetypeid);
		//请求重定向到结果页面
		response.sendRedirect(request.getContextPath()+"/User/noticetype.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
