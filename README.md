[![Maven Central](https://img.shields.io/maven-central/v/com.github.slang03/weka-kt.svg?label=Maven%20Central)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.slang03%22%20a%3A%22weka-kt%22)

# Weka-Kt: Kotlin Extensions for Weka
A set of Kotlin extensions for Weka. The goal is to make the use of Weka more convenient and ideomatic.

## Getting Started
To add Weka-Kt to your project, add the following dependency to your pom file:
```xml
<dependency>
    <groupId>com.github.slang03</groupId>
    <artifactId>weka-kt</artifactId>
    <version>0.0.2</version>
</dependency>
```

## Extensions

### Loading Data
- Java
```java
ArffLoader loader = new ArffLoader();
loader.setFile(new File("src/test/resources/datasets/iris.arff"));
Instances irisData = loader.getDataSet();
irisData.setClassIndex(4);
```
- Kotlin
```kotlin
var irisData = Instances("src/test/resources/datasets/iris.arff", classIndex = 4)
```

### Getting/Setting Data
- Java
```java
// Get row
Instance row = irisData.get(5);

// Get value
double valueByIndex = irisData.get(5).value(3);

// Get attribute
Attribute attribute = irisData.attribute(3);

// Get value by attribute
double valueByAttribute = row.value(attribute);

// Set row
irisData.set(6, row);

// Set value at index (6,3)
Instance editRow = irisData.get(6);
editRow.setValue(3, 100.0);
irisData.set(6, editRow);
```
- Kotlin
```kotlin
// Get row
val row = irisData[5]

// Get value
val valueByIndex = irisData[5, 3]

// Get attribute
val attribute = irisData.attributes[3]

// Get value by attribute
val valueByAttribute = row[attribute]

// Set row
irisData[6] = row

// Set value at index (6,3)
irisData[6, 3] = 100.0
```
### Using Filters
- Java
```java
// Filter percentage
RemovePercentage removePercentage = new RemovePercentage();
removePercentage.setPercentage(20.0);
removePercentage.setInvertSelection(true);
removePercentage.setInputFormat(irisData);
irisData = Filter.useFilter(irisData, removePercentage);

// Filter attributes
Remove remove = new Remove();
remove.setAttributeIndices("1,2");
remove.setInvertSelection(false);
remove.setInputFormat(irisData);
irisData = Filter.useFilter(irisData, remove);

// Resample data
Resample resample = new Resample();
resample.setRandomSeed(42);
resample.setNoReplacement(false);
resample.setSampleSizePercent(66.0);
resample.setInputFormat(irisData);
irisData = Filter.useFilter(irisData, resample);
```
- Kotlin
```kotlin
// Filter percentage
irisData = irisData.filter(RemovePercentage()) {
    percentage = 20.0
    invertSelection = true
}

// Filter attributes
irisData = irisData.filter(Remove()) {
    attributeIndices = "1,2"
    invertSelection = false
}

// Resample data
irisData = irisData.filter(Resample()) {
    noReplacement = false
    randomSeed = 42
    sampleSizePercent = 66.0
}
```
