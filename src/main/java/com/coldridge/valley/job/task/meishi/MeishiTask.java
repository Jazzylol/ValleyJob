package com.coldridge.valley.job.task.meishi;


import com.coldridge.valley.job.dao.meishi.read.custom.HuoguoReadDao;
import com.coldridge.valley.job.model.po.Huoguo;
import com.coldridge.valley.job.model.po.HuoguoExample;
import com.coldridge.valley.job.tools.MongoHelper;
import com.mongodb.client.FindIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by zzt on 2016/3/22.
 */
@Component
public class MeishiTask {

    private static final String MONGO_DB_NAME = "meishi";
    private static final String MONGO_COLL_NAME = "huoguo";

    @Autowired
    private HuoguoReadDao huoguoReadDao;



//    @Scheduled(cron = "0 0/1 * * *")
    @Scheduled(fixedRate = 5000)
    public void print() {

        MongoHelper helper = new MongoHelper(MONGO_DB_NAME, MONGO_COLL_NAME);
        FindIterable<Document> documents = helper.query();

        HuoguoExample param = new HuoguoExample();
        List<Huoguo> huoguos = huoguoReadDao.selectByExample(param);
        for (Huoguo huoguo : huoguos) {
            System.out.println(huoguo.toString());
        }
//        huoguos.forEach((huoguo) -> System.out.println(huoguo.toString()));
    }


}
