package com.trade.lq.vo;

import lombok.Data;

/**
 * describle :
 * author : huh
 * 2020/8/30 0030
 * 上午 11:25
 */
@Data
public class ResultVO<T> {

    private Integer code;
    private String massage;
    private T data;

}
