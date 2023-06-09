package com.hrishikeshh.vinci.crossover;

import com.hrishikeshh.vinci.chromosome.Chromosome;
import javafx.util.Pair;

import java.util.Random;

public class SingleLocusCrossoverImpl implements CrossoverStrategy
{
    protected Random mRandom;

    public SingleLocusCrossoverImpl() {

        mRandom = new Random();
    }

    @Override
    public Pair<Chromosome, Chromosome> crossover(Chromosome a, Chromosome b) {

        int locusA = mRandom.nextInt(a.size());
        int locusB = mRandom.nextInt(b.size());

        Chromosome aLeft = a.sublist(0, locusA);
        Chromosome aRight = a.sublist(locusA, a.size());

        Chromosome bLeft = b.sublist(0, locusB);
        Chromosome bRight = b.sublist(locusB, b.size());

        aLeft.addAll(bRight);
        bLeft.addAll(aRight);

        return new Pair<Chromosome, Chromosome>(aLeft, bLeft);
    }
}
