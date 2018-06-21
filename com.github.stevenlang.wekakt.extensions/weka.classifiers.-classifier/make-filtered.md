[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.classifiers.Classifier](index.md) / [makeFiltered](./make-filtered.md)

# makeFiltered

`fun <T : `[`Filter`](http://weka.sourceforge.net/doc.stable/weka/filters/Filter.html)`> `[`Classifier`](http://weka.sourceforge.net/doc.stable/weka/classifiers/Classifier.html)`.makeFiltered(filter: `[`T`](make-filtered.md#T)`, body: `[`T`](make-filtered.md#T)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`FilteredClassifier`](http://weka.sourceforge.net/doc.stable/weka/classifiers/meta/FilteredClassifier.html)

Wraps this classifier in a [FilteredClassifier](http://weka.sourceforge.net/doc.stable/weka/classifiers/meta/FilteredClassifier.html) and adds the given [filter](make-filtered.md#com.github.stevenlang.wekakt.extensions$makeFiltered(weka.classifiers.Classifier, com.github.stevenlang.wekakt.extensions.makeFiltered.T, kotlin.Function1((com.github.stevenlang.wekakt.extensions.makeFiltered.T, kotlin.Unit)))/filter) object.

``` kotlin
val j48: Classifier = J48()

// Wrap with filter
val filteredJ48 = j48.makeFiltered(Resample()) {
    sampleSizePercent = 33.0
    noReplacement = true
}
```

### Parameters

`filter` - Filter to use in the [FilteredClassifier](http://weka.sourceforge.net/doc.stable/weka/classifiers/meta/FilteredClassifier.html) object

`body` - Body to execute in [filter](make-filtered.md#com.github.stevenlang.wekakt.extensions$makeFiltered(weka.classifiers.Classifier, com.github.stevenlang.wekakt.extensions.makeFiltered.T, kotlin.Function1((com.github.stevenlang.wekakt.extensions.makeFiltered.T, kotlin.Unit)))/filter)

`T` - Filter class

**Return**
[FilteredClassifier](http://weka.sourceforge.net/doc.stable/weka/classifiers/meta/FilteredClassifier.html) instance

