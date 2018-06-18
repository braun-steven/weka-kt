package extensions

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import weka.core.DenseInstance
import weka.core.Instances
import weka.filters.Filter
import weka.filters.unsupervised.instance.RemovePercentage

/**
 * Tests for Weka [Instances] extensions.
 *
 * @author Steven Lang
 */
class ExtensionsInstancesTest {

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
            irisCopy[i] = iris[i]

            Assert.assertTrue(iris[i].isEqualTo(irisCopy[i]))
        }
    }

    @Test
    fun testFilter() {
        val rp = RemovePercentage()
        rp.invertSelection = false
        rp.percentage = 20.0
        rp.setInputFormat(iris)

        val filteredWeka = Filter.useFilter(iris, rp)
        val filteredKotlin = iris.filter(RemovePercentage()) {
            invertSelection = false
            percentage = 20.0
        }

        Assert.assertTrue(filteredWeka.isEqualTo(filteredKotlin))
    }

    @Test
    fun testSplit(){
        val percentage = 33.0
        val (split1, split2) = iris.split(percentage)

        val removePercentage1 = RemovePercentage()
        removePercentage1.percentage = percentage
        removePercentage1.setInputFormat(iris)

        val removePercentage2 = RemovePercentage()
        removePercentage2.percentage = percentage
        removePercentage2.invertSelection = true
        removePercentage2.setInputFormat(iris)

        val split1Weka = Filter.useFilter(iris, removePercentage1)
        val split2Weka = Filter.useFilter(iris, removePercentage2)

        Assert.assertEquals(split1.size, split1Weka.size)
        Assert.assertEquals(split2.size, split2Weka.size)
        Assert.assertTrue(split1.isEqualTo(split1Weka))
        Assert.assertTrue(split2.isEqualTo(split2Weka))
    }
}