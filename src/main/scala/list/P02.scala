package list

import scala.annotation.tailrec

/**
  * Find the last but one element of a list.
  * Example:
  *
  * scala> penultimate(List(1, 1, 2, 3, 5, 8))
  * res0: Int = 5
  */
object P02 {
  @tailrec
  def penultimate[A](list: List[A]): A = list match {
    case Nil => throw new NoSuchElementException("List is empty")
    case _ :: Nil => throw new NoSuchElementException("Singleton list")
    case x :: _ :: Nil => x
    case _ :: xs => penultimate(xs)
  }
}
