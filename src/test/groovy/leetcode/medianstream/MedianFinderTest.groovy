package leetcode.medianstream

import spock.lang.Specification

class MedianFinderTest extends Specification {
   def "the median of an empty stream is 0"() {
      MedianFinder medianFinder = new MedianFinder()

      expect:
      medianFinder.findMedian() == 0.0
   }

   def "finds the median of a single number"() {
      MedianFinder medianFinder = new MedianFinder()

      when:
      medianFinder.addNum(5)

      then:
      medianFinder.findMedian() == 5.0
   }

   def "finds the median in a stream of numbers"() {
      MedianFinder medianFinder = new MedianFinder()

      when:
      toInsert.forEach{ medianFinder.addNum(it) }

      then:
      medianFinder.findMedian() == median

      where:
      toInsert          | median
      [1, 2, 3]         | 2
      [1, 2, 3, 4]      | 2.5
      [5, 7, 8, 10, 11] | 8
      [11, 10, 8, 7, 5] | 8
      [11, 10, 7, 5, 8] | 8
   }
}
