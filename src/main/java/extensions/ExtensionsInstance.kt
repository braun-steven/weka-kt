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
