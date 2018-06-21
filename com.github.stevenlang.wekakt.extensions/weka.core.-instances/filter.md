[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.core.Instances](index.md) / [filter](./filter.md)

# filter

`fun <T : `[`Filter`](http://weka.sourceforge.net/doc.stable/weka/filters/Filter.html)`> `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.filter(filter: `[`T`](filter.md#T)`, body: `[`T`](filter.md#T)`.() -> `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)` = {}): `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)

Apply a given filter to this set of instances.

``` kotlin
//Unresolved: sampleApplyFilterOnData
```

### Parameters

`filter` - Filter instance

`body` - Filter function body

`T` - inheriting from [Filter](http://weka.sourceforge.net/doc.stable/weka/filters/Filter.html)