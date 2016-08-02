package uvaproblems.ninepuzzel

import spock.lang.Specification
import uvaproblems.ninepuzzel.Main.Puzzle

class MainTest extends Specification {
   def "should be able to instantiate a puzzel using an array of the numbers in it"() {
      expect:
      new Puzzle(input).hash == result

      where:
      input                                | result
      [1, 2, 3, 4, 5, 6, 7, 8, 9] as int[] | 123456789L
   }

   def "moveHorizontal shifts the pieces on the given row to the right"() {
      given:
      Puzzle puzzle = new Puzzle(123456789)

      expect:
      puzzle.moveHorizontal(1) == new Puzzle(231456789)
      puzzle.moveHorizontal(2) == new Puzzle(123564789)
      puzzle.moveHorizontal(3) == new Puzzle(123456897)
   }

   def "moveVertical shifts the pieces on the given column upward"() {
      given:
      Puzzle puzzle = new Puzzle(123456789)

      expect:
      puzzle.moveVertical(1) == new Puzzle(723156489)
      puzzle.moveVertical(2) == new Puzzle(183426759)
      puzzle.moveVertical(3) == new Puzzle(129453786)
   }

   def "mapSolutions yields all possibilities"() {
      expect:
      Main.SOLUTIONS[new Puzzle(123456789)] == ''
      Main.SOLUTIONS[new Puzzle(231456789)] == 'H1'
      Main.SOLUTIONS[new Puzzle(739251486)] == 'V3V1H1'
   }
}
