package com.github.slang03.wekakt.extensions

import assertPredictionsAreEqual
import getIris
import org.jetbrains.spek.api.dsl.*
import org.jetbrains.spek.subject.SubjectSpek
import weka.core.Instance
import com.github.slang03.wekakt.extensions.*
import org.amshove.kluent.shouldEqualTo

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

    given("the first iris datapoint"){
        on("setting attribute values"){
            for(i in 0 until subject.numAttributes){
                subject[i] = 100 + i
            }

            it("should have the new values"){
                for(i in 0 until subject.numAttributes){
                    subject[i] shouldEqualTo (100 + i).toDouble()
                }
            }
        }
    }
})