import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.sql.{SparkSession, DataFrame}

object KMeansExample {

  def main(args: Array[String]): Unit = {
    // Set up Spark
    val spark = SparkSession.builder
      .appName("KMeansExample")
      .config("spark.master", "local")
      .getOrCreate()

    // Load your data (modify the path accordingly)
    val dataPath = "data.csv"
    val data = spark.read.format("csv").option("header", "true").load(dataPath)

    // Assuming your data has columns "feature1", "feature2", etc.
    val featureColumns = data.columns.filterNot(_ == "label")

    // Create a feature vector column
    val assembler = new VectorAssembler()
      .setInputCols(featureColumns)
      .setOutputCol("features")

    val assembledData: DataFrame = assembler.transform(data)

    // Set up KMeans
    val kmeans = new KMeans()
      .setK(3) // Set the number of clusters
      .setSeed(1L)

    // Fit the model
    val model = kmeans.fit(assembledData)

    // Make predictions
    val predictions = model.transform(assembledData)

    // Show the results
    println("Cluster Centers: ")
    model.clusterCenters.foreach(println)

    println("Predictions: ")
    predictions.select("features", "prediction").show()

    // Stop Spark
    spark.stop()
  }
}
