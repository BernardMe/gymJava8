package org.learnit.essential;

import java.util.HashSet;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @Description :HashCode测试02
 * @author :  wangzhuo
 * @Title Name :
 * @Copyright :
 * @Creation Date:  2020-09-14 9:38
 */
public class HashCodeTest02 {

    private static final Logger log = Logger.getLogger(HashCodeTest02.class);

    @Test
    public void hashCodeTest() {
        HashSet set = new HashSet();

        set.add(new Student(15, "Tom"));
        set.add(new Student(15, "Jerry"));
        log.info(set.size());
    }

    class Student {
        private String name;
        private int age;

        public Student(int age, String name) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            //自反性
            if(this == o) {
                return true;
            }
            if (!(o instanceof Student)) {
                return false;
            }
            Student stu = (Student) o;
            if (this.age == stu.age && Objects.equals(this.name, stu.name)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 17;
            hash = hash * 31 + (null == name ? 0 : name.hashCode());
            hash = hash * 31 + age;
            return hash;
        }
    }
}
