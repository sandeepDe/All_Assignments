package com.trail.testsuite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;
//import org.junit.runners.Suite;
//import org.junit.runners.Suite.SuiteClasses;

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.testcases"})


@IncludeTags({"check","creation","product-details"})
//@SuiteClasses({ AllTests.class })
public class AllTagTests {

}
