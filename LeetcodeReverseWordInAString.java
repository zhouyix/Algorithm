public class Solution {
    public String reverseWords(String s) {
        if(s.length()==0)
           return s;
        ArrayList<String> list = new ArrayList<String>();
        int i = 0 ;
        while(i<s.length()){
            while(i<s.length() && s.charAt(i)==' '){
                  i++;
            }
          
           int begin = i;
           while(i<s.length()&& s.charAt(i)!=' ')
               i++;
           if(begin < s.length())
              list.add(s.substring(begin,i));
          
        }
        String str="";
        for(i=list.size()-1;i>=0;i--)
        {
            if(i!=0)
              str = str+list.get(i)+" ";
            else
               str = str+list.get(i);
        }
        return str;
    }
}