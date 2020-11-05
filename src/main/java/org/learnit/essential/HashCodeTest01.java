package org.learnit.essential;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Objects;

/**
 * @Description :HashCode测试01
 * @author :  wangzhuo
 * @Title Name :
 * @Copyright :
 * @Creation Date:  2020-09-14 9:38
 */
public class HashCodeTest01 {

    private static final Logger log = Logger.getLogger(HashCodeTest01.class);

    @Test
    public void hashCodeTest() {
        for (int i = 0; i < 50; i++) {
            // if I remove the third parameter, it works fine
            log.info(String.valueOf(Objects.hash("getDemoCache", "1", new int[]{1, 2})));
        }
    }
}
