package geekple.euler.p5

import geekple.euler.p3.P3._

object P5 {
  def p5(p: Stream[Long], to: Long): Long = {
    val a = p5A(p, to)
    val multi = a.product
    val diff = (1L.to(to)) diff a
    p5B(diff, multi, 1)
  }

  def p5A(p: Stream[Long], to: Long, acc: List[Long] = List()): Seq[Long] = {
    p.head match {
      case value if value > to => acc
      case value => p5A(p.tail, to, value :: acc)
    }
  }

  def p5B(diff: Seq[Long], multi: Long, times: Int): Long = {
    val tt = multi * times
    diff.filter(tt % _ != 0).size match {
      case 0 => tt
      case _ => p5B(diff, multi, times + 1)
    }
  }
}

object Main extends App {
  val p = prime(from(2L))
  println(P5.p5(p, 10L))
  val start = System.currentTimeMillis()
  println(P5.p5(p, 20L))
  println(System.currentTimeMillis() - start)
}
