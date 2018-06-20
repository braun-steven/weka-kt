import com.github.slang03.wekakt.extensions.Instances
import weka.classifiers.evaluation.Prediction
import java.util.ArrayList

fun getIris() = Instances("src/test/resources/datasets/iris.arff", classIndex = 4)

/**
 * Assert that two arrays of predictions are the same
 */
fun assertPredictionsAreEqual(preds1: ArrayList<Prediction>, preds2: ArrayList<Prediction>) {
    preds1.zip(preds2).forEach { (p1, p2) -> p1 `shouldEqualTo` p2 }
}