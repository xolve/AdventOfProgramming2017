import scala.io.StdIn

object HighEntropyPassphrases extends App {
  var count = 0
  var inputReady = true
  while (inputReady) {
    val line = StdIn.readLine()

    if (line == null || line.length == 0) {
      inputReady = false
    } else if (line.split("\\s+").groupBy(x => x).count(_._2.length > 1) == 0) {
      count += 1
    }
  }

  println(count)
}
