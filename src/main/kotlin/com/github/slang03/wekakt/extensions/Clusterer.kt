package com.github.slang03.wekakt.extensions

import weka.classifiers.meta.FilteredClassifier
import weka.clusterers.ClusterEvaluation
import weka.clusterers.Clusterer
import weka.clusterers.DensityBasedClusterer
import weka.clusterers.FilteredClusterer
import weka.core.Instances
import weka.filters.Filter
import java.util.*

/*
 * Extensions for the Weka [Clusterer] class.
 *
 * @author Steven Lang
 */

/**
 * Wraps this classifier in a [FilteredClusterer] and adds the given [filter] object.
 *
 * @param filter Filter to use in the [FilteredClusterer] object
 * @param body Body to execute in [filter]
 * @param T Filter class
 * @return [FilteredClusterer] instance
 * @sample sampleMakeFilteredClusterer
 */
fun <T : Filter> Clusterer.makeFiltered(filter: T, body: T.() -> Unit): FilteredClusterer {
    val wrapper = FilteredClusterer()
    filter.body()
    wrapper.filter = filter
    wrapper.clusterer = this
    return wrapper
}

/**
 * Create a clusterer evaluation. Builds the clusterer and tests it on the given test set.
 *
 * @param trainData Training data
 * @param testData Testing data
 * @return Clusterer evaluation
 * @sample sampleClustererEvaluateHoldout
 */
fun Clusterer.evaluate(trainData: Instances, testData: Instances): ClusterEvaluation {
    if (trainData.classIndex >= 0 && testData.classIndex >= 0 && trainData.classIndex == testData.classIndex){
        this.buildClusterer(trainData.removeClassAttribute())
    } else {
        this.buildClusterer(trainData)
    }

    return evaluateTestSet(testData)
}

/**
 * Create a clusterer evaluation. Split input data into train and test set. Builds the clusterer
 * on the training set and tests it on the test set.
 *
 * @param data Input dataset
 * @param testPercentage Testing data split percentage
 * @return Clusterer evaluation
 * @sample sampleClustererEvaluateHoldoutTestpercentage
 */
fun Clusterer.evaluate(data: Instances, testPercentage: Double): ClusterEvaluation {
    val (train, test) = data.split(testPercentage)
    return evaluate(train, test)
}

/**
 * Create a clusterer evaluation. Tests the clusterer on the given test set.
 *
 * @param testData Testing data
 * @return Clusterer evaluation
 * @sample sampleClustererEvaluateTestSet
 */
fun Clusterer.evaluateTestSet(testData: Instances): ClusterEvaluation {
    val eval = ClusterEvaluation()
    eval.setClusterer(this)
    eval.evaluateClusterer(testData)
    return eval
}

/**
 * Cross validate this density based clusterer on the given data.
 *
 * @param data Cross validation data
 * @param numFolds Number of folds
 * @param seed Seed for random number generator
 * @return Cross validation log-likelihood
 * @sample sampleClustererCrossValidation
 */
fun DensityBasedClusterer.crossValidate(data: Instances, numFolds: Int = 10, seed: Long = 1): Double {
    return ClusterEvaluation.crossValidateModel(this, data, numFolds, Random(seed))
}