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
import com.neuedu.lvcity.model.Banar;
import com.neuedu.lvcity.model.Food;
import com.neuedu.lvcity.model.Scenic;
import com.neuedu.lvcity.service.impl.IndexService;
import com.neuedu.lvcity.service.impl.IndexServiceImpl;

/**
 * Servlet implementation class IndexGetServlet
 */
@WebServlet("/IndexGetServlet")
public class IndexGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 测试用户常量，返回当前类名以定位Bug发生位置
	 */
	private static final String Ca = Thread.currentThread().getStackTrace()[1].getClassName();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexGetServlet() {
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
		//获取请求数据
		//获取主页Service实例,用以业务处理
		IndexService serv = IndexServiceImpl.getInstance();
		List<Banar> lBanar = serv.findBanar();
		List<Scenic> lScenic = serv.findScenic();
		List<Article> lArticle = serv.findArticle();
		List<Food> lFood = serv.findFood();
		//设置会话对象
		se.setAttribute("banarList", lBanar);
		se.setAttribute("scenicList", lScenic);
		se.setAttribute("articleList", lArticle);
		se.setAttribute("foodList", lFood);
		//请求重定向到结果页面
		response.sendRedirect(request.getContextPath()+"/User/index.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
