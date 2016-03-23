package com.coldridge.valley.job.task.meishi;


import com.coldridge.valley.job.dao.meishi.read.custom.HuoguoReadDao;
import com.coldridge.valley.job.model.po.Huoguo;
import com.coldridge.valley.job.model.po.HuoguoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zzt on 2016/3/22.
 */
@Component
public class MeishiTask {

    @Autowired
    private HuoguoReadDao huoguoReadDao;

    //    @Scheduled(cron = "0 0/1 * * *")
    @Scheduled(fixedRate = 5000)
    public void print() {
        HuoguoExample param = new HuoguoExample();
        List<Huoguo> huoguos = huoguoReadDao.selectByExample(param);
        for (Huoguo huoguo : huoguos) {
            System.out.println(huoguo.toString());
        }
//        huoguos.forEach((huoguo) -> System.out.println(huoguo.toString()));
    }


}
