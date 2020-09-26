package com.trade.lq;

import com.trade.lq.service.RedisServiceImpl;
import com.trade.lq.service.UserService;
import com.trade.lq.service.impl.ResourceServiceImpl;
import com.trade.lq.service.impl.TabBattleRewardServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Slf4j
@MapperScan("com.trade.lq.dao")
class LqApplicationTests {

    @Autowired
    private RedisServiceImpl redisServiceImpl;
    @Autowired
    private TabBattleRewardServiceImpl tabBattleRewardService;
    @Autowired
    UserService userService;
    /*@Autowired
    private Users user;*/

    @Test
    void reg(){
       /* User user = new User();
        user.setUserName("hh");
        user.setEnable(true);
        user.setRealName("华华");
        user.setLocked(false);
        user.setPassWord("123");*/
        //User flaguser = userService.regUser(user);
        String passEncoder = new BCryptPasswordEncoder(10).encode("123").toString();
        //user.setPassWord(passEncoder);
        System.out.println("passEncoder="+passEncoder);

    }

   /* @Test
    void contextLoads() {
        //System.out.println(redisServiceImpl.getKey("name"));

//        System.out.println(user.getUserName());
//        System.out.println(user.getAge());
//        System.out.println( user.getTels());
//      user.getTels().forEach(o -> System.out.println(o) );
//      user.getScores().forEach((s, o) -> System.out.println(s+";"+o));
//      user.getMalls().forEach(mall -> log.info(mall.getProductName()));
        //Arrays.asList(user.getTels()).forEach(tell -> log.info(tell));
       //ArrayList list = user.getTels().forEach(tel -> tell);
        //System.out.println(list.size());
        *//*for (list;tel) {
            System.out.println(tel);
        }*//*
       // user.getScore().forEach();
    }*/

    /*@Autowired
    DataSource dataSource;
*//*
    @Test
    void testDatesource()  {
        List<TabBattleReward> list =  tabBattleRewardService.getListTabBattle(1,5);
        log.info("size=========="+list.size());
        list.forEach(tabBattleReward -> log.info("body:"+tabBattleReward.getRewardBoy()));

    }

    @Autowired
    TtUserService ttUserService;
   *//* @Test
    void  testMyBatisQuery(){
        log.info("tabBattleRewardService====="+tabBattleRewardService.toString());
        log.info("tabBattleRewardService====="+tabBattleRewardService.getListTabBattle().toString());
        //tabBattleRewardService.getListTabBattle().forEach(tabBattleReward -> log.info(tabBattleReward.getRewardBoy()));
        log.info("mybatis~~size==========");
    }*//*
   *//* @Test
   void getList(){
        log.info("TTusersize=="+ttUserService.getTtUserList());
    }*//*
    @Test
    void addTtUserTest(){
        TtUser user = new TtUser();
        user.setId(6);
        user.setName("tt6");
       boolean result = ttUserService.addTtUser(user);
       log.info("addTtUserTest result:"+result);
    }

    @Autowired
    UserServiceImpl userService;
    @Test
    void getUserByUserName(){
       User user = (User) userService.loadUserByUsername("root");
       log.info(user.getPassword());
        for (Role role : user.getRoles()) {
            log.info(role.getName()+"  CH: " +role.getNameZh());
        }
    }


    @Test
    public void findPageTest(){
        PagaRequest pageRequest = new PagaRequest(1,9,"rate desc");
        *//*String orderBy = "rate desc";
        pageRequest.setOrderBy(orderBy);
        if (page != 0 && rows != 0){
            PageHelper.startPage(page, rows, orderBy);
        }*//*
        //PageHelper.startPage("rate AES");
        List<TabBattleReward> list = tabBattleRewardService.findPage(pageRequest);
        list.forEach(tabBattleReward -> log.info("rete==="+tabBattleReward.getRate()));
        list.forEach(tabBattleReward -> log.info("id==="+tabBattleReward.getId()));
    }*/
   /*TODO
   @Test
   void selectPage(){
        List<String> propertise = new ArrayList();
        propertise.add("rate");
        Sort sort;
        sort = new Sort(Direction.ASC,propertise);
        PagaRequest pageRequest = new PagaRequest(1,9,sort);
        PageInfo<TabBattleReward> pageInfo = tabBattleRewardService.selectPage(pageRequest);
        List<TabBattleReward> list = pageInfo.getList();
        list.forEach(tabBattleReward -> log.info(tabBattleReward.getRate()+""));
    }*/

    @Autowired
    ResourceServiceImpl resourceService;

  /*  @Test
    void getallmenuTt(){
       List<Resource> resourceList = resourceService.getAllResource();
        System.out.println("Resource  : size="+resourceList.size());
    }
*/




}
