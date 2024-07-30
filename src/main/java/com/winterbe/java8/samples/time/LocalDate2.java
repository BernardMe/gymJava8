package com.winterbe.java8.samples.time;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

/**
 * @author wangzhuo
 */
public class LocalDate2 {

    public static void main(String[] args) {
        LocalDate startDate = LocalDate.from(LocalDateTime.of(2024, Month.JULY, 19, 8, 0,0));
        System.out.println("开始时间  : " + startDate);

        LocalDate endDate = LocalDate.from(LocalDateTime.of(2024, Month.JULY, 20, 23, 59,59));
        System.out.println("结束时间 : " + endDate);

        long daysDiff = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("两天之间的差在天数   : " + daysDiff);

    }

}