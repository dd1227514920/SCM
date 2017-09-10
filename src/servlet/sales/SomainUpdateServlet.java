package servlet.sales;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.sales.SomainDao;
import model.sales.Somain;

@WebServlet(name = "SomainUpdateServlet", urlPatterns = { "/sales/SomainUpdateServlet" })
public class SomainUpdateServlet extends HttpServlet {// 修改Somain后更新数据库记录

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("跳转到SomainUpdateServlet");
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
		SomainDao somainDao = new SomainDao();
		somainDao.deleteSomain(soid);
		somainDao.addSomain(somain);
		request.getRequestDispatcher("/sales/SoitemUpdateServlet").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
