package extensions

import weka.core.Attribute
import weka.core.Instance
import weka.core.Instances
import weka.core.converters.ArffLoader
import weka.core.converters.CSVLoader
import weka.core.converters.Loader
import weka.filters.Filter
import weka.filters.unsupervised.instance.RemovePercentage
import java.io.File

/**
 * Extensions for the Weka [weka.core.Instances] class.
 *
 * @author Steven Lang
 */

operator fun Instances.get(i: Int): Instance = this.instance(i)

operator fun Instances.get(i: Int, attributeIndex: Int) = this[i][attributeIndex]
operator fun Instances.get(i: Int, attribute: Attribute) = this[i][attribute]

operator fun Instances.set(i: Int, instance: Instance): Instance = this.set(i, instance)
operator fun Instances.set(i: Int, attributeIndex: Int, value: Double) = this[i].set(attributeIndex, value)
operator fun Instances.set(i: Int, attribute: Attribute, value: Double) = this[i].set(attribute, value)
operator fun Instances.set(i: Int, attributeIndex: Int, value: String) = this[i].set(attributeIndex, value)
operator fun Instances.set(i: Int, attribute: Attribute, value: String) = this[i].set(attribute, value)


var Instances.classIndex: Int
    get() = this.classIndex()
    set(value) = this.setClassIndex(value)

val Instances.numAttributes: Int
    get() = this.numAttributes()

val Instances.attributes: List<Attribute>
    get() = this.enumerateAttributes().toList()

/**
 * Create a new Instances object based on a given filepath
 * Imitates constructor extension via function.
 *
 * @param filePath Path to the dataset file
 * @param classIndex The class index of the dataset
 * @return A new Instances object, loaded from the given file path
 */
fun Instances(filePath: String, classIndex: Int = -1): Instances {
    val loader: Loader

    // Use loader depending on file-ending
    if (filePath.endsWith(".csv")) {
        loader = CSVLoader()
    } else {
        // Try ArffLoader as default
        loader = ArffLoader()
    }

    // Load the dataset
    loader.setSource(File(filePath))
    val dataSet = loader.dataSet

    // Set class index
    if (classIndex >= 0) {
        dataSet.classIndex = classIndex
    }

    return dataSet
}

/**
 * Apply a given filter to this set of instances.
 *
 * @param filter Filter instance
 * @param body Filter function body
 * @param T inheriting from [Filter]
 */
fun <T : Filter> Instances.filter(filter: T, body: T.() -> Unit = {}): Instances {
    filter.body()
    filter.setInputFormat(this)
    return Filter.useFilter(this, filter)
}


/**
 * Cannot directly overload [Instances.equals] via extensions as they are statically resolved.
 */
fun Instances.isEqualTo(other: Any?): Boolean {
    if (other == null) {
        return false
    }

    if (other !is Instances) {
        return false
    }

    if (other.numAttributes != this.numAttributes) {
        return false
    }

    if (other.size != this.size) {
        return false
    }

    // Check if all values match
    return (0 until this.size).all { i -> this[i].isEqualTo(other[i]) }
}

/**
 * Split this dataset into two separate sets with a given splitpercentage.
 *
 * @param testPercentage Test split percentage.
 */
fun Instances.split(testPercentage: Double): Pair<Instances, Instances> {
    // Define filter according to the given split percentage
    val removePercentage = RemovePercentage().apply { this.percentage = testPercentage }

    // Split dataset
    val split1 = this.filter(removePercentage)
    val split2 = this.filter(removePercentage, { invertSelection = true })

    return Pair(split1, split2)
}

