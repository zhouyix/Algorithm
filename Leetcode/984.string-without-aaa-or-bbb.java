/*
 * @lc app=leetcode id=984 lang=java
 *
 * [984] String Without AAA or BBB
 */
class Solution {
    StringBuilder sb = new StringBuilder();
    public String strWithout3a3b(int A, int B) {
        if(A==0||B==0){
            while(A-- > 0)
              sb.append('a');

              while(B-- > 0)
              sb.append('b');    
        } else if(A==B){
            sb.append("ab");
            strWithout3a3b(A-1,B-1);
        }else if( A > B){
            sb.append("aab");
            strWithout3a3b(A-2,B-1);
        }else {
            sb.append("bba");
            strWithout3a3b(A-1,B-2);
        }

        return sb.toString();
    }
}

