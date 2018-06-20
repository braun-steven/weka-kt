package extensions

import org.junit.Assert
import org.junit.Before
import org.junit.Test
import weka.classifiers.trees.J48
import weka.core.DenseInstance
import weka.core.Instances
import weka.core.OptionHandler

/**
 * Tests for Weka [weka.core.OptionHandler] extensions.
 *
 * @author Steven Lang
 */
class ExtensionsOptionHandlerTest : BaseTest() {

    @Test
    fun testSetOptions(){
        val j481: OptionHandler = J48()
        val j482: OptionHandler = J48()

        j481.setOptions("-M 5")
        j482.options = arrayOf("-M", "5")

        Assert.assertArrayEquals(j481.options, j482.options)
    }
}