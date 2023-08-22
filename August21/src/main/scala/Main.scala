import scala.collection.mutable.ArrayBuffer

object Main {

  def main(args: Array[String]): Unit = {
    // 1.
    def num1(): Unit = {
      def calculateStats(words: List[String]): (Int, Int) = {
        val wordCount = words.length
        val charCount = words.map(_.length).sum
        (wordCount, charCount)
      }

      val wordList = List("apple", "banana", "cherry", "date")
      val (numWords, totalChars) = calculateStats(wordList)

      println(s"Number of words: $numWords")
      println(s"Total characters: $totalChars")
    }

    // 2.
    def num2(): Unit = {
      def fibonacci(size: Int): Array[Int] = {
        require(size >= 0, "Size must be non-negative")

        val fibArray = new Array[Int](size)
        if (size >= 1) {
          fibArray(0) = 0
        }
        if (size >= 2) {
          fibArray(1) = 1
          for (i <- 2 until size) {
            fibArray(i) = fibArray(i - 1) + fibArray(i - 2)
          }
        }

        fibArray
      }

      val fibSeq: Array[Int] = fibonacci(5)
      println(fibSeq.mkString(", "))
    }

    // 3.
    def num3(): Unit = {
      class Matrix(private val data: Array[Array[Double]]) {
        val numRows: Int = data.length
        val numCols: Int = if (numRows > 0) data(0).length else 0

        def apply(row: Int, col: Int): Double = data(row)(col)

        def *(other: Matrix): Matrix = {
          require(numCols == other.numRows, "Matrix dimensions are not compatible for multiplication")

          val resultData = Array.ofDim[Double](numRows, other.numCols)
          for (i <- 0 until numRows) {
            for (j <- 0 until other.numCols) {
              var sum = 0.0
              for (k <- 0 until numCols) {
                sum += data(i)(k) * other(k, j)
              }
              resultData(i)(j) = sum
            }
          }

          new Matrix(resultData)
        }

        override def toString: String = data.map(row => row.mkString(" ")).mkString("\n")
      }

      object Matrix {
        def apply(data: Array[Array[Double]]): Matrix = new Matrix(data)
      }

      val matrix1 = Matrix(Array(Array(1.0, 2.0), Array(3.0, 4.0)))
      val matrix2 = Matrix(Array(Array(2.0, 0.0), Array(1.0, 3.0)))

      val productMatrix = matrix1 * matrix2
      println(productMatrix)
    }

  num1()
  num2()
  num3()
  }

}