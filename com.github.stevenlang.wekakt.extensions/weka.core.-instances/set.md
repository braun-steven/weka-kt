[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.core.Instances](index.md) / [set](./set.md)

# set

`operator fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.set(rowIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, instance: `[`Instance`](http://weka.sourceforge.net/doc.stable/weka/core/Instance.html)`): `[`Instance`](http://weka.sourceforge.net/doc.stable/weka/core/Instance.html)

Set the instance at position [rowIndex](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instances, kotlin.Int, weka.core.Instance)/rowIndex).

``` kotlin
val iris: Instances = getIris()
val row: Instance = iris[4]
iris[5] = row
```

### Parameters

`rowIndex` - Row index

`instance` - Row instance`operator fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.set(rowIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, attributeIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Set the value at position ([rowIndex](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instances, kotlin.Int, kotlin.Int, kotlin.Number)/rowIndex),[attributeIndex](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instances, kotlin.Int, kotlin.Int, kotlin.Number)/attributeIndex)).

``` kotlin
val iris: Instances = getIris()
iris[4, 0] = 12.0
```

### Parameters

`rowIndex` - Row index

`attributeIndex` - Attribute index

`value` - Value`operator fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.set(rowIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, attribute: `[`Attribute`](http://weka.sourceforge.net/doc.stable/weka/core/Attribute.html)`, value: `[`Number`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-number/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Set the value at position ([rowIndex](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instances, kotlin.Int, weka.core.Attribute, kotlin.Number)/rowIndex),[attribute](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instances, kotlin.Int, weka.core.Attribute, kotlin.Number)/attribute)).

``` kotlin
val iris: Instances = getIris()
val att: Attribute = iris.attributes[0]
iris[4, att] = 12.0
```

### Parameters

`rowIndex` - Row index

`attribute` - Attribute

`value` - Value`operator fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.set(rowIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, attributeIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Set string value at position ([rowIndex](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instances, kotlin.Int, kotlin.Int, kotlin.String)/rowIndex),[attributeIndex](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instances, kotlin.Int, kotlin.Int, kotlin.String)/attributeIndex)).

``` kotlin
val data: Instances = getData()
data[4, 0] = "car"
```

### Parameters

`rowIndex` - Row index

`attributeIndex` - Attribute index

`value` - Value`operator fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.set(rowIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, attribute: `[`Attribute`](http://weka.sourceforge.net/doc.stable/weka/core/Attribute.html)`, value: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Set string value at position ([rowIndex](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instances, kotlin.Int, weka.core.Attribute, kotlin.String)/rowIndex),[attribute](set.md#com.github.stevenlang.wekakt.extensions$set(weka.core.Instances, kotlin.Int, weka.core.Attribute, kotlin.String)/attribute)).

``` kotlin
val data: Instances = getData()
val att: Attribute = data.attributes[0]
data[4, att] = "car"
```

### Parameters

`rowIndex` - Row index

`attribute` - Attribute

`value` - Value