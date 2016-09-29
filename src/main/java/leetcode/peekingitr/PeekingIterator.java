package leetcode.peekingitr;

import java.util.Iterator;
import java.util.Optional;

import static java.util.Optional.empty;

// https://leetcode.com/problems/peeking-iterator/
class PeekingIterator implements Iterator<Integer> {

   private final Iterator<Integer> iterator;
   private Optional<Optional<Integer>> next = empty();

   public PeekingIterator(Iterator<Integer> iterator) {
      this.iterator = iterator;
   }

   public Integer peek() {
      return this.hasNext() ? next.get().get() : null;
   }

   @Override
   public Integer next() {
       computeNext();
       Integer val = next.orElse(Optional.empty()).orElseThrow(java.util.NoSuchElementException::new);
       
       next = empty();
       
       return val;
   }

   @Override
   public boolean hasNext() {
      computeNext();
      return next.isPresent();
   }
   
   private void computeNext() {
      if (!next.isPresent() && iterator.hasNext()) {
         next = Optional.of(Optional.ofNullable(iterator.next()));
      }
   }
}