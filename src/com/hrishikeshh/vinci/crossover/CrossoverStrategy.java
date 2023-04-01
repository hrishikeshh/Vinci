package com.hrishikeshh.vinci.crossover;

import com.hrishikeshh.vinci.chromosome.Chromosome;
import javafx.util.Pair;

public interface CrossoverStrategy
{
    /**
     * Interface describing a strategy to perform crossover
     * between two chromosomes
     * @param a First chromosome
     * @param b Second chromosome
     */
    public abstract Pair<Chromosome, Chromosome>
        crossover(Chromosome a,
                  Chromosome b);
}
