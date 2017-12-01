package com.aemtools.completion.html.smart

import com.aemtools.common.constant.const.JCR_ROOT
import com.aemtools.test.completion.CompletionBaseLightTest

/**
 * @author Dmytro Troynikov
 */
class DataSlyUseSmartCompletionTest : CompletionBaseLightTest() {

  fun testSmartCompletion() = completionTest {
    addHtml("$JCR_ROOT/apps/component/component.html", """
            <div data-sly-use="$CARET"></div>
        """)
    addHtml("$JCR_ROOT/apps/component/partials/piece1.html", """
            <div data-sly-template.template="$DOLLAR{@ param}"></div>
        """)
    addHtml("$JCR_ROOT/apps/component/piece2.html", """
            <div data-sly-template.template="$DOLLAR{@ param}"></div>
        """)
    addClass("ComponentModel.java", """
            package com.test;

            import com.adobe.cq.sightly.WCMUse;

            public class ComponentUse extends WCMUse {}
        """)
    smart()
    shouldContain(listOf(
        "partials/piece1.html",
        "piece2.html",
        "com.test.ComponentUse"
    ))
  }

}

