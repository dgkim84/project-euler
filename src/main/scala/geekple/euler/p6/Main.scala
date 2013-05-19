package geekple.euler.p6

object P6 {
  def p6(to: Int): Long = p6M(to) - p6P(to)

  def p6P(to: Int): Long = (1.to(to)).foldLeft(1)((a, b) => a + b*b)

  def p6M(to: Int): Long = {
    val a = (1 + to) * (to / 2)
    a * a
  }
}

object Main extends App {
  println(P6.p6(10))
  println(P6.p6(100))
}
