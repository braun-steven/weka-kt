[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.core.Instances](index.md) / [removeClassAttribute](./remove-class-attribute.md)

# removeClassAttribute

`fun `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`.removeClassAttribute(): `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)

Remove the class attribute of this dataset.

``` kotlin
val iris: Instances = getIris()

// Remove the class attribute
val irisWithoutClass: Instances = iris.removeClassAttribute()
```

**Return**
This data without the class attribute

