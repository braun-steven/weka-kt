package com.github.slang03.wekakt.extensions

import com.github.slang03.wekakt.extensions.Instances
import com.github.slang03.wekakt.extensions.attributes
import com.github.slang03.wekakt.extensions.get
import weka.core.Attribute
import weka.core.Instance
import weka.core.Instances

private fun sampleOptionHandlerSetOptions(){
    val clf: Classifier = J48()
    clf.setOptions("-M 5 -U")
}