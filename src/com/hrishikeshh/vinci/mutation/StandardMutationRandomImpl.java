package com.hrishikeshh.vinci.mutation;

import com.hrishikeshh.vinci.chromosome.Gene;
import com.hrishikeshh.vinci.seed.GeneFactory;

public class StandardMutationRandomImpl extends StandardMutationImpl {

    protected GeneFactory mGeneFactory;

    public StandardMutationRandomImpl(GeneFactory geneFactory) {

        mGeneFactory = geneFactory;
    }

    public Gene mutate(Gene gene) {

        return mGeneFactory.randomGene();
    }
}