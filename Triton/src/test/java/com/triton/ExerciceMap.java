package com.triton;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * The Class ExerciceMap.
 * 
 * TestCase for counting how many times put() & get() are called on a java.util.Map
 * 
 * @author Stephane
 * @since 2013
 */
public class ExerciceMap extends AbstractExercice {

    /**
     * The Constant ITERATION.
     * Number of iterations the test will perform
     * */
    private static final int ITERATION = 100;

    /**
     * The Constant VALUE_TEST.
     * Arbitrary value stored into map during tests
     * */
    private static final int VALUE_TEST = 100;

    /**
     * Test iterator.
     * 
     * Iterates number between 1 to N and randomly calls get() or put() on a map
     * A the end displays how many put() & get() have been called
     */
    @Test
    public final void testIterator() {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        MapWithStat<Integer, Integer> mapWithStat = new MapWithStat<Integer, Integer>(map);

        double random;
        for (int i = 0; i < ITERATION; i++) {
            random = Math.random() * 2;
            if (random > 1) {
                mapWithStat.put(i, VALUE_TEST);
            } else {
                mapWithStat.get(i);
            }
        }

        LOG.info("nb PUT : " + mapWithStat.getNbPut());
        LOG.info("nb GET : " + mapWithStat.getNbGet());
    }
}
