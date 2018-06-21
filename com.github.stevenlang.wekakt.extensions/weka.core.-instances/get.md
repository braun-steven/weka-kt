[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.core.Instances](index.md) / [get](./get.md)

# get

`operator fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.get(rowIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Instance`](http://weka.sourceforge.net/doc.stable/weka/core/Instance.html)

Get the instance at index [rowIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int)/rowIndex).

``` kotlin
//Unresolved: sampleGetInstanceByIndex
```

### Parameters

`rowIndex` - Row index

**Return**
Instance at [rowIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int)/rowIndex)

`operator fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.get(rowIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, attributeIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Get the value at position ([rowIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int, kotlin.Int)/rowIndex),[attributeIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int, kotlin.Int)/attributeIndex)).

``` kotlin
//Unresolved: sampleGetValueAtRowAndAttributeIndex
```

### Parameters

`rowIndex` - Row index

`attributeIndex` - Attribute index

**Return**
Value at position ([rowIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int, kotlin.Int)/rowIndex),[attributeIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int, kotlin.Int)/attributeIndex))

`operator fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.get(rowIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, attribute: `[`Attribute`](http://weka.sourceforge.net/doc.stable/weka/core/Attribute.html)`): `[`Double`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html)

Get the value at position ([rowIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int, weka.core.Attribute)/rowIndex),[attribute](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int, weka.core.Attribute)/attribute)).

``` kotlin
//Unresolved: sampleGetValueAtRowIndexAndAttribute
```

### Parameters

`rowIndex` - Row index

`attribute` - Attribute

**Return**
Value at position ([rowIndex](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int, weka.core.Attribute)/rowIndex),[attribute](get.md#com.github.stevenlang.wekakt.extensions$get(weka.core.Instances, kotlin.Int, weka.core.Attribute)/attribute))

`operator fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.get(rangeRows: `[`IntRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)`, rangeAttributes: `[`IntRange`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.ranges/-int-range/index.html)`): `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)

Slice the given range of attributes out of the dataset.

``` kotlin
//Unresolved: sampleGetRowAndAttributeIndexRange
```

### Parameters

`rangeRows` - Range of ints indicating the row slice interval

`rangeAttributes` - Range of ints indicating the attribute slice interval

**Return**
Subset of this dataset, that is only the attributes and rows in the given ranges are in
the result

**See Also**

[Instances.slice](slice.md)

