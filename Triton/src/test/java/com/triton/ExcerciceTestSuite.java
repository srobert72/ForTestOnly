package com.triton;

import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The Class ExcerciceTestSuite.
 * 
 * TestSuite to launch all TestCase
 * 
 * @author Stephane
 * @since 2013
 */
@RunWith(Suite.class)
@SuiteClasses(value = { ExcerciceDisk.class, ExcerciceFib.class, ExcerciceMap.class, ExcerciceNumberToWords.class, ExcerciceStwAndo.class })
public class ExcerciceTestSuite extends TestSuite {

}
