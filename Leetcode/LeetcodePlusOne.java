public class Solution {
    public int[] plusOne(int[] digits) {
        int[] add=new int[digits.length];
          add[digits.length-1]= (digits[digits.length-1]+1)/10;
        digits[digits.length-1]= (digits[digits.length-1]+1)%10;
        int[] result=new int[digits.length+1];
        result[digits.length]=digits[digits.length-1];
        for(int i=digits.length-2;i>=0;i--)
        {
           add[i]= (digits[i]+add[i+1])/10;
           digits[i]= (digits[i]+add[i+1])%10;
           result[i+1]=digits[i];
        }
        if(add[0]==1)
          {
              result[0]=1;
              return result;
          }
          else
          return digits;
    }
}