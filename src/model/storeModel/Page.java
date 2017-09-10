package model.storeModel;

import java.awt.print.Book;
import java.util.List;

/**
 * Created by leo on 2017/7/14.
 */
public class Page {

    private int currentPage;// 当前显示的页码
    private int totalPage;// 总页数
    private int pageSize;// 每页显示的记录条数
    private List<Product> data;// 当前页要显示的数据

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List<Product> getData() {
        return data;
    }

    public void setData(List<Product> data) {
        this.data = data;

    }
}
