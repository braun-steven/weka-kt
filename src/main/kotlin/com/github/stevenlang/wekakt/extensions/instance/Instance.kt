package com.github.stevenlang.wekakt.extensions.instance

import weka.core.Attribute
import weka.core.Instance

/*
 * Extensions for the Weka [Instance] class.
 *
 * @author Steven Lang
 */

/**
 * Get the attribute value at [attributeIndex].
 * @param attributeIndex Attribute index
 * @return Value at [attributeIndex]
 * @sample sampleGetValueByAttributeIndex
 */
operator fun Instance.get(attributeIndex: Int) = this.value(attributeIndex)


/**
 * Get the attribute value for [attribute].
 * @param attribute Attribute
 * @return Value for [attribute]
 * @sample sampleGetValueByAttribute
 */
operator fun Instance.get(attribute: Attribute) = this.value(attribute)

/**
 * Set the attribute value at [attributeIndex].
 * @param [attributeIndex] Attribute index
 * @param [value] Attribute value
 * @sample sampleSetValueByAttributeIndex
 */
operator fun Instance.set(attributeIndex: Int, value: Number) = this.setValue(attributeIndex, value.toDouble())

/**
 * Set the attribute value at [attributeIndex].
 * @param [attributeIndex] Attribute index
 * @param [value] Attribute value
 * @sample sampleSetValueByAttributeIndex
 */
operator fun Instance.set(attributeIndex: Int, value: String) = this.setValue(attributeIndex, value)

/**
 * Set the attribute value of [attribute].
 * @param [attribute] Attribute
 * @param [value] Attribute value
 * @param sampleSetValueByAttribute
 */
operator fun Instance.set(attribute: Attribute, value: Number) = this.setValue(attribute, value.toDouble())

/**
 * Set the attribute value of [attribute].
 * @param [attribute] Attribute
 * @param [value] Attribute value
 * @param sampleSetValueByAttribute
 */
operator fun Instance.set(attribute: Attribute, value: String) = this.setValue(attribute, value)

/**
 * Number of attributes.
 */
val Instance.numAttributes: Int
    get() = this.numAttributes()

/**
 * Check if this instance is equal to another instance object.
 *
 * @param other Other instance to compare with
 * @return True if this is equal to [other]
 */
fun Instance.isEqualTo(other: Any?): Boolean {
    if (other == null) {
        return false
    }

    if (other !is Instance) {
        return false
    }

    if (other.numAttributes != this.numAttributes) {
        return false
    }

    // Check if all values match
    return (0 until this.numAttributes).all { i -> Math.abs(this[i] - other[i]) < 1e-7 }
}
