[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.clusterers.Clusterer](index.md) / [evaluate](./evaluate.md)

# evaluate

`fun `[`Clusterer`](http://weka.sourceforge.net/doc.stable/weka/clusterers/Clusterer.html)`.evaluate(trainData: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`, testData: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`): `[`ClusterEvaluation`](http://weka.sourceforge.net/doc.stable/weka/clusterers/ClusterEvaluation.html)

Create a clusterer evaluation. Builds the clusterer and tests it on the given test set.

``` kotlin
//Unresolved: sampleClustererEvaluateHoldout
```

### Parameters

`trainData` - Training data

`testData` - Testing data

**Return**
Clusterer evaluation

`fun `[`Clusterer`](http://weka.sourceforge.net/doc.stable/weka/clusterers/Clusterer.html)`.evaluate(data: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`, testPercentage: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`ClusterEvaluation`](http://weka.sourceforge.net/doc.stable/weka/clusterers/ClusterEvaluation.html)

Create a clusterer evaluation. Split input data into train and test set. Builds the clusterer
on the training set and tests it on the test set.

``` kotlin
//Unresolved: sampleClustererEvaluateHoldoutTestpercentage
```

### Parameters

`data` - Input dataset

`testPercentage` - Testing data split percentage

**Return**
Clusterer evaluation

