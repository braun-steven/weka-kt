[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.clusterers.Clusterer](index.md) / [makeFiltered](./make-filtered.md)

# makeFiltered

`fun <T : `[`Filter`](http://weka.sourceforge.net/doc.stable/weka/filters/Filter.html)`> `[`Clusterer`](http://weka.sourceforge.net/doc.stable/weka/clusterers/Clusterer.html)`.makeFiltered(filter: `[`T`](make-filtered.md#T)`, body: `[`T`](make-filtered.md#T)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)`): `[`FilteredClusterer`](http://weka.sourceforge.net/doc.stable/weka/clusterers/FilteredClusterer.html)

Wraps this classifier in a [FilteredClusterer](http://weka.sourceforge.net/doc.stable/weka/clusterers/FilteredClusterer.html) and adds the given [filter](make-filtered.md#com.github.stevenlang.wekakt.extensions$makeFiltered(weka.clusterers.Clusterer, com.github.stevenlang.wekakt.extensions.makeFiltered.T, kotlin.Function1((com.github.stevenlang.wekakt.extensions.makeFiltered.T, kotlin.Unit)))/filter) object.

``` kotlin
val em: Clusterer = EM()

// Wrap with filter
val filteredJ48 = em.makeFiltered(Resample()) {
    sampleSizePercent = 33.0
    noReplacement = true
}
```

### Parameters

`filter` - Filter to use in the [FilteredClusterer](http://weka.sourceforge.net/doc.stable/weka/clusterers/FilteredClusterer.html) object

`body` - Body to execute in [filter](make-filtered.md#com.github.stevenlang.wekakt.extensions$makeFiltered(weka.clusterers.Clusterer, com.github.stevenlang.wekakt.extensions.makeFiltered.T, kotlin.Function1((com.github.stevenlang.wekakt.extensions.makeFiltered.T, kotlin.Unit)))/filter)

`T` - Filter class

**Return**
[FilteredClusterer](http://weka.sourceforge.net/doc.stable/weka/clusterers/FilteredClusterer.html) instance

