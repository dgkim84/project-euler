package geekple.euler.p4

import geekple.euler.p3.P3

object P4 {
  def isPalindrome(no: Int) = isPalindrome2(no, 0, no)
  def isPalindrome2(no: Int, out: Int, acc: Int): Boolean = {
    if (acc == 0) no == out
    else isPalindrome2(no, out * 10 + acc % 10, acc / 10)
  }

  def maxPalindrome(start: Int, end: Int) = maxPalindrome2(start, start, end, List[Int]())
  def maxPalindrome2(current: Int, start: Int, end: Int, acc: List[Int]): Int = {
    if (current < end && acc == Nil) 0
    else if (current < end) acc.max
    else {
      val results = (start to end by -1).map(current * _).filter(isPalindrome)
      if (results == Nil) maxPalindrome2(current-1, start, end, acc)
      else maxPalindrome2(current-1, start, end, results.max :: acc)
    }
  }
}

object Main extends App {
  import P4._
  println("Problem 4")

  println("ab * cd => palindrome")
  println(maxPalindrome(99, 10))

  println("abc * def => palindrome")
  println(maxPalindrome(999, 100))
}
