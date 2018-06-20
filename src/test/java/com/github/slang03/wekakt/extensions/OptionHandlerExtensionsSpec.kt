package com.github.slang03.wekakt.extensions

import assertPredictionsAreEqual
import getIris
import org.jetbrains.spek.api.dsl.*
import org.jetbrains.spek.subject.SubjectSpek
import weka.core.Instance
import com.github.slang03.wekakt.extensions.*
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldEqualTo
import org.jetbrains.spek.api.Spek
import weka.classifiers.trees.J48
import weka.core.OptionHandler

/**
 * Specifications for Weka [weka.core.OptionHandler] extensions.
 *
 * @author Steven Lang
 */

object OptionHandlerExtensionsSpec : SubjectSpek<OptionHandler>({
    // Define Subject
    subject { J48() }

    given("an OptionHandler (J48)"){
        on("setting options via the full string"){
            subject.setOptions("-M 5")

            it("should have the same options as a second OptionHandler that has been setup with an option array"){
                val j48 = J48()
                j48.options = arrayOf("-M", "5")

                subject.options `shouldEqual` j48.options
            }
        }
    }
})