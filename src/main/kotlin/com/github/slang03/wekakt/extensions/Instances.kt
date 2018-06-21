package com.github.slang03.wekakt.extensions

import weka.core.Attribute
import weka.core.Instance
import weka.core.Instances
import weka.core.WekaException
import weka.core.converters.ArffLoader
import weka.core.converters.CSVLoader
import weka.core.converters.ConverterUtils
import weka.core.converters.Loader
import weka.filters.Filter
import weka.filters.unsupervised.attribute.Remove
import weka.filters.unsupervised.instance.RemovePercentage
import weka.filters.unsupervised.instance.RemoveRange
import java.io.File

/*
 * Extensions for the Weka [weka.core.Instances] class.
 *
 * @author Steven Lang
 */

/**
 * Get the instance at index [rowIndex].
 * @param [rowIndex] Row index
 * @return Instance at [rowIndex]
 * @sample sampleGetInstanceByIndex
 */
operator fun Instances.get(rowIndex: Int): Instance = this.instance(rowIndex)

/**
 * Get the value at position ([rowIndex],[attributeIndex]).
 *
 * @param [rowIndex] Row index
 * @param [attributeIndex] Attribute index
 * @return Value at position ([rowIndex],[attributeIndex])
 * @sample sampleGetValueAtRowAndAttributeIndex
 */
operator fun Instances.get(rowIndex: Int, attributeIndex: Int) = this[rowIndex][attributeIndex]

/**
 * Get the value at position ([rowIndex],[attribute]).
 *
 * @param [rowIndex] Row index
 * @param [attribute] Attribute
 * @return Value at position ([rowIndex],[attribute])
 * @sample sampleGetValueAtRowIndexAndAttribute
 */
operator fun Instances.get(rowIndex: Int, attribute: Attribute) = this[rowIndex][attribute]

/**
 * Set the instance at position [rowIndex]
 *
 * @param [rowIndex] Row index
 * @param [instance] Row instance
 * @sample sampleSetInstanceByRowIndex
 */
operator fun Instances.set(rowIndex: Int, instance: Instance): Instance = this.set(rowIndex, instance)

/**
 * Set the value at position ([rowIndex],[attributeIndex]).
 *
 * @param [rowIndex] Row index
 * @param [attributeIndex] Attribute index
 * @param [value] Value
 * @sample sampleSetValueAtRowIndexAndAttributeIndex
 */
operator fun Instances.set(rowIndex: Int, attributeIndex: Int, value: Number) = this[rowIndex].set(attributeIndex, value)

/**
 * Set the value at position ([rowIndex],[attribute]).
 *
 * @param [rowIndex] Row index
 * @param [attribute] Attribute
 * @param [value] Value
 * @sample sampleSetValueAtRowIndexAndAttribute
 */
operator fun Instances.set(rowIndex: Int, attribute: Attribute, value: Number) = this[rowIndex].set(attribute, value)

/**
 * Set string value at position ([rowIndex],[attributeIndex]).
 *
 * @param [rowIndex] Row index
 * @param [attributeIndex] Attribute index
 * @param [value] Value
 * @sample sampleSetStringValueAtRowIndexAndAttributeIndex
 */
operator fun Instances.set(rowIndex: Int, attributeIndex: Int, value: String) = this[rowIndex].set(attributeIndex, value)

/**
 * Set string value at position ([rowIndex],[attribute]).
 *
 * @param [rowIndex] Row index
 * @param [attribute] Attribute
 * @param [value] Value
 * @sample sampleSetStringValueAtRowIndexAndAttribute
 */
operator fun Instances.set(rowIndex: Int, attribute: Attribute, value: String) = this[rowIndex].set(attribute, value)

/**
 * Class index.
 */
var Instances.classIndex: Int
    get() = this.classIndex()
    set(value) = this.setClassIndex(value)


/**
 * Number of attributes.
 */
val Instances.numAttributes: Int
    get() = this.numAttributes()

/**
 * List of attributes.
 */
val Instances.attributes: List<Attribute>
    get() = this.enumerateAttributes().toList()

/**
 * Create a new Instances object based on a given filepath.
 * Imitates constructor extension via function.
 *
 * @param filePath Path to the dataset file
 * @param classIndex The class index of the dataset
 * @return A new Instances object, loaded from the given file path
 * @sample sampleInstancesConstructorWithFilePath
 */
fun Instances(filePath: String, classIndex: Int = -1): Instances {
    val dataSet = ConverterUtils.DataSource.read(filePath)

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
 * @sample sampleApplyFilterOnData
 */
fun <T : Filter> Instances.filter(filter: T, body: T.() -> Unit = {}): Instances {
    filter.body()
    filter.setInputFormat(this)
    return Filter.useFilter(this, filter)
}


/**
 * Check if this instances is equal to another instances object.
 *
 * @return True if this is equal to [other]
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
 * Split this dataset into two separate sets with a given [testPercentage].
 *
 * @param testPercentage Test split percentage.
 * @sample sampleSplitData
 */
fun Instances.split(testPercentage: Double): Pair<Instances, Instances> {
    // Define filter according to the given split percentage
    val removePercentage = RemovePercentage().apply { this.percentage = testPercentage }

    // Split dataset
    val split1 = this.filter(removePercentage)
    val split2 = this.filter(removePercentage, { invertSelection = true })

    return Pair(split1, split2)
}

/**
 * Slice the given range of attributes out of the dataset.
 *
 * @param range Range of ints indicating the slice interval
 * @return Subset of this dataset, that is only the attributes in the given range are in the result
 * @sample sampleSliceAttributesRange
 */
fun Instances.sliceAttributes(range: IntRange): Instances {
    return this.filter(Remove()) {
        val rangeString = "${range.start + 1}-${range.endInclusive + 1}"
        invertSelection = true
        attributeIndices = rangeString
    }
}


/**
 * Slice the given range of rows out of the dataset.
 *
 * @param range Range of ints indicating the slice interval
 * @return Subset of this dataset, that is only the rows in the given range are in the result
 * @sample sampleSliceRowsRange
 */
fun Instances.sliceRows(range: IntRange): Instances {
    return this.filter(RemoveRange()) {
        invertSelection = true
        instancesIndices = "${range.start + 1}-${range.endInclusive + 1}"
    }
}

/**
 * Slice the given range of attributes out of the dataset.
 *
 * @param rangeRows Range of ints indicating the row slice interval
 * @param rangeAttributes Range of ints indicating the attribute slice interval
 * @return Subset of this dataset, that is only the attributes and rows in the given ranges are in
 * the result
 * @sample sampleSliceRowsandAttributesRange
 */
fun Instances.slice(rangeRows: IntRange, rangeAttributes: IntRange): Instances {
    return this.sliceRows(rangeRows).sliceAttributes(rangeAttributes)
}

/**
 * Get the subset of rows with the given indices.
 *
 * @param indices List of indices to return the rows of
 * @return Subset of this dataset containing only the rows specified in [indices]
 * @sample sampleSliceRowsIndices
 */
fun Instances.sliceRows(vararg indices: Int): Instances {
    return this.filter(RemoveRange()) {
        val rangeString = indices.joinToString(separator = ",", transform = { i -> "${i + 1}" })
        invertSelection = true
        instancesIndices = rangeString
    }
}

/**
 * Get the subset of attributes with the given indices.
 *
 * @param indices List of indices to return the attributes of
 * @return Subset of this dataset containing only the attributes specified in [indices]
 * @sample sampleSliceAttributeIndices
 */
fun Instances.sliceAttributes(vararg indices: Int): Instances {
    return this.filter(Remove()) {
        val rangeString = indices.joinToString(separator = ",", transform = { i -> "${i + 1}" })
        invertSelection = true
        attributeIndices = rangeString
    }
}

/**
 * Slice the given range of attributes out of the dataset.
 *
 * @param rangeRows Range of ints indicating the row slice interval
 * @param rangeAttributes Range of ints indicating the attribute slice interval
 * @return Subset of this dataset, that is only the attributes and rows in the given ranges are in
 * the result
 * @see [Instances.slice]
 * @sample sampleGetRowAndAttributeIndexRange
 */
operator fun Instances.get(rangeRows: IntRange, rangeAttributes: IntRange): Instances {
    return slice(rangeRows, rangeAttributes)
}

/**
 * Remove a given attribute by index.
 * @param attIndex Attribute index
 * @return This data without the specified attribute
 * @sample sampleRemoveAttribute
 */
fun Instances.removeAttribute(attIndex: Int): Instances {
    return filter(Remove()) {
        attributeIndices = (attIndex + 1).toString()
    }
}

/**
 * Remove the class attribute of this dataset.
 * @return This data without the class attribute
 * @sample sampleRemoveClassAttribute
 */
fun Instances.removeClassAttribute(): Instances {
    if (this.classIndex >= 0) {
        return removeAttribute(classIndex)
    } else {
        throw WekaException("Dataset does not define a class attribute. Class index was $classIndex.")
    }
}