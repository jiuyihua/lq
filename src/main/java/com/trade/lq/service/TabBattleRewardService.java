package com.trade.lq.service;

import com.github.pagehelper.PageInfo;
import com.trade.lq.entity.TabBattleReward;
import com.trade.lq.utils.PagaRequest;

import java.util.List;

/**
 * describle :
 * author : huh
 * 2020/8/18 0018
 * 上午 8:24
 */
public interface TabBattleRewardService {
    List<TabBattleReward> getListTabBattle(Integer pagaNum, Integer pageSize);
    List<TabBattleReward> findPage(PagaRequest pagaRequest);
    PageInfo<TabBattleReward> selectPage(PagaRequest pagaRequest);
}
