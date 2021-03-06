package servlet.sales;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.TransactionDao;
import model.sales.Soitem;
import model.sales.Somain;

@WebServlet(name = "UpdateServlet", urlPatterns = { "/sales/UpdateServlet" })
public class UpdateServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到UpdateServlet");
		String soid = request.getParameter("soid");// 销售单编号
		String createTime = request.getParameter("createTime");// 创建时间
		String customerCode = request.getParameter("customerCode");// 客户名称
		String account = request.getParameter("account");// 创建用户
		float tipFee = Float.parseFloat(request.getParameter("tipFee"));// 附加费用
		float productTotal = Float.parseFloat(request.getParameter("productTotal"));// 产品总价
		String payType = request.getParameter("payType");// 付款方式
		float prePayFee = Float.parseFloat(request.getParameter("prePayFee"));// 最低预付款金额
		String remark = request.getParameter("remark");// 备注
		Somain somain = new Somain(soid, createTime, customerCode, account, tipFee, productTotal,
				payType, prePayFee, remark);

		ArrayList<Soitem> soitems = new ArrayList<Soitem>();
		String[] productCodeArray = request.getParameterValues("productCode");// 产品编号
		String[] unitPriceArray = request.getParameterValues("unitPrice");// 产品单价
		String[] numArray = request.getParameterValues("num");// 产品数量
		String[] num_beforeArray = request.getParameterValues("num_before");// 产品数量（用于销售待发数更新）
		String[] unitNameArray = request.getParameterValues("unitName");// 数量单位
		String[] itemPriceArray = request.getParameterValues("itemPrice");// 明细总价
		for (int i = 0; i < productCodeArray.length; i++) {
			Soitem soitem = new Soitem(soid, productCodeArray[i],
					Float.parseFloat(unitPriceArray[i]), Integer.parseInt(numArray[i]),
					unitNameArray[i], Float.parseFloat(itemPriceArray[i]));
			soitems.add(soitem);
		}

		TransactionDao transactionDao = new TransactionDao();
		transactionDao.updateSomain_Soitem_Product(somain, soitems, num_beforeArray);

		request.getRequestDispatcher("/gztm/querySale.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
