package dao.sales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.sales.Customer;
import model.sales.Page;


public class CustomerDao {

	// 从customer表查询匹配查询条件的客户记录
	public ArrayList<Customer> queryCustomer(String customerCode_value, String name_value,
			String option) {
		ArrayList<Customer> customerList = new ArrayList<Customer>();

		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		String querySQl = "select * from customer where";
		int count = 0;
		if (!customerCode_value.equals("")) {
			querySQl = querySQl + " CustomerCode like'%" + customerCode_value + "%'";
			count++;
		}
		if (!name_value.equals("")) {
			if (count == 0) {
				querySQl = querySQl + " Name like'%" + name_value + "%'";
			} else {
				querySQl = querySQl + option + " Name like'%" + name_value + "%'";
			}
		}
		try {
			System.out.println(querySQl);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(querySQl);
			while (resultSet.next()) {
				String customerCode = resultSet.getString("CustomerCode");
				String name = resultSet.getString("Name");
				String password = resultSet.getString("Password");
				String contactor = resultSet.getString("Contactor");
				String address = resultSet.getString("Address");
				String postcode = resultSet.getString("Postcode");
				String tel = resultSet.getString("Tel");
				String fax = resultSet.getString("Fax");
				String createDate = resultSet.getString("CreateDate");
				Customer customer = new Customer(customerCode, name, password, contactor, address,
						postcode, tel, fax, createDate);
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, statement, null, connection);
		}
		return customerList;
	}

	// 从customer表查询所有客户记录
	public ArrayList<Customer> queryCustomerAll() {
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		String querySQl = "select * from customer";
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(querySQl);
			while (resultSet.next()) {
				String customerCode = resultSet.getString("CustomerCode");
				String name = resultSet.getString("Name");
				String password = resultSet.getString("Password");
				String contactor = resultSet.getString("Contactor");
				String address = resultSet.getString("Address");
				String postcode = resultSet.getString("Postcode");
				String tel = resultSet.getString("Tel");
				String fax = resultSet.getString("Fax");
				String createDate = resultSet.getString("CreateDate");
				Customer customer = new Customer(customerCode, name, password, contactor, address,
						postcode, tel, fax, createDate);
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, statement, null, connection);
		}
		return customerList;
	}

	// 从数据库customer表根据CustomerCode查询客户记录
	public Customer queryOneCustomer(String customerCode) {
		Customer customer = null;
		String querySQL = "select * from customer where CustomerCode='" + customerCode + "'";
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(querySQL);
			while (resultSet.next()) {
				String name = resultSet.getString("Name");
				String password = resultSet.getString("Password");
				String contactor = resultSet.getString("Contactor");
				String address = resultSet.getString("Address");
				String postcode = resultSet.getString("Postcode");
				String tel = resultSet.getString("Tel");
				String fax = resultSet.getString("Fax");
				String createDate = resultSet.getString("CreateDate");
				customer = new Customer(customerCode, name, password, contactor, address, postcode,
						tel, fax, createDate);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, statement, null, connection);
		}
		return customer;
	}

	// 从数据库customer表分页查询所有客户记录
	public ArrayList<Customer> queryCustomerAll(Page page) throws SQLException {
		String sql = "select * from customer limit ?,?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, (page.getCurrentPage() - 1) * page.getPageSize());
			preparedStatement.setInt(2, page.getPageSize());
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String customerCode = resultSet.getString("CustomerCode");
				String name = resultSet.getString("Name");
				String password = resultSet.getString("Password");
				String contactor = resultSet.getString("Contactor");
				String address = resultSet.getString("Address");
				String postcode = resultSet.getString("Postcode");
				String tel = resultSet.getString("Tel");
				String fax = resultSet.getString("Fax");
				String createDate = resultSet.getString("CreateDate");
				Customer customer = new Customer(customerCode, name, password, contactor, address,
						postcode, tel, fax, createDate);
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(resultSet, null, preparedStatement, connection);
		}
		return customerList;
	}

	// 向数据库customer表添加新客户记录
	public void addCustomer(Customer customer) {
		String updateSQL = "insert into customer values(?,?,?,?,?,?,?,?,?)";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, customer.getCustomerCode());
			preparedStatement.setString(2, customer.getName());
			preparedStatement.setString(3, customer.getPassword());
			preparedStatement.setString(4, customer.getContactor());
			preparedStatement.setString(5, customer.getAddress());
			preparedStatement.setString(6, customer.getPostcode());
			preparedStatement.setString(7, customer.getTel());
			preparedStatement.setString(8, customer.getFax());
			preparedStatement.setString(9, customer.getCreateDate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, null, preparedStatement, connection);
		}
	}

	// 更新customer表中一条客户记录
	public int updateCustomer(Customer customer) {
		String updateSQL = "update customer set Name=?,Password=?,Contactor=?,Address=?,Postcode=?,Tel=?,Fax=? where CustomerCode=?";
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		int result = 0;
		try {
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, customer.getName());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setString(3, customer.getContactor());
			preparedStatement.setString(4, customer.getAddress());
			preparedStatement.setString(5, customer.getPostcode());
			preparedStatement.setString(6, customer.getTel());
			preparedStatement.setString(7, customer.getFax());
			preparedStatement.setString(8, customer.getCustomerCode());
			result = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, null, preparedStatement, connection);
		}
		return result;
	}

	// 从customer表中删除一条客户记录
	public void deleteCustomer(String customerCode) {
		String updateSQL = "delete from customer where CustomerCode='" + customerCode + "'";
		Connection connection = DBConnection.getConnection();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(updateSQL);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, statement, null, connection);
		}
	}

	// 从customer表中删除多条客户记录
	public boolean deleteCustomers(String[] customerCodeArray) {
		boolean flag = true;
		Connection connection = DBConnection.getConnection();
		PreparedStatement preparedStatement = null;
		try {
			connection.setAutoCommit(false);
			String updateSQL = "delete from customer where CustomerCode=?";
			preparedStatement = connection.prepareStatement(updateSQL);
			for (int i = 0; i < customerCodeArray.length; i++) {
				preparedStatement.setString(1, customerCodeArray[i]);
				preparedStatement.addBatch();
			}

			int[] feedback = preparedStatement.executeBatch();
			for (int i = 0; i < feedback.length; i++) {
				System.out.println(feedback[i]);
				if (feedback[i] == 0) {
					flag = false;
					break;
				}
			}
			if (flag) {
				connection.commit();
			} else {
				connection.rollback();
			}
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBClose.DatabaseClose(null, null, preparedStatement, connection);
		}
		return flag;
	}
}