package com.github.stevenlang.wekakt.extensions

import com.github.stevenlang.wekakt.extensions.Instances
import com.github.stevenlang.wekakt.extensions.attributes
import com.github.stevenlang.wekakt.extensions.get
import weka.core.Attribute
import weka.core.Instance
import weka.core.Instances

private fun sampleOptionHandlerSetOptions(){
    val clf: Classifier = J48()
    clf.setOptions("-M 5 -U")
}