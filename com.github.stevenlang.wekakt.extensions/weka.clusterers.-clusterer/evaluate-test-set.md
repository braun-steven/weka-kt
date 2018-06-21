[wekakt](../../index.md) / [com.github.stevenlang.wekakt.extensions](../index.md) / [weka.clusterers.Clusterer](index.md) / [evaluateTestSet](./evaluate-test-set.md)

# evaluateTestSet

`fun `[`Clusterer`](http://weka.sourceforge.net/doc.stable/weka/clusterers/Clusterer.html)`.evaluateTestSet(testData: `[`Instances`](http://weka.sourceforge.net/doc.stable/weka/core/Instances.html)`): `[`ClusterEvaluation`](http://weka.sourceforge.net/doc.stable/weka/clusterers/ClusterEvaluation.html)

Create a clusterer evaluation. Tests the clusterer on the given test set.

``` kotlin
val em: Clusterer = EM()
val iris: Instances = getIris()
val (train, test) = iris.split(33.0)

em.buildClusterer(train)

// Evaluate hold-out on test set
val eval: ClustererEvaluation = em.evaluateTestSet(data = test)
```

### Parameters

`testData` - Testing data

**Return**
Clusterer evaluation

