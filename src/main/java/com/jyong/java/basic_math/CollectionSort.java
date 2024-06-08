package com.jyong.java.basic_math;

import cn.hutool.core.date.DateUtil;
import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author jyong
 * @Date 2024/4/26 22:09
 * @desc
 */

public class CollectionSort {

    public static void main(String[] args)
    {
        List<DataModel> list = new ArrayList<>();
        // 创建一个集合
        DataModel dataModel = new DataModel();
        String dateStr = "2024-04-26 22:09:00";
        dataModel.setGmtCreate(DateUtil.parseDate(dateStr));
        dataModel.setName("jyong");
        // 创建一个集合
        DataModel dataModel2 = new DataModel();
        String dateStr2 = "2024-04-27 22:09:00";
        dataModel2.setGmtCreate(DateUtil.parseDate(dateStr2));
        dataModel2.setName("jyong2");
        // 创建一个集合
        DataModel dataModel3 = new DataModel();
        String dateStr3 = "2024-04-24 22:09:00";
        dataModel3.setGmtCreate(DateUtil.parseDate(dateStr3));
        dataModel3.setName("jyong3");

        //创建时间字段为空的数据
        DataModel dataModel4 = new DataModel();
        dataModel4.setName("jyong4");
        list.add(dataModel4);



        list.add(dataModel);
        list.add(dataModel2);
        list.add(dataModel3);

        //1.打印
        System.out.println("排序前：");
        list.forEach(e-> System.out.println(e.toString()));

        //排序是判断，时间字段是否为空，为空时放在最后面
        Collections.sort(list, (o1, o2) -> {
            if (o1.getGmtCreate() == null) {
                return 1;
            }
            if (o2.getGmtCreate() == null) {
                return -1;
            }
            return o2.getGmtCreate().compareTo(o1.getGmtCreate());
        });

        //2。打印排序后
        System.out.println("排序后：");
        list.forEach(e-> System.out.println(e.toString()));


    }
}
