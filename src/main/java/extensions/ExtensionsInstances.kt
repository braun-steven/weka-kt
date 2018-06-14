package extensions

import weka.core.Attribute
import weka.core.Instance
import weka.core.Instances
import weka.core.converters.ArffLoader
import weka.core.converters.CSVLoader
import weka.core.converters.Loader
import weka.filters.Filter
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
    if (classIndex > 0) {
        dataSet.classIndex = -1
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
fun <T : Filter> Instances.filter(filter: T, body: T.() -> Unit): Instances {
    filter.body()
    filter.setInputFormat(this)
    return Filter.useFilter(this, filter)
}


