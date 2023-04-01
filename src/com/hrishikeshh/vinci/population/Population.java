package com.hrishikeshh.vinci.population;

import com.google.common.collect.TreeMultimap;
import com.hrishikeshh.vinci.chromosome.Chromosome;
import com.hrishikeshh.vinci.fitness.FitnessEvaluator;
import com.hrishikeshh.vinci.seed.ChromosomeFactory;

import java.util.Map;
import java.util.Set;

public class Population
{
    protected int mSize = 20;
    protected TreeMultimap<Float, Chromosome> mIndividuals;
    protected FitnessEvaluator mFitnessEvaluator;

    public Population() {

        mIndividuals = TreeMultimap.create();
    }

    public Population(int size) {

        mIndividuals = TreeMultimap.create();
        mSize = size;
    }

    public void setFitnessEvaluator(FitnessEvaluator eval) {

        mFitnessEvaluator = eval;
    }

    public void setSize(int size) {

        mSize = size;
    }

    public void seed(ChromosomeFactory chromosomeFactory) {

        for(int i = 0; i < mSize; i++) {

            Chromosome rand = chromosomeFactory.randomChromosome();
            add(rand);
        }
    }

    public void add(Chromosome chromosome) {

        //TODO check for null fitnessevaluator

        float fitness = mFitnessEvaluator.score(chromosome);
        mIndividuals.put(fitness, chromosome);
    }

    public Chromosome getBest() {

        System.out.println("Best fitness: " + mIndividuals.asMap().firstKey());
        return mIndividuals.asMap().firstEntry().getValue().iterator().next();
    }

    public TreeMultimap<Float, Chromosome> getIndividuals() {

        return mIndividuals;
    }

    public int getRealSize() {

        return mIndividuals.size();
    }

    public Set<Map.Entry<Float, Chromosome>> entries() {

        return mIndividuals.entries();
    }

    public String toString() {

        String total = "";

        for(Map.Entry<Float, Chromosome> s : mIndividuals.entries()) {

            total += s.getKey() + "\t\t" + s.getValue() + "\n";
        }

        return total;
    }
}
