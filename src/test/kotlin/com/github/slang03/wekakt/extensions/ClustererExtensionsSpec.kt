package com.github.slang03.wekakt.extensions

import com.github.slang03.wekakt.DOUBLE_EQ_PRECISION
import com.github.slang03.wekakt.getIris
import org.amshove.kluent.shouldBeLessThan
import org.amshove.kluent.shouldEqual
import org.amshove.kluent.shouldEqualTo
import org.jetbrains.spek.api.dsl.*
import org.jetbrains.spek.subject.SubjectSpek
import weka.clusterers.ClusterEvaluation
import java.util.*
import weka.clusterers.Clusterer
import weka.clusterers.DensityBasedClusterer
import weka.clusterers.EM
import kotlin.math.absoluteValue

/**
 * Specifications for Weka [weka.clusterers.Clusterer] extensions.
 *
 * @author Steven Lang
 */

object ClustererExtensionsSpec : SubjectSpek<Clusterer>({

    // Define the subject
    subject { EM() }

    given("EM clusterer, iris data and 33% split percentage") {
        val testPercentage = 33.0
        val iris = getIris().removeClassAttribute()

        on("holdout cluster evaluation with and without extension") {
            val (train, test) = iris.split(testPercentage)
            val clEval = subject.evaluate(trainData = train, testData = test)

            // Create expected results by directly calling the Weka methods
            val otherClusterer = EM()
            val clEvalExpected = ClusterEvaluation()
            otherClusterer.buildClusterer(train)
            clEvalExpected.setClusterer(otherClusterer)
            clEvalExpected.evaluateClusterer(test)

            it("should generate the same cluster evaluation") {
                clEval.numClusters `shouldEqualTo` clEvalExpected.numClusters
                (clEval.logLikelihood - clEvalExpected.logLikelihood).absoluteValue `shouldBeLessThan` DOUBLE_EQ_PRECISION
            }
        }

        on("clusterer cross validation") {
            val otherClusterer = EM() as DensityBasedClusterer
            val logLikelihoodActual = (subject as DensityBasedClusterer).crossValidate(iris, numFolds = 10, seed = 1)
            val logLikelihoodExpected: Double = ClusterEvaluation.crossValidateModel(otherClusterer, iris, 10, Random(1))

            it("should have the same log-likelihood") {
                (logLikelihoodActual - logLikelihoodExpected).absoluteValue `shouldBeLessThan` DOUBLE_EQ_PRECISION
            }
        }
    }
})