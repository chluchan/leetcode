package leetcode.englishnumbers

import spock.lang.Specification

class SolutionTest extends Specification {
    Solution solution = new Solution();
    
    def "Convert a non-negative integer to its english words representation"() {
        expect:
        solution.numberToWords(number) == word
        
        where:
        number | word
        0      | 'Zero'
        1      | 'One'
        2      | 'Two'
        3      | 'Three'
        4      | 'Four'
        5      | 'Five'
        6      | 'Six'
        7      | 'Seven'
        8      | 'Eight'
        9      | 'Nine'
        10     | 'Ten'
        11     | 'Eleven'
        12     | 'Twelve'
        13     | 'Thirteen'
        14     | 'Fourteen'
        15     | 'Fifteen'
        16     | 'Sixteen'
        17     | 'Seventeen'
        18     | 'Eighteen'
        19     | 'Nineteen'
        20     | 'Twenty'
        21     | 'Twenty One'
        24     | 'Twenty Four'
        30     | 'Thirty'
        35     | 'Thirty Five'
        40     | 'Forty'
        50     | 'Fifty'
        60     | 'Sixty'
        70     | 'Seventy'
        80     | 'Eighty'
        90     | 'Ninety'
        100    | 'One Hundred'
        110    | 'One Hundred Ten'
        200    | 'Two Hundred'
        335    | 'Three Hundred Thirty Five'
        2356   | 'Two Thousand Three Hundred Fifty Six'
        22356  | 'Twenty Two Thousand Three Hundred Fifty Six'
        350000 | 'Three Hundred Fifty Thousand'
        4200000| 'Four Million Two Hundred Thousand'
        450000001 | 'Four Hundred Fifty Million One'
        2000000000| 'Two Billion'
   }
}
