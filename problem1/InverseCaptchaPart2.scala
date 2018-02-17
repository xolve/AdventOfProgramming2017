import scala.io.StdIn

object InverseCaptchaPart2 extends App {

  private def validateInput(input: String) = input.matches("\\d+")

  def inverseCaptcha(input: String): Long = {
    val mid = math.ceil(input.length / 2.toDouble).toInt
    val extended = input + input.substring(0, mid)
    extended.sliding(mid + 1).map(x =>
      if (x.head == x.last)
        x(0) - '0'
      else
        0
    ).sum
  }

  val input = StdIn.readLine()
  if (validateInput(input)) {
    println(inverseCaptcha(input))
  } else {
    println("BAD INPUT.")
  }

}
