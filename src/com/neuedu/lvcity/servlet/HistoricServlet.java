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
import com.neuedu.lvcity.model.Contact;
import com.neuedu.lvcity.service.impl.HistoricService;
import com.neuedu.lvcity.service.impl.HistoricServiceImpl;;

/**
 * Servlet implementation class HistoricServlet
 */
@WebServlet("/HistoricServlet")
public class HistoricServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//测试用户常量，返回当前类名以定位Bug发生位置
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HistoricServlet() {
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
		//获取历史Service，用以请求获取数据
		HistoricService serv = HistoricServiceImpl.getInstance();
		
		//获取请求数据
		List<Article> list = serv.findHistoricArtcile();
		Contact contact = serv.findContact();
		//设置会话对象
		se.setAttribute("noticetypelist", list);
		se.setAttribute("contact", contact);
		//请求重定向到结果页面
		response.sendRedirect(request.getContextPath()+"/User/notice.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
