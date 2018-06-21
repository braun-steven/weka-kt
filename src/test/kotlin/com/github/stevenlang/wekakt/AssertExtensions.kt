package com.github.stevenlang.wekakt

import com.github.stevenlang.wekakt.extensions.isEqualTo
import org.amshove.kluent.shouldBeLessThan
import org.junit.Assert
import weka.classifiers.evaluation.Prediction
import weka.core.Instances
import kotlin.math.absoluteValue

/**
 * Infix function to assert that two predictions are the same.
 * Usage:
 * ```
 * pred1 `shouldEqualTo` pred2
 * ```
 * @param other Other prediction to compare it to
 */
infix fun Prediction.shouldEqualTo(other: Prediction) {
    // Get values
    val y1True = this.actual()
    val y2True = other.actual()
    val y1Pred = this.predicted()
    val y2Pred = other.predicted()
    val y1Weight = this.weight();
    val y2Weight = other.weight();

    // Assert equality
    (y1True - y2True).absoluteValue `shouldBeLessThan` DOUBLE_EQ_PRECISION
    (y1Pred - y2Pred).absoluteValue `shouldBeLessThan` DOUBLE_EQ_PRECISION
    (y1Weight - y2Weight).absoluteValue `shouldBeLessThan` DOUBLE_EQ_PRECISION
}

/**
 * Infix function to assert equality between two instances.
 * ```
 * inst1 `shouldEqualTo` inst2
 * ```
 */
infix fun Instances.shouldEqualTo(other: Instances) {
    Assert.assertTrue(this.isEqualTo(other))
}