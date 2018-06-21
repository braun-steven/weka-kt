[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.core.OptionHandler](index.md) / [setOptions](./set-options.md)

# setOptions

`fun `[`OptionHandler`](http://weka.sourceforge.net/doc.stable/weka/core/OptionHandler.html)`.setOptions(str: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Set options from the given options string [str](set-options.md#com.github.stevenlang.wekakt.extensions$setOptions(weka.core.OptionHandler, kotlin.String)/str).

``` kotlin
val clf: Classifier = J48()
clf.setOptions("-M 5 -U")
```

### Parameters

`str` - Options string