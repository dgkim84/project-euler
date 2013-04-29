package geekple.euler.p3

object Main extends App {
  def from(start: Long, step: Int = 1): Stream[Long] =
    start #:: from(start + step, step)

  def prime(start: Stream[Long]): Stream[Long] =
    start.head #:: prime(start.tail.filter(_ % start.head != 0))

  def max(p: Stream[Long], value: Long, res: Long = 1): Long = {
    (res * p.head) match {
      case _ if value <= 1 => 1L
      case m if m == value => p.head
      case m if value / res % p.head == 0 => max(p, value, m)
      case _ => max(p.tail, value, res)
    }
  }

  println("Problem 3")

  val p = prime(from(2L))
  for (v <- (1L to 13195L)) {
    println(v + "\t: " + max(p, v))
  }
}
