import scala.annotation.tailrec

/**
  * Find the Kth element of a list.
  * By convention, the first element in the list is element 0.
  * Example:
  *
  * scala> nth(2, List(1, 1, 2, 3, 5, 8))
  * res0: Int = 2
  */
object P03 {
  def nthBuiltin[A](n: Int, ls: List[A]): A = ls(n)

  @tailrec
  def nthRecursive[A](n: Int, ls: List[A]): A = {
    require(n >= 0, s"Index must be non-negative, got $n")

    ls match {
      case x :: xs =>
        if (n == 0) x
        else nthRecursive(n - 1, xs)
      case Nil =>
        throw new IndexOutOfBoundsException
    }
  }
}
