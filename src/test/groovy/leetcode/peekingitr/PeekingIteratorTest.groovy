package leetcode.peekingitr

import spock.lang.Specification

class PeekingIteratorTest extends Specification {
   def "peeking iterator does not have next if its decorating iterator is empty"() {
      given:
      PeekingIterator iterator = new PeekingIterator([].iterator())
      
      expect:
      iterator.hasNext() == false
      iterator.peek() == null
   }
   
   def "peeking iterator can peek at the next element in an iterator"() {
      given:
      PeekingIterator iterator = new PeekingIterator([1, 2, 3].iterator())
      
      expect:
      iterator.hasNext() == true
      iterator.peek() == 1
      iterator.next() == 1
   }
   
   def "peeking iterator can be used in any order"() {
      given:
      PeekingIterator iterator = new PeekingIterator([1, 2, 3].iterator())
      
      expect:
      iterator.next() == 1
      iterator.peek() == 2
      iterator.next() == 2
      iterator.hasNext() == true
      iterator.hasNext() == true
      iterator.hasNext() == true
      iterator.peek() == 3
      iterator.peek() == 3
      iterator.next() == 3
      iterator.hasNext() == false
   }
   
   def "peeking iterator throws exception when next is called when empty"() {
      given:
      PeekingIterator iterator = new PeekingIterator([].iterator())
      
      when:
      iterator.next()
      
      then:
      thrown(java.util.NoSuchElementException)
   }
}
