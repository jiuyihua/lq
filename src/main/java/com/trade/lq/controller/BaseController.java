package com.trade.lq.controller;

import com.trade.lq.vo.ResultVO;

/**
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 上午 11:24
 */
public class BaseController  {

    public <T>ResultVO<T> success(T data){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(200);
        resultVO.setMassage("success");
        resultVO.setData(data);
        return resultVO;
    }

}
