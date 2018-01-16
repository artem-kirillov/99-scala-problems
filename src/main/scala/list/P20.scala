package list

import scala.annotation.tailrec

/**
  * Remove the Kth element from a list.
  * Return the list and the removed element in a Tuple. Elements are numbered from 0.
  * Example:
  *
  * scala> removeAt(1, List('a, 'b, 'c, 'd))
  * res0: (List[Symbol], Symbol) = (List('a, 'c, 'd),'b)
  */
object P20 {
  def removeAt[A](idx: Int, lst: List[A]): (List[A], A) = {
    if (idx < 0) throw new IndexOutOfBoundsException
    @tailrec
    def removeAtR(time: Int, head: List[A], tail: List[A]): (List[A], A) = tail match {
      case h :: t if time == idx => (head ::: t, h)
      case h :: t => removeAtR(time + 1, h :: head, t)
      case Nil => throw new IndexOutOfBoundsException
    }
    removeAtR(0, List.empty, lst)
  }
}
