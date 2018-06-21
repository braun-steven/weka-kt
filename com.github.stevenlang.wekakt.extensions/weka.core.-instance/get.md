[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.core.Instance](index.md) / [get](./get.md)

# get

`operator fun `[`Instance`](http://weka.sourceforge.net/doc.stable/weka/core/Instance.html)`.get(attributeIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Get the attribute value at [attributeIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instance, kotlin.Int)/attributeIndex).

``` kotlin
val iris: Instances = getIris()
val row: Instance = iris[4]
val value: Double = row[2]
```

### Parameters

`attributeIndex` - Attribute index

**Return**
Value at [attributeIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instance, kotlin.Int)/attributeIndex)

`operator fun `[`Instance`](http://weka.sourceforge.net/doc.stable/weka/core/Instance.html)`.get(attribute: `[`Attribute`](http://weka.sourceforge.net/doc.stable/weka/core/Attribute.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Get the attribute value for [attribute](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instance, weka.core.Attribute)/attribute).

``` kotlin
val iris: Instances = getIris()
val sepalLengthAtt: Attribute = iris.attributes[0]
val row: Instance = iris[4]
val value: Double = row[sepalLengthAtt]
```

### Parameters

`attribute` - Attribute

**Return**
Value for [attribute](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instance, weka.core.Attribute)/attribute)

