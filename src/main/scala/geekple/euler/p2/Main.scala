package geekple.euler.p2

object Main extends App {
  println("Problem 2")
  println("< 90")
  println(sumfib(1, 2, to = 90))
  println("< 4M")
  println(sumfib(1, 2, to = 4000000))

  def sumfib(first: Long, second: Long, to: Long, sum: Long = 0L): Long = {
    if (first > to) sum
    else sumfib(second, first + second, to, sum + (if (first % 2 == 0) first else 0))
  }
}

