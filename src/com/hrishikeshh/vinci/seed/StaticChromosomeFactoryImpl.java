package com.hrishikeshh.vinci.seed;

import com.hrishikeshh.vinci.chromosome.Chromosome;

public class StaticChromosomeFactoryImpl implements ChromosomeFactory {

    protected GeneFactory mGeneFactory;
    protected int mChromosomeSize;

    public StaticChromosomeFactoryImpl(GeneFactory geneFactory, int chromosomeSize) {

        mGeneFactory = geneFactory;
        mChromosomeSize = chromosomeSize;
    }

    public Chromosome randomChromosome() {

        Chromosome chromosome = new Chromosome();

        for(int i = 0; i < mChromosomeSize; i++) {
            chromosome.add(mGeneFactory.randomGene());
        }

        return chromosome;
    }
}
