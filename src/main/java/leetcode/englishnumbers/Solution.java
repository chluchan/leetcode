package leetcode.englishnumbers;

import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/integer-to-english-words/
public class Solution {
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        return computeLargeDigitsOfNumber(num) + computeSmallDigitsOfNumber(num % 1000);
    }

    private String computeLargeDigitsOfNumber(int num) {
        String english = "";
        Map<Integer, String> associations = associations();
       
        for (int digit = 1000000000; digit > 100; digit /= 1000) {
            if (num > digit - 1) {
               english += computeSmallDigitsOfNumber(num / digit) + " " + associations.get(digit);
               if (num % digit != 0) {
                   english += " ";
               }

               num -= (num / digit) * digit;
            }
        }        

        return english;
    }    
    
    private String computeSmallDigitsOfNumber(int num) {
        String english = "";
        if (num > 99) {
            english += onesDigit(num / 100) + " Hundred";
            num -= ((num / 100) * 100);
            
            if (num % 100 != 0) {
                english += " ";
            }
        }

        if (num >= 10 && num <= 19) {
            return english + computeTeens(num);
        }
        
        english += computeTensDigitOfNumber(num);
        num = num % 10;
        
        return english + onesDigit(num);
    }

    private Map<Integer, String> associations() {
        Map<Integer, String> associations = new HashMap<>();
        associations.put(1000, "Thousand");
        associations.put(1000000, "Million");
        associations.put(1000000000, "Billion");
        return associations;
    }

    private String computeTeens(int num) {
        switch (num) {
            case 18: return "Eighteen";
            case 15: return "Fifteen";
            case 13: return "Thirteen";
            case 12: return "Twelve";
            case 11: return "Eleven";
            case 10: return "Ten";
            default: return onesDigit(num - 10) + "teen";
        }
    }
    
    private String computeTensDigitOfNumber(int num) {
        String english = "";
        if (num > 9) {
            english += tensDigit(num);
            if (num % 10 != 0) {
                english += " ";
            }
        }
        
        return english;
    }
    
    private String tensDigit(int num) {
        switch (num / 10) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            default:
            case 9: return "Ninety";
        }
    }
    
    private String onesDigit(int num) {
        switch (num) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            default: return "";
        }
    }
}
