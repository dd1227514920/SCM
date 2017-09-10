package servlet.purchaseservlet;

import dao.purchase.VenderDao;
import model.purchasemodel.Page;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VenderServlet",urlPatterns ={"/purchaseservlet/VenderServlet"} )
public class VenderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		VenderDao vd = new VenderDao();
		try {
			
			String p = request.getParameter("page");//要显示的页数
			int currentPage;
			if(p == null){
				currentPage = 1;
			}else{
				currentPage = Integer.parseInt(p);
			}
			Page page = new Page();
			page.setPageSize(2);
			page.setCurrentPage(currentPage);
			
			int count = vd.queryTotalCount();
			int totalPage = count%page.getPageSize()==0?count/page.getPageSize():count/page.getPageSize()+1;
			page.setTotalPage(totalPage);
			vd.queryDate(page);
				
			request.setAttribute("venderPage", page);

			request.getRequestDispatcher("/purchase/vender.jsp").forward(request, response);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
