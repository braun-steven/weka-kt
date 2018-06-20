package com.github.slang03.wekakt.extensions

import weka.core.OptionHandler


/**
 * Extensions for the Weka [weka.core.OptionHandler] class.
 *
 * @author Steven Lang
 */

fun OptionHandler.setOptions(str: String) {
    options = weka.core.Utils.splitOptions(str)
}