package com.github.slang03.wekakt.extensions

import assertPredictionsAreEqual
import getIris
import org.jetbrains.spek.api.dsl.*
import org.jetbrains.spek.subject.SubjectSpek
import weka.classifiers.Classifier
import weka.classifiers.Evaluation
import weka.classifiers.evaluation.Prediction
import weka.classifiers.trees.J48
import java.util.*
import shouldEqualTo

/**
 * Specifications for Weka [weka.classifiers.Classifier] extensions.
 *
 * @author Steven Lang
 */

object ClassifierExtensionsSpec : SubjectSpek<Classifier>({

    // Define the subject
    subject { J48() }

    given("j48 clf, iris data and 33% split percentage"){
        val testPercentage = 33.0
        var iris = getIris()

        on("holdout evaluation"){
            val (train, test) = iris.split(testPercentage)
            subject.buildClassifier(train)
            val eval = Evaluation(train)
            eval.evaluateModel(subject, test)
            val predsExpected: ArrayList<Prediction> = eval.predictions()

            val clf2 = J48()
            val evaluateHoldoutActual2: Evaluation = clf2.evaluateHoldout(trainData = train, testData = test)
            val predsActual2: ArrayList<Prediction> = evaluateHoldoutActual2.predictions()

            it("should calculate the same predictions"){
                assertPredictionsAreEqual(predsExpected, predsActual2)
            }
        }

        on("cross validation"){
            val eval = subject.evaluateCrossValidation(data = iris, numFolds = 10, seed = 1)
            val predsActual = eval.predictions()

            it("should have the same result as normal cross validation"){
                val eval = Evaluation(iris)
                eval.crossValidateModel(subject, iris, 10, Random(1))
                val predsExpected: ArrayList<Prediction> = eval.predictions()

                assertPredictionsAreEqual(predsExpected, predsActual)
            }
        }
    }
})