package extensions

import org.junit.Before
import weka.core.Instances

abstract class BaseTest {

    /**
     * Test dataset
     */
    lateinit var iris: Instances

    @Before
    fun init() {
        iris = Instances("src/test/resources/datasets/iris.arff", classIndex = 4)
    }
}