package com.aemtools.inspection.html

import com.aemtools.test.HtlTestCase
import com.intellij.codeInspection.ex.LocalInspectionToolWrapper
import com.intellij.testFramework.InspectionTestCase
import java.io.File

/**
 * Test for [RedundantElInspection].
 *
 * @author Dmytro Troynikov
 */
class RedundantElInspectionTest : InspectionTestCase() {

  override fun getTestDataPath(): String {
    return File(HtlTestCase.testResourcesPath).absolutePath
  }

  fun testRedundantElInspection() {
    doTest("com/aemtools/inspection/html/redundant-el",
        LocalInspectionToolWrapper(RedundantElInspection()))
  }

}
