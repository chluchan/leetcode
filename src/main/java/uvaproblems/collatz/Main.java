package uvaproblems.collatz;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.stream.IntStream.range;
import static java.util.stream.IntStream.rangeClosed;

// https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=36%20-%20n+1%20problem
public class Main {
   private static Map<Long, Long> collatz = generateCollatz(1, 1, 1000000, new LinkedHashMap<Long, Long>() {{ put(0L, 0L); }});

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      while (scanner.hasNext()) {
         System.out.println(formatCollatz(scanner.nextInt(), scanner.nextInt()));
      }
   }

   private static String formatCollatz(int a, int b) {
      long terms = range(min(a, b), max(a, b)).boxed().map(Main::countCollatz).max(Long::compare).get();
      return a + " " + b + " " + terms;
   }

   private static long countCollatz(long number) {
      return collatz.getOrDefault(number, -1L);
   }

   private static Map<Long, Long> generateCollatz(long number, long count, long max, Map<Long, Long> cache) {
      if (number > max || cache.containsKey(number)) {
         return cache;
      }

      cache.put(number, count);

      long n = number * 2;
      long c = count + 1;
      while (n < max && !cache.containsKey(n)) {
         cache.put(n, c);
         n *= 2;
         c++;

         if ((n - 1) % 3 == 0) {
            generateCollatz((n - 1) / 3, c + 1, max, cache);
         }
      }

      if ((number - 1) % 3 == 0) {
         generateCollatz((number - 1) / 3, count + 1, max, cache);
      }

      return cache;
   }
}
