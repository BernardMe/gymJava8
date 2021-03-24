package org.learnit.oop;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description : 水果挑选器 (抽象层级提升)
 * @Title Name :  FruitPicker
 * @author :  wangzhuo
 * @Creation Date:  20210319
 */
public class FruitPicker {

    public List<Fruit> pickGood(List<Fruit> fruits){
        return fruits.stream().filter(e -> check(e)).
                collect(Collectors.toList());
    }

    private boolean check(Fruit e) {
        //抽象层级低
        /*if(e instanceof Apple){
            if(((Apple) e).isSweet()){
                return true;
            }
        }
        if(e instanceof Watermelon){
            if(((Watermelon) e).isJuicy()){
                return true;
            }
        }
        return false;*/

        //抽象层级高
        return e.isTasty();
    }
}
