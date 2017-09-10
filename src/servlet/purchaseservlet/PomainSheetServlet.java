package servlet.purchaseservlet;

import dao.purchase.PomainDao;
import dao.purchase.VenderDao;
import model.purchasemodel.Pomain;
import model.purchasemodel.Vender;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PomainSheetServlet",urlPatterns ={"/purchaseservlet/PomainSheetServlet"} )
public class PomainSheetServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		VenderDao vd = new VenderDao();
		PomainDao pd = new PomainDao();
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		try {
			List<Vender> lv = vd.queryAllVenders();
			List<Pomain> lp = pd.querySheetPomains(startTime,endTime);
			float sum=0;
			int num=0;
			if(lp!=null){
			num=lp.size();
			for(Pomain lpp:lp){
				sum+=lpp.getPoTotal();
			}}
			request.setAttribute("pList", lp);
			request.setAttribute("vList", lv);
			request.setAttribute("pListNum", num);
			request.setAttribute("pListSum", sum);
			request.getRequestDispatcher("/purchase/sheetPo.jsp").forward(request, response);
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
