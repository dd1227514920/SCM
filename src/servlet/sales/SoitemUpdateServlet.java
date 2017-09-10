package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SoitemDao;
import model.sales.Soitem;

@WebServlet(name = "SoitemUpdateServlet", urlPatterns = { "/sales/SoitemUpdateServlet" })
public class SoitemUpdateServlet extends HttpServlet {// 修改soitem后更新数据库

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SoitemUpdateServlet");
		String soid = request.getParameter("soid");// 销售单编号
		String[] productCodeArray = request.getParameterValues("productCode");// 产品编号
		String[] unitPriceArray = request.getParameterValues("unitPrice");// 产品单价
		String[] numArray = request.getParameterValues("num");// 产品数量
		String[] unitNameArray = request.getParameterValues("unitName");// 数量单位
		String[] itemPriceArray = request.getParameterValues("itemPrice");// 明细总价
		SoitemDao soitemDao = new SoitemDao();
		soitemDao.deleteSoitem(soid);
		for (int i = 0; i < productCodeArray.length; i++) {
			Soitem soitem = new Soitem(soid, productCodeArray[i],
					Float.parseFloat(unitPriceArray[i]), Integer.parseInt(numArray[i]),
					unitNameArray[i], Float.parseFloat(itemPriceArray[i]));
			soitemDao.addSoitem(soitem);
		}
		request.getRequestDispatcher("/gztm/querySale.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
