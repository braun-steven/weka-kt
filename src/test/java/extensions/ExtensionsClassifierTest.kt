package extensions

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import weka.classifiers.Evaluation
import weka.classifiers.evaluation.Prediction
import weka.classifiers.trees.J48
import java.util.*
/**
 * Tests for Weka [weka.classifiers.Classifier] extensions.
 *
 * @author Steven Lang
 */
class ExtensionsClassifierTest : BaseTest() {

    /**
     * Base test classifier
     */
    lateinit var clf: J48

    @Before
    fun initClf() {
        clf = J48()
    }

    @Test
    fun testEvaluateHoldout() {
        val testPercentage = 33.0
        val (train, test) = iris.split(testPercentage)
        clf.buildClassifier(train)
        val eval = Evaluation(train)
        eval.evaluateModel(clf, test)
        val predsExpected: ArrayList<Prediction> = eval.predictions()

        val clf2 = J48()
        val evaluateHoldoutActual2: Evaluation = clf2.evaluateHoldout(train, test)
        val predsActual2: ArrayList<Prediction> = evaluateHoldoutActual2.predictions()

        val clf3 = J48()
        val evaluateHoldoutActual3: Evaluation = clf3.evaluateHoldout(iris, testPercentage)
        val predsActual3: ArrayList<Prediction> = evaluateHoldoutActual3.predictions()



        assertPredictionsAreEqual(predsExpected, predsActual2)
        assertPredictionsAreEqual(predsExpected, predsActual3)
    }

    @Test
    fun testCrossValidation() {
        val eval = Evaluation(iris)
        eval.crossValidateModel(clf, iris, 10, Random(1))
        val predsExpected: ArrayList<Prediction> = eval.predictions()

        val clf2 = J48()
        val evaluateHoldoutActual2: Evaluation = clf2.evaluateCrossValidation(iris, 10, 1)
        val predsActual2: ArrayList<Prediction> = evaluateHoldoutActual2.predictions()

        assertPredictionsAreEqual(predsExpected, predsActual2)
    }


    /**
     * Assert that two arrays of predictions are the same
     */
    fun assertPredictionsAreEqual(preds1: ArrayList<Prediction>, preds2: ArrayList<Prediction>) {
        for (i in 0 until preds1.size) {
            Assert.assertEquals(preds1[i].actual(), preds2[i].actual(), 1e-7)
            Assert.assertEquals(preds1[i].predicted(), preds2[i].predicted(), 1e-7)
        }
    }
}