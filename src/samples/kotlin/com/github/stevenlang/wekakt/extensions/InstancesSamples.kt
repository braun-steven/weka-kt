package com.github.stevenlang.wekakt.extensions

private fun sampleGetInstanceByIndex() {
    val iris: Instances = getIris()
    val row: Instance = iris[4]
}

private fun sampleGetValueAtRowAndAttributeIndex() {
    val iris: Instances = getIris()
    val value: Double = iris[4, 0]
}

private fun sampleGetValueAtRowIndexAndAttribute() {
    val iris: Instances = getIris()
    val att: Attribute = iris.attributes[0]
    val value: Double = iris[4, att]
}

private fun sampleSetInstanceByRowIndex() {
    val iris: Instances = getIris()
    val row: Instance = iris[4]
    iris[5] = row
}

private fun sampleSetValueAtRowIndexAndAttributeIndex() {
    val iris: Instances = getIris()
    iris[4, 0] = 12.0
}

private fun sampleSetValueAtRowIndexAndAttribute() {
    val iris: Instances = getIris()
    val att: Attribute = iris.attributes[0]
    iris[4, att] = 12.0
}

private fun sampleSetStringValueAtRowIndexAndAttributeIndex() {
    val data: Instances = getData()
    data[4, 0] = "car"
}

private fun sampleSetStringValueAtRowIndexAndAttribute() {
    val data: Instances = getData()
    val att: Attribute = data.attributes[0]
    data[4, att] = "car"
}

private fun sampleInstancesConstructorWithFilePath() {
    val iris = Instances("src/test/resources/datasets/iris.arff", classIndex = 4)
}

private fun sampleApplyFilterOnData() {
    // Get data
    val iris: Instances = getIris()

    // Filter percentage
    irisFiltered = iris.filter(RemovePercentage()) {
        percentage = 20.0
        invertSelection = true
    }
}

private fun sampleSplitData() {
    val iris: Instances = getIris()

    // Split
    val (train, test) = iris.split(testPercentage = 33.0)
}

private fun sampleGetRowAndAttributeIndexRange(){
    val iris: Instances = getIris()

    // Get rows from 5 to 50 and attributes from 2 to 3
    val irisReduces: Instances = iris[5..50, 2..3]
}

private fun sampleGetRowsByIndexRange(){
    val iris: Instances = getIris()

    // Get rows from 5 to 50
    val rows: Instances = iris[5..50]
}


private fun sampleRemoveAttribute(){
    val iris: Instances = getIris()

    // Remove the third attribute
    val irisReduced: Instances = iris.removeAttribute(3)
}


private fun sampleRemoveClassAttribute() {
    val iris: Instances = getIris()

    // Remove the class attribute
    val irisWithoutClass: Instances = iris.removeClassAttribute()
}

