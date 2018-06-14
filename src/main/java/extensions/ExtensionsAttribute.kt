package extensions

import weka.core.Attribute

/**
 * Extensions for the Weka [Attribute] class.
 *
 * @author Steven Lang
 */

var Attribute.weight: Double
    get() = this.weight()
    set(value) = this.setWeight(value)