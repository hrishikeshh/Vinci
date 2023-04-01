package com.hrishikeshh.vinci.mutation;

import com.hrishikeshh.vinci.chromosome.Chromosome;
import com.hrishikeshh.vinci.chromosome.Gene;

import java.util.Random;

public abstract class StandardMutationImpl implements MutationStrategy {

    protected float mMutationChance = 0.05f;
    protected Random mRandom = new Random();

    public StandardMutationImpl() {

    }

    public StandardMutationImpl(float chance) {

        mMutationChance = chance;
    }

    public Chromosome mutate(Chromosome c) {

        for(int i = 0; i < c.size(); i++) {

            if(mRandom.nextFloat() <= mMutationChance) {

                Gene toMutate = c.remove(i);
                c.add(i, mutate(toMutate));
            }
        }

        return c;
    }

    public abstract Gene mutate(Gene g);
}
