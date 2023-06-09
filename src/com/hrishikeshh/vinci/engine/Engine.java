package com.hrishikeshh.vinci.engine;

import com.hrishikeshh.vinci.crossover.CrossoverStrategy;
import com.hrishikeshh.vinci.mutation.MutationStrategy;
import com.hrishikeshh.vinci.seed.ChromosomeFactory;
import com.hrishikeshh.vinci.selection.SelectionStrategy;
import com.hrishikeshh.vinci.chromosome.Chromosome;
import com.hrishikeshh.vinci.fitness.FitnessEvaluator;
import com.hrishikeshh.vinci.population.Population;
import javafx.util.Pair;

/**
 */
public class Engine {

    protected ChromosomeFactory mChromosomeFactory;
    protected Population mPopulation;

    protected SelectionStrategy mSelectionStrategy;
    protected MutationStrategy mMutationStrategy;
    protected CrossoverStrategy mCrossoverStrategy;

    protected FitnessEvaluator mFitnessEvaluator;

    public Engine() {

    }

    public Engine initPopulation(int size) {

        //TODO check nulls

        mPopulation = new Population(size);
        mPopulation.setFitnessEvaluator(mFitnessEvaluator);
        mPopulation.seed(mChromosomeFactory);
        return this;
    }

    public Engine setFitnessEvaluator(FitnessEvaluator fitnessEvaluator) {

        mFitnessEvaluator = fitnessEvaluator;
        return this;
    }

    public Engine setChromosomeFactory(ChromosomeFactory chromosomeFactory) {

        mChromosomeFactory = chromosomeFactory;
        return this;
    }

    public Engine setSelectionStrategy(SelectionStrategy selectionStrategy) {

        mSelectionStrategy = selectionStrategy;
        return this;
    }

    public Engine setMutationStrategy(MutationStrategy mutationStrategy) {

        mMutationStrategy = mutationStrategy;
        return this;
    }

    public Engine setCrossoverStrategy(CrossoverStrategy crossoverStrategy) {

        mCrossoverStrategy = crossoverStrategy;
        return this;
    }

    public Chromosome getBest() {

        return mPopulation.getBest();
    }

    int iteration = 0;
    public Population iterate() {

        Population newPopulation = new Population();
        newPopulation.setFitnessEvaluator(mFitnessEvaluator);

        while(newPopulation.getRealSize() < mPopulation.getRealSize()) {

            Pair<Chromosome, Chromosome> selected = mSelectionStrategy.select(mPopulation);

            Chromosome a = selected.getKey();
            Chromosome b = selected.getValue();

            Pair<Chromosome, Chromosome> postCrossover = mCrossoverStrategy.crossover(a, b);

            a = postCrossover.getKey();
            b = postCrossover.getValue();

            a = mMutationStrategy.mutate(a);
            b = mMutationStrategy.mutate(b);

            newPopulation.add(a);
            newPopulation.add(b);
        }

        mPopulation = newPopulation;
        iteration++;

        return mPopulation;
    }
}
