package com.github.stevenlang.wekakt.extensions.classifier

import com.github.stevenlang.wekakt.extensions.instances.split
import weka.classifiers.Classifier
import weka.classifiers.Evaluation
import weka.classifiers.meta.FilteredClassifier
import weka.core.Instances
import weka.filters.Filter
import java.util.*

/*
 * Extensions for the Weka [Classifier] class.
 *
 * @author Steven Lang
 */

/**
 * Wraps this classifier in a [FilteredClassifier] and adds the given [filter] object.
 *
 * @param filter Filter to use in the [FilteredClassifier] object
 * @param body Body to execute in [filter]
 * @param T Filter class
 * @return [FilteredClassifier] instance
 * @sample sampleMakeFilteredClassifier
 */
fun <T : Filter> Classifier.makeFiltered(filter: T, body: T.() -> Unit): FilteredClassifier {
    val wrapper = FilteredClassifier()
    filter.body()
    wrapper.filter = filter
    wrapper.classifier = this
    return wrapper
}

/**
 * Create a holdout evaluation. Builds the classifier and tests it on the given test set.
 *
 * @param trainData Training data
 * @param testData Testing data
 * @return Evaluation object containing predictions and statistics
 * @sample sampleClassifierEvaluateHoldoutTrainTest
 */
fun Classifier.evaluateHoldout(trainData: Instances, testData: Instances): Evaluation {
    // Build on train data
    buildClassifier(trainData)

    // Create evaluation
    val eval = Evaluation(trainData)
    eval.evaluateModel(this, testData)
    return eval
}

/**
 * Create a holdout evaluation. Builds the classifier and tests it on the given test set.
 *
 * @param data Input dataset
 * @param testPercentage Testing data split percentage
 * @return Evaluation object containing predictions and statistics
 * @sample sampleClassifierEvaluateHoldoutTestpercentage
 */
fun Classifier.evaluateHoldout(data: Instances, testPercentage: Double): Evaluation {
    // Split dataset
    val (trainData, testData) = data.split(testPercentage)

    return evaluateHoldout(trainData, testData)
}

/**
 * Create a crossvalidation evalution.
 *
 * @param data Input data
 * @param numFolds Number of cross validation folds
 * @param seed Seed for picking random datapoints for train/test sets
 * @return Evaluation object containing predictions and statistics
 * @sample sampleClassifierCrossValidation
 */
fun Classifier.evaluateCrossValidation(data: Instances, numFolds: Int = 10, seed: Long = 1): Evaluation {
    val eval = Evaluation(data)
    eval.crossValidateModel(this, data, numFolds, Random(seed))
    return eval
}