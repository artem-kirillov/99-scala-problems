import scala.annotation.tailrec

/**
  * Reverse a list.
  * Example:
  *
  * scala> reverse(List(1, 1, 2, 3, 5, 8))
  * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  */
object P05 {
  def reverse[A](ls: List[A]): List[A] = {
    ls.foldLeft(List[A]())((l, r) => r :: l)
  }

  def reverseRecursive[A](ls: List[A]): List[A] = {
    @tailrec
    def support(ls: List[A], r: List[A]): List[A] = ls match {
      case h :: t => support(t, h :: r)
      case Nil => r
    }
    support(ls, List())
  }
}
