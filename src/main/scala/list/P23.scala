package list

import scala.annotation.tailrec
import scala.util.Random

/**
  * Extract a given number of randomly selected elements from a list.
  * Example:
  *
  * scala> randomSelect(3, List('a, 'b, 'c, 'd, 'f, 'g, 'h))
  * res0: List[Symbol] = List('e, 'd, 'a)
  */
object P23 {
  def randomSelect[A](times: Int, lst: List[A]): List[A] = {
    if (times <= 0) Nil
    val length = lst.length

    @tailrec
    def randomSelectR(iter: Int, src: List[A], dst: List[A]): List[A] = {
      if (iter >= times) dst
      else {
        val (lst, v) = P20.removeAt(Random.nextInt(length - iter), src)
        randomSelectR(iter + 1, lst, v :: dst)
      }
    }
    randomSelectR(0, lst, List.empty)
  }
}
