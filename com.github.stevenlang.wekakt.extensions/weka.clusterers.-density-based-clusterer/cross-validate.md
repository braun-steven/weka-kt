[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.clusterers.DensityBasedClusterer](index.md) / [crossValidate](./cross-validate.md)

# crossValidate

`fun `[`DensityBasedClusterer`](http://weka.sourceforge.net/doc.stable/weka/clusterers/DensityBasedClusterer.html)`.crossValidate(data: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`, numFolds: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)` = 10, seed: `[`Long`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)` = 1): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Cross validate this density based clusterer on the given data.

``` kotlin
//Unresolved: sampleClustererCrossValidation
```

### Parameters

`data` - Cross validation data

`numFolds` - Number of folds

`seed` - Seed for random number generator

**Return**
Cross validation log-likelihood

