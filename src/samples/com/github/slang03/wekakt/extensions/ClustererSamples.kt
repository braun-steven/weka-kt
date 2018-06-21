package com.github.slang03.wekakt.extensions

import com.github.slang03.wekakt.extensions.Instances
import com.github.slang03.wekakt.extensions.attributes
import com.github.slang03.wekakt.extensions.get
import weka.core.Attribute
import weka.core.Instance
import weka.core.Instances

private fun sampleMakeFilteredClusterer() {
    val em: Clusterer = EM()

    // Wrap with filter
    val filteredJ48 = em.makeFiltered(Resample()) {
        sampleSizePercent = 33.0
        noReplacement = true
    }
}

private fun sampleClustererEvaluateHoldout() {
    val em: Clusterer = EM()
    val iris: Instances = getIris()
    val (train, test) = iris.split(33.0)

    // Evaluate hold-out
    val eval: ClustererEvaluation = em.evaluate(trainData = train, testData = test)
}


private fun sampleClustererEvaluateHoldoutTestpercentage() {
    val em: Clusterer = EM()
    val iris: Instances = getIris()

    // Evaluate hold-out
    val eval: ClustererEvaluation = em.evaluate(data = iris, testPercentage = 33.0)
}

private fun sampleClustererEvaluateTestSet() {
    val em: Clusterer = EM()
    val iris: Instances = getIris()
    val (train, test) = iris.split(33.0)

    em.buildClusterer(train)

    // Evaluate hold-out on test set
    val eval: ClustererEvaluation = em.evaluateTestSet(data = test)
}

private fun sampleClustererCrossValidation() {
    val em: Clusterer = EM()
    val iris: Instances = getIris()

    // Evaluate cross-validation
    val eval: ClustererEvaluation = j48.crossValidate(data = iris, numFolds = 10, seed = 1)
}