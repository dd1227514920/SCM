package model.sales;

import java.util.ArrayList;

public class Page {
	private int currentPage;// 当前的第几页
	private int pageSize;// 每页显示的数据条数
	private int totalPage;// 总页数
	private ArrayList data;// 每页显示的数据

	public Page(int currentPage, int pageSize, int totalPage) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
	}

	public Page(int currentPage, int pageSize, int totalPage, ArrayList data) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.data = data;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public ArrayList getData() {
		return data;
	}

	public void setData(ArrayList data) {
		this.data = data;
	}
}
