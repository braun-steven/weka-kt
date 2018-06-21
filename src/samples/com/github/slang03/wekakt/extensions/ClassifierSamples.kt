package com.github.slang03.wekakt.extensions

import com.github.slang03.wekakt.extensions.Instances
import com.github.slang03.wekakt.extensions.attributes
import com.github.slang03.wekakt.extensions.get
import weka.core.Attribute
import weka.core.Instance
import weka.core.Instances

private fun sampleMakeFilteredClassifier() {
    val j48: Classifier = J48()

    // Wrap with filter
    val filteredJ48 = j48.makeFiltered(Resample()) {
        sampleSizePercent = 33.0
        noReplacement = true
    }
}

private fun sampleClassifierEvaluateHoldoutTrainTest() {
    val j48: Classifier = J48()
    val iris: Instances = getIris()
    val (train, test) = iris.split(33.0)

    // Evaluate hold-out
    val eval: Evaluation = j48.evaluateHoldout(trainData = train, testData = test)
}

private fun sampleClassifierEvaluateHoldoutTestpercentage() {
    val j48: Classifier = J48()
    val iris: Instances = getIris()

    // Evaluate hold-out
    val eval: Evaluation = j48.evaluateHoldout(data = iris, testPercentage = 33.0)
}

private fun sampleClassifierCrossValidation() {
    val j48: Classifier = J48()
    val iris: Instances = getIris()

    // Evaluate cross-validation
    val eval: Evaluation = j48.evaluateCrossValidation(data = iris, numFolds = 10, seed = 1)
}