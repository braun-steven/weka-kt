[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.classifiers.Classifier](index.md) / [evaluateCrossValidation](./evaluate-cross-validation.md)

# evaluateCrossValidation

`fun `[`Classifier`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Classifier.html)`.evaluateCrossValidation(data: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`, numFolds: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 10, seed: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 1): `[`Evaluation`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Evaluation.html)

Create a crossvalidation evalution.

``` kotlin
val j48: Classifier = J48()
val iris: Instances = getIris()

// Evaluate cross-validation
val eval: Evaluation = j48.evaluateCrossValidation(data = iris, numFolds = 10, seed = 1)
```

### Parameters

`data` - Input data

`numFolds` - Number of cross validation folds

`seed` - Seed for picking random datapoints for train/test sets

**Return**
Evaluation object containing predictions and statistics

