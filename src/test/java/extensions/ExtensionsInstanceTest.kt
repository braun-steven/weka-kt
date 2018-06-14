package extensions

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import weka.core.DenseInstance
import weka.core.Instances
import weka.filters.Filter
import weka.filters.unsupervised.instance.RemovePercentage

/**
 * Tests for Weka [weka.core.Instance] extensions.
 *
 * @author Steven Lang
 */
class ExtensionsInstanceTest {

    /**
     * Test dataset
     */
    private lateinit var iris: Instances

    @Before
    fun init() {
        iris = Instances("src/test/resources/datasets/iris.arff")
    }

    @Test
    fun testGetSet() {
        val irisCopy = Instances(iris, iris.size)
        for (i in 0 until iris.size) {
            irisCopy.add(DenseInstance(iris.numAttributes()))

            for(j in 0 until iris[i].numAttributes){
                irisCopy[i, j] = iris[i, j]
            }
        }

        Assert.assertTrue(iris.isEquals(irisCopy))
    }
}