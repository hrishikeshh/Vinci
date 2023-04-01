package com.hrishikeshh.vinci.selection;

import com.hrishikeshh.vinci.chromosome.Chromosome;
import com.hrishikeshh.vinci.population.Population;
import javafx.util.Pair;

public abstract class SelectionStrategy {

    public abstract Pair<Chromosome, Chromosome> select(Population population);
}
