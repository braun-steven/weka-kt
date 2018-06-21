[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.core.Instance](index.md) / [set](./set.md)

# set

`operator fun `[`Instance`](http://weka.sourceforge.net/doc.stable/weka/core/Instance.html)`.set(attributeIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`operator fun `[`Instance`](http://weka.sourceforge.net/doc.stable/weka/core/Instance.html)`.set(attributeIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Set the attribute value at [attributeIndex](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instance, kotlin.Int, kotlin.Number)/attributeIndex).

``` kotlin
val iris: Instances = getIris()
val row: Instance = iris[4]
row[0] = 12.0
```

### Parameters

`attributeIndex` - Attribute index

`value` - Attribute value`operator fun `[`Instance`](http://weka.sourceforge.net/doc.stable/weka/core/Instance.html)`.set(attribute: `[`Attribute`](http://weka.sourceforge.net/doc.stable/weka/core/Attribute.html)`, value: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)
`operator fun `[`Instance`](http://weka.sourceforge.net/doc.stable/weka/core/Instance.html)`.set(attribute: `[`Attribute`](http://weka.sourceforge.net/doc.stable/weka/core/Attribute.html)`, value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Set the attribute value of [attribute](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instance, weka.core.Attribute, kotlin.Number)/attribute).

### Parameters

`attribute` - Attribute

`value` - Attribute value

`sampleSetValueByAttribute` - 