package list

import scala.annotation.tailrec

/**
  * Lotto: Draw N different random numbers from the set 1..M.
  * Example:
  *
  * scala> lotto(6, 49)
  * res0: List[Int] = List(23, 1, 17, 33, 21, 37)
  */
object P24 {
  def lotto(count: Int, max: Int): List[Int] = {
    @tailrec
    def buildList(start: Int, acc: List[Int]): List[Int] =
      if (start <= max) buildList(start + 1, start :: acc) else acc

    P23.randomSelect(count, buildList(1, List.empty))
  }

  def lottoBuiltin(count: Int, max: Int): List[Int] =
    P23.randomSelect(count, List.range(1, max + 1))
}
