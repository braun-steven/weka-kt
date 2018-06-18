package extensions

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import weka.core.DenseInstance
import weka.core.Instances

/**
 * Tests for Weka [weka.core.Instance] extensions.
 *
 * @author Steven Lang
 */
class ExtensionsInstanceTest : BaseTest() {

    @Test
    fun testGetSet() {
        val irisCopy = Instances(iris, iris.size)
        for (i in 0 until iris.size) {
            irisCopy.add(DenseInstance(iris.numAttributes()))

            for (j in 0 until iris[i].numAttributes) {
                irisCopy[i, j] = iris[i, j]
            }
        }

        Assert.assertTrue(iris.isEqualTo(irisCopy))
    }
}