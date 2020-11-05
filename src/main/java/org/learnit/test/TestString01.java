package org.learnit.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TestString01 {

    public static void main(String[] args) {
        String today = LocalDate.now().format(DateTimeFormatter.ISO_DATE);
        String attendMonth = today.substring(0, 7);

        System.out.println("today >>>" + today);
        System.out.println("attendMonth >>>" + attendMonth);
    }
}
