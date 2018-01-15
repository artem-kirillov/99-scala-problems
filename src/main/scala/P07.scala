import scala.annotation.tailrec

/**
  * Flatten a nested list structure.
  * Example:
  *
  * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
  * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  */
object P07 {
  def flattenRecursive(ls: List[Any]): List[Any] = {
    @tailrec
    def support(ls: List[Any], r: List[Any]): List[Any] = ls match {
      case head :: tail =>
        head match {
          case xs: List[_] => support(tail, r ::: flattenRecursive(xs))
          case _ => support(tail, r :+ head)
        }
      case Nil => r
    }
    support(ls, List())
  }

  def flattenFunc(ls: List[Any]): List[Any] = ls.flatMap(v => v match {
    case xs: List[_] => flattenFunc(xs)
    case _ => List(v)
  })
}
