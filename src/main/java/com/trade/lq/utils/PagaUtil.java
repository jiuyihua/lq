package com.trade.lq.utils;

import com.github.pagehelper.PageInfo;

/**
 * describle :
 * author : huh
 * 2020/8/19 0019
 * 上午 10:15
 */
public class PagaUtil {

    /**
     * 将分页信息封装到统一的接口
     * @param pagaRequest
     * @param pageInfo
     * @return
     */
    public static PagaResult getPagaResult(PagaRequest pagaRequest, PageInfo<?> pageInfo) {
        PagaResult pageResult = new PagaResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }

}
