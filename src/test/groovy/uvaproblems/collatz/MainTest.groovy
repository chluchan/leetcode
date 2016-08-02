package uvaproblems.collatz

import spock.lang.Specification

import java.util.stream.Collectors
import java.util.stream.IntStream

import static java.lang.Math.max
import static java.lang.Math.min
import static java.util.stream.IntStream.rangeClosed

class MainTest extends Specification {
   def "count the number of terms in a collatz sequence"() {
      println(Main.collatz.keySet())

      expect:
      Main.countCollatz(1) == 1
      Main.countCollatz(2) == 2
      Main.countCollatz(4) == 3
      Main.countCollatz(5) == 6
      Main.countCollatz(106) == 12
   }

   def "should format output correctly"() {
      expect:
      Main.formatCollatz(900, 1000) == '900 1000 174'
      Main.formatCollatz(1000, 900) == '1000 900 174'
      Main.formatCollatz(1, 1000000) != null
   }
}
