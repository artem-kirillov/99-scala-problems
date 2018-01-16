package list

import scala.annotation.tailrec

/**
  * Find the last element of a list.
  *
  * Example:
  *  scala> last(List(1, 1, 2, 3, 5, 8))
  *  res0: Int = 8
  */
object P01 {
  @tailrec
  def last[A](list: List[A]): A = list match {
    case x :: Nil => x
    case _ :: xs => last(xs)
    case Nil => throw new NoSuchElementException()
  }
}
