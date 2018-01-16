package list

/**
  * Find out whether a list is a palindrome.
  * Example:
  *
  * scala> isPalindrome(List(1, 2, 3, 2, 1))
  * res0: Boolean = true
  */
object P06 {
  def isPalindrome[A](ls: List[A]): Boolean =
    (ls zip P05.reverse(ls)).foldLeft(true) { case (acc, (l, r)) => acc && l == r }

  def isPalindromeBuiltin[A](ls: List[A]): Boolean = ls == ls.reverse
}
