package com.winterbe.java8.samples.extendz;

interface InterfaceA {

    default void print() {
        System.out.println("InterfaceA print");
    }
}

class ClassA implements InterfaceA {

}
