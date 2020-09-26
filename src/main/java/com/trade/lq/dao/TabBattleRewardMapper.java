package com.trade.lq.dao;

import com.trade.lq.entity.TabBattleReward;
import com.trade.lq.utils.PagaRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * describle :
 * author : huh
 * 2020/8/17 0017
 * 下午 10:05
 */
@Repository
public interface TabBattleRewardMapper {
    List<TabBattleReward> getListTabBattle(@Param("pagaNum") Integer pagaNum , @Param("pagaSize") Integer pagaSize);

    List<TabBattleReward> findPage(PagaRequest pagaRequest);

    List<TabBattleReward> selectPage();
}
