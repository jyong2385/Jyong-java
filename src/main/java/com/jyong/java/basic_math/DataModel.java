package com.jyong.java.basic_math;

import cn.hutool.core.date.DateUtil;

import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @Author jyong
 * @Date 2024/4/26 22:08
 * @desc
 */

public class DataModel {

    private String name;
    private Date gmtCreate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }
    //重新toString方法，日期类型输出格式化成字符串YYYY-MM-dd HH:mm:ss
    @Override
    public String toString() {
        String gmtCreateStr = "";
        if (gmtCreate != null) {
            gmtCreateStr = DateUtil.format(gmtCreate,"yyyy-MM-dd HH:mm:ss");
        }
        return "DataModel{" +
                "name='" + name + '\'' +
                ", gmtCreate=" + gmtCreateStr +
                '}';
    }



}
