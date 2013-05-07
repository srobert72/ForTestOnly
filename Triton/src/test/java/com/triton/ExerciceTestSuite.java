package com.triton;

import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class ExerciceTestSuite.
 * 
 * TestSuite to launch all TestCase
 * 
 * @author Stephane
 * @since 2013
 */
@RunWith(Suite.class)
@SuiteClasses(value = { ExerciceDisk.class, ExerciceFib.class, ExerciceMap.class, ExerciceNumberToWords.class, ExerciceStwAndo.class })
public class ExerciceTestSuite extends TestSuite {

}
