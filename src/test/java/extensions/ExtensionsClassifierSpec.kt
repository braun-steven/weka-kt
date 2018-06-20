package extensions

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
 * Tests for Weka [weka.classifiers.Classifier] extensions.
 *
 * @author Steven Lang
 */

object ExtensionsClassifierSpec : SubjectSpek<Classifier>({

    /**
     * Assert that two arrays of predictions are the same
     */
    fun assertPredictionsAreEqual(preds1: ArrayList<Prediction>, preds2: ArrayList<Prediction>) {
        preds1.zip(preds2).forEach {(p1, p2) -> p1 `shouldEqualTo` p2}
    }

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
            val evaluateHoldoutActual2: Evaluation = clf2.evaluateHoldout(train, test)
            val predsActual2: ArrayList<Prediction> = evaluateHoldoutActual2.predictions()

            it("should calculate the same predictions"){
                assertPredictionsAreEqual(predsExpected, predsActual2)
            }
        }
    }
})