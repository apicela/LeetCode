import java.util.HashMap;

/*
* Seven different symbols represent Roman numerals with the following values:

Symbol	Value
I	1
V	5
X	10
L	50
C	100
D	500
M	1000
Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.
Given an integer, convert it to a Roman numeral.



Example 1:

Input: num = 3749

Output: "MMMDCCXLIX"

Explanation:

3000 = MMM as 1000 (M) + 1000 (M) + 1000 (M)
 700 = DCC as 500 (D) + 100 (C) + 100 (C)
  40 = XL as 10 (X) less of 50 (L)
   9 = IX as 1 (I) less of 10 (X)
Note: 49 is not 1 (I) less of 50 (L) because the conversion is based on decimal places
Example 2:

Input: num = 58

Output: "LVIII"

Explanation:

50 = L
 8 = VIII
Example 3:

Input: num = 1994

Output: "MCMXCIV"

Explanation:

1000 = M
 900 = CM
  90 = XC
   4 = IV
 */
public class LeetCode12 {
    char[] alphabet = {'M', 'D', 'C','L', 'X', 'V', 'I'};
    int[] values =    {1000,500,100,50,10,5,1};

    public static void main(String[] args) {

        var leet = createInstance();
        int num = 3749; // 48 58 41

        System.out.println( leet.intToRoman(num));

    }



    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 10 ) verify(num,sb);
        int i = 0;
        do{
            while((num / values[i]) >= 1){
                sb.append(alphabet[i]);
                num-=values[i];
                if(num < 10) num =  verify(num,sb);
            }
            if(i + 1< values.length  && (num / (values[i] - values[i+1])) >= 1 && (values[i] - values[i+1]) != values[i+1]){
                sb.append(alphabet[i+1]);
                sb.append(alphabet[i]);
                num-=values[i] - values[i+1];
                if(num < 10) num =  verify(num,sb);
            }
            else if(i+2 < values.length && (num / (values[i] - values[i+2])) >= 1 ){
                sb.append(alphabet[i+2]);
                sb.append(alphabet[i]);
                num-=values[i] - values[i+2];
                if(num < 10) num =  verify(num,sb);
            }

            i++;
        } while(num > 9);
        return sb.toString();
    }

    int verify(int num, StringBuilder sb){
        int j = 5;
        if(num == 9){
            sb.append("IX");
            num-=9;
            return num;
        } else if (num == 4){
            sb.append("IV");
            num-=4;
            return num;
        }
        do {
            while((num / values[j]) >= 1){
                sb.append(alphabet[j]);
                num-=values[j];
            }
            while((num % values[j]) == 0 && num > 0){
                sb.append(alphabet[j]);
                num-=values[j];
            }
            j++;
            if(j >= values.length) break;
        } while(num > 0);
        return num;
    }

    private static LeetCode12 createInstance() {
        return new LeetCode12();
    }
}


/*

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        if (num < 10 ) verify(num,sb);
        int i = 0;
        do{
            while((num / values[i]) >= 1){
                System.out.printf("num : %d || i: %d || alphabet: %s\n",num, i, alphabet[i]);
                sb.append(alphabet[i]);
                num-=values[i];
                if(num % values[i] < 10) verify(num,sb);
            } // é 58, ali dá 50 if ( 58 / 50) => 1
            if(i < values.length - 1 && (num / (values[i] - values[i+1])) >= 1 && (values[i] - values[i+1]) != 50){
                System.out.printf("num : %d || i: %d || alphabet1: %s alphabet2: %s\n",num, i, alphabet[i+1], alphabet[i]);
                sb.append(alphabet[i+1]);
                sb.append(alphabet[i]);
                num-=values[i] - values[i+1];
                if(num % values[i] < 10) verify(num,sb);
            }

            i++;
        } while(num > 9);
        return sb.toString();
    }

    void verify(int num, StringBuilder sb){
        int j = 5;
        if(num == 9){
            sb.append("IX");
            return;
        } else if (num == 4){
            sb.append("IV");
            return;
        }
        do {
            while((num / values[j]) >= 1){
                sb.append(alphabet[j]);
                num-=values[j];
            }
            while((num % values[j]) == 0 && num > 0){
                sb.append(alphabet[j]);
                num-=values[j];
            }
            j++;
            if(j >= values.length) break;
        } while(num > 0);
    }
 */