package extensions

import weka.core.Attribute
import weka.core.Instance

/**
 * Extensions for the Weka [Instance] class.
 *
 * @author Steven Lang
 */

operator fun Instance.get(attributeIndex: Int) = this.value(attributeIndex)

operator fun Instance.get(attribute: Attribute) = this.value(attribute)
operator fun Instance.set(attributeIndex: Int, value: Double) = this.setValue(attributeIndex, value)
operator fun Instance.set(attributeIndex: Int, value: String) = this.setValue(attributeIndex, value)
operator fun Instance.set(attribute: Attribute, value: Double) = this.setValue(attribute, value)
operator fun Instance.set(attribute: Attribute, value: String) = this.setValue(attribute, value)

val Instance.numAttributes: Int
    get() = this.numAttributes()

/**
 * Cannot directly overload [Instance.equals] via extensions as they are statically resolved.
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
