/**
  * Pack consecutive duplicates of list elements into sublists.
  * If a list contains repeated elements they should be placed in separate sublists.
  * Example:
  *
  * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
  */
object P09 {
  def packFunc[A](list: List[A]): List[List[A]] = {
    val result = list.foldLeft((List.empty[List[A]], List.empty[A])) { case ((acc, curAcc), elem) =>
      curAcc.headOption match {
        case Some(value) => if (value == elem) (acc, value :: curAcc) else (curAcc :: acc, List(elem))
        case None => (acc, List(elem))
      }
    }
    (result._2 :: result._1).reverse
  }

  def packRecursive[A](list: List[A]): List[List[A]] = {
    if (list.isEmpty) List.empty
    else {
      val (packed, tail) = list.span(_ == list.head)
      if (tail == Nil) List(packed) else packed :: packRecursive(tail)
    }
  }
}
