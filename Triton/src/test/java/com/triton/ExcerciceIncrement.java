package com.triton;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The Class ExcerciceIncrement.
 * 
 * @author Stephane
 * @since 2013
 */
public class ExcerciceIncrement extends AbstractExcercice {
    private static final int INITAL_VALUE = 100;
    private static final int ITERATION = 10000000;
    private static final int NB_THREADS = 10;

    private RunnableObject runnableObject1 = new RunnableObject() {
        @Override
        public void run() {
            incrementalValue.increment();
        }
    };
    private RunnableObject runnableObject2 = new RunnableObject() {
        @Override
        public void run() {
            incrementalValue.publicInt++;
        }
    };
    private RunnableObject runnableObject3 = new RunnableObject() {
        @Override
        public void run() {
            incrementalValue.publicAmoticInt.incrementAndGet();

        }
    };

    @Before
    public void setUp() throws Exception {
        runnableObject1.start();
        runnableObject2.start();
        runnableObject3.start();
    }

    @After
    public void tearDown() throws Exception {
        runnableObject1.stop();
        runnableObject2.stop();
        runnableObject3.stop();
    }

    @Test
    public void testGivenFooWhenIncrementGetOne() throws Exception {
        for (int i = 0; i < ITERATION; i++) {
            runnableObject1.run();
            runnableObject2.run();
            runnableObject3.run();
        }

        IncrementalValue incrementalValue1 = runnableObject1.getIncrementalValue();
        IncrementalValue incrementalValue2 = runnableObject2.getIncrementalValue();
        IncrementalValue incrementalValue3 = runnableObject3.getIncrementalValue();

        StringBuilder sb = new StringBuilder();
        sb.append(NEW_LINE);
        sb.append("synchronized int value : ").append(incrementalValue1.getValue()).append(NEW_LINE);
        sb.append("volatile publicInt : ").append(incrementalValue2.publicInt).append(NEW_LINE);
        sb.append("AtomicInteger publicAmoticInt : ").append(incrementalValue3.publicAmoticInt.intValue()).append(NEW_LINE);

        LOG.info(sb.toString());

        int expected = INITAL_VALUE + ITERATION;
        assertEquals("synchronized int value : failed : ", expected, incrementalValue1.getValue());
        assertEquals("volatile publicInt : failed : ", expected, incrementalValue2.publicInt);
        assertEquals("AtomicInteger publicAmoticInt : failed : ", expected, incrementalValue3.publicAmoticInt.intValue());
    }

    private class RunnableObject implements Runnable {
        private ExecutorService executorService;
        protected IncrementalValue incrementalValue = new IncrementalValue(INITAL_VALUE);

        public void start() {
            executorService = Executors.newFixedThreadPool(NB_THREADS);
        }

        public void stop() {
            executorService.shutdown();
        }

        @Override
        public void run() {
        }

        public IncrementalValue getIncrementalValue() {
            return incrementalValue;
        }
    }

}
