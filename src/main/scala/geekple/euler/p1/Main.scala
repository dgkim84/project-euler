package geekple.euler.p1

object Main extends App {
  println("Problem 1")
  println("< 10")
  println(sum1(9, 3) + sum1(9, 5) - sum1(9, 15))
  println("< 1000")
  println(sum1(999, 3) + sum1(999, 5) - sum1(999, 15))

  def sum1(to: Int, step: Int): Int = {
    val div = to / step
    val mod = div % 2
    if (mod == 1)
      (div + 1) * step / 2 * div
    else
      (div + 1) * step * div / 2
  }

  def sum2(to: Int, step: Int): Int = {
    val both = step + to / step * step
    (both * (to / step / 2.0)).toInt
  }
}
