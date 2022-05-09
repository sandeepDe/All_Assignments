package com.trail.testsuite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludePackages;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.testcases.calcapp.CalculatorTest;
import com.testcases.studentapp.training.UserTest;




@RunWith(JUnitPlatform.class)

@SelectPackages({"com.testcases.studentapp"})

@ExcludePackages({"com.testcases.studentapp.training"})

//@SuiteClasses({UserTest.class , CalculatorTest.class})
//@SelectPackages({"com.testcases.calcapp", "com.testcases.studentapp"})
public class AllTests {

}
