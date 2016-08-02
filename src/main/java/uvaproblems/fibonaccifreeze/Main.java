package uvaproblems.fibonaccifreeze;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
   public static Map<Integer, BigInteger> generateFibs(int numSequences) {
      Map<Integer, BigInteger> fibs = new HashMap();
      fibs.put(0, BigInteger.valueOf(0));

      BigInteger a = BigInteger.valueOf(0);
      BigInteger b = BigInteger.valueOf(1);
      for (int i=1; i < numSequences; i++) {
         fibs.put(i, b);

         BigInteger next = a.add(b);
         a = b;
         b = next;
      }

      return fibs;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Map<Integer, BigInteger> fibs = generateFibs(5001);

      while (scanner.hasNext()) {
         int x = scanner.nextInt();
         System.out.println("The Fibonacci number for " + x + " is " + fibs.get(x));
      }
   }
}
