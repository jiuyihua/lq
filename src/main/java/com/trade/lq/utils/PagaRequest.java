package com.trade.lq.utils;

import lombok.Data;
import org.springframework.data.domain.Sort;

/**
 * describle :
 * author : huh
 * 2020/8/19 0019
 * 上午 9:28
 */
@Data
public class PagaRequest {

    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;

    private String orderBy;


    private Sort sort;

    /*@Override
    public Sort getSort() {
        return sort;
    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }*/

    public int getPageNum() {
        return pageNum;
    }
    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }



    public PagaRequest(int pageNum,int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }
    public PagaRequest(int pageNum,int pageSize, String orderBy) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.orderBy = orderBy;
    }

   /* public PagaRequest(int page, int size, Sort sort) {
        super(page, size,sort);
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }*/
}
