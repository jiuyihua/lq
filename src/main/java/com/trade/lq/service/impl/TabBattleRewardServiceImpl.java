package com.trade.lq.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trade.lq.dao.TabBattleRewardMapper;
import com.trade.lq.entity.TabBattleReward;
import com.trade.lq.service.TabBattleRewardService;
import com.trade.lq.utils.PagaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import org.springframework.data.domain.PageRequest;

//import org.springframework.data.domain.PageRequest;

/**
 * describle :
 * author : huh
 * 2020/8/18 0018
 * 上午 8:23
 */
@Service("tabBattleRewardService")
public class TabBattleRewardServiceImpl implements TabBattleRewardService {

    @Autowired
    private TabBattleRewardMapper tabBattleRewardMapper;

    @Override
    public List<TabBattleReward> getListTabBattle(Integer pagaNum, Integer pageSize) {
        return tabBattleRewardMapper.getListTabBattle( pagaNum, pageSize);
    }

    @Override
    public List<TabBattleReward> findPage(PagaRequest pagaRequest) {
        return tabBattleRewardMapper.findPage(pagaRequest);
    }

    @Override
    public PageInfo<TabBattleReward> selectPage(PagaRequest pagaRequest) {
        //return PageUtils.getPagaResult(pagaRequest, getPageInfo(pageRequest));
        int pageNum = pagaRequest.getPageNum();
        int pageSize = pagaRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<TabBattleReward>(tabBattleRewardMapper.selectPage());
    }

    /**
     * 调用分页插件完成分页
     * @param pageQuery
     * @return
     */
    /*private PageInfo<TabBattleReward> getPageInfo(PagaRequest pageRequest) {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<TabBattleReward> list = tabBattleRewardMapper.selectPage();
        return new PageInfo<TabBattleReward>(list);
    }
*/

}
