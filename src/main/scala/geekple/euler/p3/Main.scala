package geekple.euler.p3

object P3 {
  def from(start: Long, step: Int = 1): Stream[Long] =
    start #:: from(start + step, step)

  def prime(start: Stream[Long]): Stream[Long] =
    start.head #:: prime(start.tail.filter(_ % start.head != 0))

  def factors(p: Stream[Long], value: Long, res: Long = 1, acc: List[Long] = List()): List[Long] = {
    (res * p.head) match {
      case _ if value <= 1 => List(1L)
      case m if m == value => p.head :: acc
      case m if value / res % p.head == 0 => factors(p, value, m, p.head :: acc)
      case _ => factors(p.tail, value, res, acc)
    }
  }

  def max(p: Stream[Long], value: Long, res: Long = 1): Long = {
    (res * p.head) match {
      case _ if value <= 1 => 1L
      case m if m == value => p.head
      case m if value / res % p.head == 0 => max(p, value, m)
      case _ => max(p.tail, value, res)
    }
  }
}

object Main extends App {
  import P3._

  println("Problem 3")

  val p = prime(from(2L))
  println("13195: " + max(p, 13195) + ", factors: " + factors(p, 13195))
  println("600851475143: " + max(p, 600851475143L) + ", fators: " + factors(p, 600851475143L))
}
