package com.zhangqirong.webmagic.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 将Long型转换成String
     * @param mseconds 毫秒数
     * @return
     */
    public static String longToDate(Long mseconds){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(mseconds * 1000);
        String str = sdf.format(date);
        return str;
    }
}
