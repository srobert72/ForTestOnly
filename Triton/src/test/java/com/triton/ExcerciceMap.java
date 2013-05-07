package com.triton;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ExcerciceMap extends AbstractExcercice {
    private static final int ITERATION = 100;
    private static final int VALUE_TEST = 100;

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
