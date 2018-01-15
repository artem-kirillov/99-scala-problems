object Main extends App {
  println(P07.flattenRecursive(List(List(1, 1), 2, List(3, List(5, 8)))))
  println(P07.flattenFunc(List(List(1, 1), 2, List(3, List(5, 8)))))
}
