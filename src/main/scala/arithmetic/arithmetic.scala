package arithmetic {
  class S99Int(val start: Int) {

    /**
      * Determine whether a given integer number is prime.
      *
      * scala> 7.isPrime
      * res0: Boolean = true
      */
    def isPrime: Boolean = false
  }

  object S99Int {
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
