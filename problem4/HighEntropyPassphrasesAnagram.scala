import scala.io.StdIn

object HighEntropyPassphrasesAnagram extends App {
  def validPassphrase(input: String): Boolean = {
    input.split("\\s+").map(_.toSet).groupBy(x => x).count(_._2.size > 1) == 0
  }

  var count = 0
  var inputReady = true
  while (inputReady) {
    val line = StdIn.readLine()

    if (line == null || line.length == 0) {
      inputReady = false
    } else if (validPassphrase(line)) {
      count += 1
    }
  }

  println(count)

}
