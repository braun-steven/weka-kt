[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.core.Instances](index.md) / [removeAttribute](./remove-attribute.md)

# removeAttribute

`fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.removeAttribute(attIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)

Remove a given attribute by index.

``` kotlin
val iris: Instances = getIris()

// Remove the third attribute
val irisReduced: Instances = iris.removeAttribute(3)
```

### Parameters

`attIndex` - Attribute index

**Return**
This data without the specified attribute

