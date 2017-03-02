package skydata.spark.benchmark
import org.apache.spark.mllib.classification.{NaiveBayes, NaiveBayesModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.mllib.regression.LabeledPoint
import org.apache.spark.rdd.RDD

/**
  * Created by darnell on 17-3-2.
  */
object NaiveBayesBenchmark extends MllibSupervisalBenchmark[NaiveBayesModel]{


  val LAMBDA = Key("lambda")
  val TYPE = Key("type")
  override lazy val algArgNames : Array[Key] = Array(LAMBDA, TYPE)
  //subtype  method
  override def genData(path : String) : Unit = generateLinearData.map({
    case LabeledPoint(label, features) => new LabeledPoint(label, Vectors.dense(features.toArray.map(Math.abs)))
  }).saveAsTextFile(path)
  override def train(trainData: RDD[LabeledPoint]): NaiveBayesModel =
    NaiveBayes.train(trainData, algArgTable(LAMBDA).toDouble, algArgTable(TYPE))

  override def test(model: NaiveBayesModel, testData: RDD[LabeledPoint]): Unit = predictorTest(model, testData)
}
