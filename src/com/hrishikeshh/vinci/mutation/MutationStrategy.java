package com.hrishikeshh.vinci.mutation;

import com.hrishikeshh.vinci.chromosome.Chromosome;

public interface MutationStrategy {

    public abstract Chromosome mutate(Chromosome c);
}
