package list

import scala.annotation.tailrec

/**
  * Eliminate consecutive duplicates of list elements.
  * If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.
  * Example:
  *
  * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  */
object P08 {
  def compressFunc[A](ls: List[A]): List[A] = ls.foldLeft((List.empty[A], Option.empty[A])) {
    case ((acc, x), v) => if (x == Option(v)) (acc, x) else (v :: acc, Option(v))
  }._1.reverse

  def compressRecursive[A](xs: List[A]): List[A] = {
    @tailrec
    def compressR(xs: List[A], acc: List[A]): List[A] = xs match {
      case h :: t => compressR(t.dropWhile(_ == h), h :: acc)
      case Nil => acc.reverse
    }
    compressR(xs, List.empty)
  }
}
