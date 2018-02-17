import scala.io.StdIn

object InverseCaptcha extends App {

  private def validateInput(input: String) = input.matches("\\d+")

  def inverseCaptcha(input: String): Long = {
    val addedChar = input + input.charAt(0)
    addedChar.sliding(2).map(x =>
      if (x(0) == x(1))
        x(0) - '0'
      else 0
    ).sum
  }

  val input = StdIn.readLine()

  if (validateInput(input)) {
    println(inverseCaptcha(input))
  } else {
    println("BAD INPUT.")
  }

}
