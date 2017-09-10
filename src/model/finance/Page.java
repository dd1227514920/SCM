package model.finance;

import java.util.List;

/**
 * Created by JerryCheng on 2017.7.16.
 */
public class Page {
    private int currentPage;// 当前的第几页
    private int pageSize;// 每页显示的数据条数
    private int totalPage;// 总页数
    private List data;// 每页显示的数据

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}
