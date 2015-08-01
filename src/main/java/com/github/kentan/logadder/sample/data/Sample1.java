package com.github.kentan.logadder.sample.data;

public class Sample1 {

    public static void main(String args[]) {
        (new  Sample1()).sample();
        (new  Sample1()).sample2();
        (new  Sample2()).sample();
        (new  Sample2()).sample2();
    }

    public void sample() {
        int i = 2;
    }

    public void sample2() {
        int j = 2;
    }
}
