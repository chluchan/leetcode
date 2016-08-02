package uvaproblems.ninepuzzel;

import java.util.*;

public class Main {
   public static final Puzzle SOLVED = new Puzzle(123456789);
   public static final Map<Puzzle, String> SOLUTIONS = new HashMap<>();

   static {
      bfsearch();
   }

   public static class Puzzle {
      private static final int EIGHT_DIGITS = 100000000;
      private static final int SEVEN_DIGITS = 10000000;
      private static final int SIX_DIGITS = 1000000;
      private static final int FIVE_DIGITS = 100000;
      private static final int FOUR_DIGITS = 10000;
      private static final int THREE_DIGITS = 1000;
      private static final int TWO_DIGITS = 100;
      private static final int ONE_DIGIT = 10;

      final int hash;

      public Puzzle(int[] numbers) {
         hash = computePuzzleHash(numbers);
      }

      public Puzzle(int hash) {
         this.hash = hash;
      }

      public Puzzle moveHorizontal(int row) {
         switch (row) {
            case 1: return moveRow1();
            case 2: return moveRow2();
            case 3: return moveRow3();
            default: return this;
         }
      }

      public Puzzle moveVertical(int col) {
         switch (col) {
            case 1: return moveCol1();
            case 2: return moveCol2();
            case 3: return moveCol3();
            default: return this;
         }
      }

      private Puzzle moveCol1() {
         int topDigit = hash / EIGHT_DIGITS;
         int middleDigit = (hash / FIVE_DIGITS) % ONE_DIGIT;
         int bottomDigit = (hash / TWO_DIGITS) % ONE_DIGIT;

         int newHash = (bottomDigit * EIGHT_DIGITS) + (((hash / SIX_DIGITS) % TWO_DIGITS) * SIX_DIGITS) +
                        (topDigit * FIVE_DIGITS) + (((hash / THREE_DIGITS) % TWO_DIGITS) * THREE_DIGITS) +
                        (middleDigit * TWO_DIGITS) + (hash % TWO_DIGITS);
         return new Puzzle(newHash);
      }

      private Puzzle moveCol2() {
         int topDigit = (hash / SEVEN_DIGITS) % ONE_DIGIT;
         int middleDigit = (hash / FOUR_DIGITS) % ONE_DIGIT;
         int bottomDigit = (hash / ONE_DIGIT) % ONE_DIGIT;

         int newHash = ((hash / EIGHT_DIGITS) * EIGHT_DIGITS) + (bottomDigit * SEVEN_DIGITS) + (((hash / SIX_DIGITS) % ONE_DIGIT) * SIX_DIGITS) +
                        (((hash / FIVE_DIGITS) % ONE_DIGIT) * FIVE_DIGITS) + (topDigit * FOUR_DIGITS) + (((hash / THREE_DIGITS) % ONE_DIGIT) * THREE_DIGITS) +
                        (((hash / TWO_DIGITS) % ONE_DIGIT) * TWO_DIGITS) + (middleDigit * ONE_DIGIT) + (hash % ONE_DIGIT);

         return new Puzzle(newHash);
      }

      private Puzzle moveCol3() {
         int topDigit = (hash / SIX_DIGITS) % ONE_DIGIT;
         int middleDigit = (hash / THREE_DIGITS) % ONE_DIGIT;
         int bottomDigit = hash % ONE_DIGIT;

         int newHash = ((hash / SEVEN_DIGITS) * SEVEN_DIGITS) + (bottomDigit * SIX_DIGITS) +
                        (((hash / FOUR_DIGITS) % TWO_DIGITS) * FOUR_DIGITS) + (topDigit * THREE_DIGITS) +
                        ((hash / ONE_DIGIT) % TWO_DIGITS * ONE_DIGIT) + middleDigit;

         return new Puzzle(newHash);
      }

      private Puzzle moveRow1() {
         int hRow = shiftHorizontal(hash / SIX_DIGITS);
         int newHash = (hRow * SIX_DIGITS) + (hash % SIX_DIGITS);
         return new Puzzle(newHash);
      }

      private Puzzle moveRow2() {
         int hRow = shiftHorizontal((hash / THREE_DIGITS) % THREE_DIGITS);
         int newHash = ((hash / SIX_DIGITS) * SIX_DIGITS) + (hRow * THREE_DIGITS) + (hash % THREE_DIGITS);
         return new Puzzle(newHash);
      }

      private Puzzle moveRow3() {
         int hRow = shiftHorizontal(hash % THREE_DIGITS);
         int newHash = ((hash / THREE_DIGITS) * THREE_DIGITS) + hRow;
         return new Puzzle(newHash);
      }

      private int shiftHorizontal(int hRow) {
         return ((hRow % TWO_DIGITS) * ONE_DIGIT) + (hRow / TWO_DIGITS);
      }

      @Override
      public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Puzzle puzzle = (Puzzle) o;

         return hash == puzzle.hash;
      }

      @Override
      public int hashCode() {
         return hash;
      }

      @Override
      public String toString() {
         return "Puzzle{hash=" + hash + '}';
      }

      private int computePuzzleHash(int[] numbers) {
         int result = 0;
         for (int number : numbers) {
            result = (result * 10) + number;
         }

         return result;
      }
   }

   private static void bfsearch() {
      Queue<Object[]> queue = new ArrayDeque<>();

      queue.add(new Object[] { SOLVED, "" });

      while (!queue.isEmpty()) {
         Object[] puzzleAndOps = queue.remove();
         Puzzle puzzle = (Puzzle)puzzleAndOps[0];
         String ops = (String)puzzleAndOps[1];

         if (SOLUTIONS.containsKey(puzzle)) {
            if (SOLUTIONS.get(puzzle).length() > ops.length()) {
               SOLUTIONS.put(puzzle, ops);
            }
         }
         else {
            SOLUTIONS.put(puzzle, ops);

            for (int i=1; i < 4; i++) {
               queue.add(new Object[]{ puzzle.moveHorizontal(i), "H" + i + ops });
               queue.add(new Object[]{ puzzle.moveVertical(i), "V" + i + ops });
            }
         }
      }
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      while (scanner.hasNext()) {
         int[] puzzleValues = new int[9];

         puzzleValues[0] = scanner.nextInt();
         if (puzzleValues[0] == 0) {
            return;
         }

         for (int i=1; i < 9; i++) {
            puzzleValues[i] = scanner.nextInt();
         }

         String solutionMoves = SOLUTIONS.get(new Puzzle(puzzleValues));
         if (solutionMoves == null) {
            System.out.println("Not solvable");
         }
         else {
            int moves = solutionMoves.length() / 2;
            System.out.println(moves + " " + solutionMoves);
         }
      }
   }
}
