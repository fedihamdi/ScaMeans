# Scala K-Means Clustering Project

This Scala project demonstrates K-means clustering using the Apache Spark library. K-means clustering is a popular machine learning algorithm for partitioning data into clusters.

## Prerequisites

Before running the project, ensure you have the following installed:

- [Scala](https://www.scala-lang.org/download/)
- [Apache Spark](https://spark.apache.org/downloads.html)

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/fedihamdi/ScaMeans.git

2. Navigate to the project directory:

    ```bash
    cd scala-kmeans

3. Edit the build.sbt file and update the Spark version or any other dependencies if needed.

4. Create a data file (e.g., data.csv) with the necessary features for clustering. Update the data path in the KMeansExample.scala file.

5. Run the project:

    ```bash
    sbt run

## Project Structure

* `KMeans.scala`: The main Scala file implementing the K-means clustering example.

* `build.sbt`: The build file specifying project dependencies.

* `Readme.md`: The readme file.

## Customization

* Data: Replace data.csv in KMeansExample.scala with the actual path to your data file. Ensure the data file has the required features for clustering.

* Cluster Number: Adjust the value of setK in KMeans.scala to set the desired number of clusters

## Additional Notes

* Make sure to configure Spark properly based on your environment.
* This is a basic example; you may need to customize it for your specific use case.

## Contributing

Feel free to contribute to this project by opening issues or submitting pull requests.

## License

This project is licensed under the MIT License - see the LICENSE file for details.