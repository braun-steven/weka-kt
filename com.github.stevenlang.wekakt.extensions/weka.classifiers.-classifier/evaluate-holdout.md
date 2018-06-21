[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.classifiers.Classifier](index.md) / [evaluateHoldout](./evaluate-holdout.md)

# evaluateHoldout

`fun `[`Classifier`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Classifier.html)`.evaluateHoldout(trainData: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`, testData: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`): `[`Evaluation`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Evaluation.html)

Create a holdout evaluation. Builds the classifier and tests it on the given test set.

``` kotlin
//Unresolved: sampleClassifierEvaluateHoldoutTrainTest
```

### Parameters

`trainData` - Training data

`testData` - Testing data

**Return**
Evaluation object containing predictions and statistics

`fun `[`Classifier`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Classifier.html)`.evaluateHoldout(data: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`, testPercentage: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Evaluation`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Evaluation.html)

Create a holdout evaluation. Builds the classifier and tests it on the given test set.

``` kotlin
//Unresolved: sampleClassifierEvaluateHoldoutTestpercentage
```

### Parameters

`data` - Input dataset

`testPercentage` - Testing data split percentage

**Return**
Evaluation object containing predictions and statistics

