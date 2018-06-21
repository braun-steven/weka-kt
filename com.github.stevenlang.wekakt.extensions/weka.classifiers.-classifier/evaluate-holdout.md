[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.classifiers.Classifier](index.md) / [evaluateHoldout](./evaluate-holdout.md)

# evaluateHoldout

`fun `[`Classifier`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Classifier.html)`.evaluateHoldout(trainData: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`, testData: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`): `[`Evaluation`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Evaluation.html)

Create a holdout evaluation. Builds the classifier and tests it on the given test set.

``` kotlin
val j48: Classifier = J48()
val iris: Instances = getIris()
val (train, test) = iris.split(33.0)

// Evaluate hold-out
val eval: Evaluation = j48.evaluateHoldout(trainData = train, testData = test)
```

### Parameters

`trainData` - Training data

`testData` - Testing data

**Return**
Evaluation object containing predictions and statistics

`fun `[`Classifier`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Classifier.html)`.evaluateHoldout(data: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`, testPercentage: `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)`): `[`Evaluation`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Evaluation.html)

Create a holdout evaluation. Builds the classifier and tests it on the given test set.

``` kotlin
val j48: Classifier = J48()
val iris: Instances = getIris()

// Evaluate hold-out
val eval: Evaluation = j48.evaluateHoldout(data = iris, testPercentage = 33.0)
```

### Parameters

`data` - Input dataset

`testPercentage` - Testing data split percentage

**Return**
Evaluation object containing predictions and statistics

