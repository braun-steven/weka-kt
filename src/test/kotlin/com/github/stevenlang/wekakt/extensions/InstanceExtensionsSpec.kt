package com.github.stevenlang.wekakt.extensions

import com.github.stevenlang.wekakt.getIris
import org.amshove.kluent.shouldEqualTo
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.jetbrains.spek.subject.SubjectSpek
import weka.core.Instance

/**
 * Specifications for Weka [weka.core.Instance] extensions.
 *
 * @author Steven Lang
 */

object InstanceExtensionsSpec : SubjectSpek<Instance>({

    // Define the subject
    subject {
        val iris = getIris()
        return@subject iris[0]
    }

    given("the first iris datapoint") {
        on("setting attribute values") {
            for (i in 0 until subject.numAttributes) {
                subject[i] = 100 + i
            }

            it("should have the new values") {
                for (i in 0 until subject.numAttributes) {
                    subject[i] shouldEqualTo (100 + i).toDouble()
                }
            }
        }
    }
})