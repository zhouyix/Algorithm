public class Solution {
    public String addBinary(String a, String b) {
         int add = 0;
        int i = a.length()-1,j = b.length()-1;
        int len= i > j ? i: j;
        StringBuffer sb=new StringBuffer(len+1);
        while (len >= 0) {
          int one= i >=0 ? a.charAt(i)-'0': 0;
          int two= j>=0 ? b.charAt(j)-'0': 0;
            sb.insert(0,(one+two+add)%2);
            add=(one+two+add)/2;
            len--;
            i--;
            j--;
        }
        if (add == 1)
            sb.insert(0,1);
        return sb.toString();
    }
}