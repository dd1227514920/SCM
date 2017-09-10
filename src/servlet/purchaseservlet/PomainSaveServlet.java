package servlet.purchaseservlet;

import dao.purchase.PoitemDao;
import dao.purchase.PomainDao;
import dao.purchase.ProductDao;
import model.purchasemodel.Poitem;
import model.purchasemodel.Pomain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PomainSaveServlet",urlPatterns ={"/purchaseservlet/PomainSaveServlet"} )
public class PomainSaveServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String poId = request.getParameter("poId");
		String venderCode = request.getParameter("venderCode");
		String account = request.getParameter("account");
		String createTime = request.getParameter("createTime");
		float tipFee = Float.parseFloat(request.getParameter("tipFee"));
		float productTotal = Float.parseFloat(request.getParameter("productTotal"));
		float poTotal = Float.parseFloat(request.getParameter("poTotal"));
		String payType = request.getParameter("payType");
		float prePayFee = Float.parseFloat(request.getParameter("prePayFee"));
		int status = Integer.parseInt(request.getParameter("status"));
		String remark = request.getParameter("remark");
		
		Pomain pm = new Pomain(poId, venderCode, account, createTime, tipFee, productTotal, poTotal, payType, prePayFee, status, remark);
		
		int max =Integer.parseInt(request.getParameter("max"));
		PoitemDao pid = new PoitemDao();
		PomainDao pd = new PomainDao();
		ProductDao pdd = new ProductDao();
		List<Poitem> lpi = new ArrayList<Poitem>();
		for(int i =1;i<=max;i++){
			String productCode = request.getParameter("productCode"+i);
			if(productCode==null)continue;
			float unitPrice = Float.parseFloat(request.getParameter("unitPrice"+i));
			int num = Integer.parseInt(request.getParameter("num"+i));
			String unitName = request.getParameter("unitName"+i);
			float itemPrice = Float.parseFloat(request.getParameter("itemPrice"+i));
			Poitem pi = new Poitem(poId, productCode, unitPrice, num, unitName, itemPrice);
			lpi.add(pi);
		}
		pd.addPomain(pm, lpi);
		request.setAttribute("message", "增加成功");
		request.getRequestDispatcher("/purchase/pomain.jsp").forward(request, response);
	}

}
