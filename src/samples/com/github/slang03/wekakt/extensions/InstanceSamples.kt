package com.github.slang03.wekakt.extensions

import com.github.slang03.wekakt.extensions.Instances
import com.github.slang03.wekakt.extensions.attributes
import com.github.slang03.wekakt.extensions.get
import weka.core.Attribute
import weka.core.Instance
import weka.core.Instances

internal fun sampleGetValueByAttributeIndex(){
    val iris: Instances = getIris()
    val row: Instance = iris[4]
    val value: Double = row[2]
}

private fun sampleGetValueByAttribute(){
    val iris: Instances = getIris()
    val sepalLengthAtt: Attribute = iris.attributes[0]
    val row: Instance = iris[4]
    val value: Double = row[sepalLengthAtt]
}

private fun sampleSetValueByAttributeIndex(){
    val iris: Instances = getIris()
    val row: Instance = iris[4]
    row[0] = 12.0
}

private fun sampleSetValueByAttribute(){
    val iris: Instances = getIris()
    val sepalLengthAtt: Attribute = iris.attributes[0]
    val row: Instance = iris[4]
    row[sepalLengthAtt] = 12.0
}