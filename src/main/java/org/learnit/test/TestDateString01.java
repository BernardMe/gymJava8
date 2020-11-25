package org.learnit.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.learnit.date.TestDate01.getDateStrListBetweenTwoDate;

/**
 * @Description: 测试日期时间处理01
 * @Project：test
 * @author :  wangzhuo
 * @Date:  2020-11-16
 */
public class TestDateString01 {

    /** 日期格式 **/
    public interface DATE_PATTERN {
        String HHMMSS = "HHmmss";
        String HH_MM_SS = "HH:mm:ss";
        String YYYYMMDD = "yyyyMMdd";
        String YYYY_MM_DD = "yyyy-MM-dd";
        String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
        String YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
        String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
        String YYYY_MM_DD_HH_MM_SS_SSS = "yyyy-MM-dd HH:mm:ss.SSS";
    }

    public static void main(String[] args) throws Exception {
        String start = "2014-01-03";
        String end = "2014-03-05";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dBegin = sdf.parse(start);
        Date dEnd = sdf.parse(end);
        /*List<Date> listDate = getDatesBetweenTwoDate2(dBegin, dEnd);
        for(int i=0;i<listDate.size();i++){
            System.out.println(sdf.format(listDate.get(i)));
        }*/
        List<String> stringList = getDateStrListBetweenTwoDate(dBegin, dEnd, DATE_PATTERN.YYYY_MM_DD);
        for (String s : stringList) {
            System.out.println(s);
        }
    }


}
