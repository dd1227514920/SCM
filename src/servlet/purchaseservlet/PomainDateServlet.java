package servlet.purchaseservlet;

import dao.purchase.PomainDao;
import dao.purchase.VenderDao;
import model.purchasemodel.Pomain;
import model.purchasemodel.Vender;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PomainDateServlet",urlPatterns ={"/purchaseservlet/PomainDateServlet"} )
public class PomainDateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		VenderDao vd = new VenderDao();
		PomainDao pd = new PomainDao();
		String poId = request.getParameter("poId");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		System.out.println(startTime);
		System.out.println(endTime);
		String venderCode = request.getParameter("venderCode");
		String payType = request.getParameter("payType");
		try {
			List<Vender> lv = vd.queryAllVenders();
			List<Pomain> lp = pd.querydate(poId,startTime,endTime,venderCode,payType);
			request.setAttribute("pList", lp);
			request.setAttribute("vList", lv);
			request.getRequestDispatcher("/purchase/selectPo.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
