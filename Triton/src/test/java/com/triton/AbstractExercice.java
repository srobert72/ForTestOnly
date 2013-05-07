package com.triton;

import java.util.logging.Logger;

import junit.framework.TestCase;

/**
 * The Class AbstractExercice.
 * 
 * Super class used for JUnit TestCase
 * 
 * @author Stephane
 * @since 2013
 */
public class AbstractExercice extends TestCase {

    /**
     * The Constant LOG.
     * Logger used to write logs
     * */
    protected static final Logger LOG = Logger.getLogger(AbstractExercice.class.getName());

    /**
     * The Constant NEW_LINE.
     * New line character used in logs
     * */
    protected static final String NEW_LINE = CommonConstants.NEW_LINE;
}
