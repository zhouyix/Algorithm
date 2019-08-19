/*
 * @lc app=leetcode id=227 lang=java
 *
 * [227] Basic Calculator II
 */
class Solution {
    public int calculate(String s) {
        s=s.replace(" ","");
       int i=0;
       Stack<Integer> s1=new Stack();
       Stack<Character>  s2=new Stack();

      int num=0;
       while(i<s.length()){
           if(s.charAt(i)>='0'&&s.charAt(i)<='9'){
           num=num*10+s.charAt(i)-'0';
               i++;
           }else{
              s1.add(num);
              num=0;

              char c=s.charAt(i);
              boolean isHigher=(c=='*'||c=='/');
              if(s2.isEmpty()|| (isHigher&&(s2.peek()=='+' || s2.peek()=='-'))){
                  s2.push(c);
              }else{
                 int p1=s1.pop();
                 int p2=s1.pop();
                 c=s2.pop();
                 if(c=='*'){
                     s1.push(p1*p2);
                 }else{
                     s1.push(p2/p1);
                 }
              }

              i++;
           }
       }

       s1.push(num);
       while(!s2.isEmpty()){
        int p1=s1.pop();
        int p2=s1.pop();
        char c=s2.pop();
        switch(c){
            case '+':
             s1.push(p1+p2);
             break;
             case '-':
             s1.push(p1-p2);
             break;
             case '*':
             s1.push(p1*p2);
             break;
             case '/':
             s1.push(p2/p1);
             break;
        }
       }

       return s1.peek();
        
    }
}

