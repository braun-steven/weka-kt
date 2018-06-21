package com.github.stevenlang.wekakt.extensions

import weka.core.Attribute

/*
 * Extensions for the Weka [Attribute] class.
 *
 * @author Steven Lang
 */

/**
 * Attribute weight.
 */
var Attribute.weight: Double
    get() = this.weight()
    set(value) = this.setWeight(value)