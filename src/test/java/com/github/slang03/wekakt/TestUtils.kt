package com.github.slang03.wekakt

import com.github.slang03.wekakt.extensions.Instances
import weka.classifiers.evaluation.Prediction
import java.util.ArrayList

/**
 * Precision of double equality
 */
const val DOUBLE_EQ_PRECISION = 1e-7

/**
 * Read the iris dataset.
 *
 * @return Iris dataset
 */
fun getIris() = Instances("src/test/resources/datasets/iris.arff", classIndex = 4)

/**
 * Assert that two arrays of predictions are the same
 */
fun assertPredictionsAreEqual(preds1: ArrayList<Prediction>, preds2: ArrayList<Prediction>) {
    preds1.zip(preds2).forEach { (p1, p2) -> p1 `shouldEqualTo` p2 }
}