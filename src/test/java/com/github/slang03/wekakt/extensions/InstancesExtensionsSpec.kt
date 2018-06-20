package com.github.slang03.wekakt.extensions

import getIris
import org.jetbrains.spek.api.dsl.*
import org.jetbrains.spek.subject.SubjectSpek
import shouldEqualTo
import weka.core.DenseInstance
import weka.core.Instances
import weka.filters.Filter
import weka.filters.unsupervised.instance.RemovePercentage

/**
 * Specifications for Weka [weka.core.Instances] extensions.
 *
 * @author Steven Lang
 */

object InstancesExtensionsSpec : SubjectSpek<Instances>({

    // Define the subject
    subject {
        getIris()
    }

    given("the iris dataset and an empty copy of it") {
        val irisCopy = Instances(subject, subject.size)

        on("setting new rows in the copy") {
            for (i in 0 until subject.size) {
                irisCopy.add(DenseInstance(subject.numAttributes()))
                irisCopy[i] = subject[i]
            }

            it("should be equal to the original dataset") {
                subject `shouldEqualTo` irisCopy
            }
        }

        on("applying the removePercentage filter") {
            val subjectFiltered = subject.filter(RemovePercentage()) {
                percentage = 20.0
            }

            val irisFiltered = Filter.useFilter(subject, RemovePercentage().apply { percentage = 20.0; setInputFormat(subject) })

            it("should be equal to the filtered set using Filter.useFilter()") {
                subjectFiltered shouldEqualTo irisFiltered
            }
        }

        on("splitting the dataset with the .split() function") {
            val percentage = 33.0
            val (train, test) = subject.split(percentage)

            val removePercentage1 = RemovePercentage()
            removePercentage1.percentage = percentage
            removePercentage1.setInputFormat(subject)

            val removePercentage2 = RemovePercentage()
            removePercentage2.percentage = percentage
            removePercentage2.invertSelection = true
            removePercentage2.setInputFormat(subject)

            val splitTrainWeka = Filter.useFilter(subject, removePercentage1)
            val splitTestWeka = Filter.useFilter(subject, removePercentage2)

            it("should be equal to the Filter.useFilter() results") {
                train shouldEqualTo splitTrainWeka
                test shouldEqualTo splitTestWeka
            }
        }
    }
})