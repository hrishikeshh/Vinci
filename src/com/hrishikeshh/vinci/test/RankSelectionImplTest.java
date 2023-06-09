package com.hrishikeshh.vinci.test;

import com.hrishikeshh.vinci.chromosome.Chromosome;
import com.hrishikeshh.vinci.chromosome.Gene;
import com.hrishikeshh.vinci.fitness.FitnessEvaluator;
import com.hrishikeshh.vinci.population.Population;
import com.hrishikeshh.vinci.selection.RankSelectionImpl;
import javafx.util.Pair;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 */
public class RankSelectionImplTest {

    @Test
    public void testRankSelection() {

        Population pop = new Population();
        pop.setFitnessEvaluator(new ZeroSum());

        Chromosome current = new Chromosome();
        for(int i = 1; i < 20; i++) {

            SimpleGene gene = new SimpleGene(i);
            current.add(gene);
            pop.add(current);
            current = new Chromosome();
        }

        RankSelectionImpl selection = new RankSelectionImpl();
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();

        for(int i = 0; i < 50; i++) {
            Pair<Chromosome, Chromosome> pair = selection.select(pop);
            System.out.println(pair.getKey() + "\t\t" + pair.getValue());

            int keyVal = ((SimpleGene)(pair.getKey().get(0))).express();
            frequency.put(keyVal, frequency.containsKey(keyVal)?(frequency.get(keyVal)+1):1);
        }

        int aFreq = frequency.containsKey(1)?frequency.get(1):0;
        int bFreq = frequency.containsKey(5)?frequency.get(5):0;

        assertTrue(aFreq > bFreq);

        for(Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + "\t:\t" + entry.getValue());
        }
    }

    class ZeroSum implements FitnessEvaluator {

        public float score(Chromosome chromosome) {

            int sum = 0;
            for(Gene g : chromosome)
                sum += ((SimpleGene) g).express();
            return sum;
        }
    }
}
