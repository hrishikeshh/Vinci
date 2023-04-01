package com.hrishikeshh.vinci.test;

import com.hrishikeshh.vinci.chromosome.Gene;

public class SimpleGene implements Gene {

    public int mNumber;

    public SimpleGene(int number) {

        this.mNumber = number;
    }

    public int express() {

        return mNumber;
    }

    public String toString() {

        return express() + "";
    }
}
