

/*
 * @lc app=leetcode id=150 lang=java
 *
 * [150] Evaluate Reverse Polish Notation
 */
class Solution {
    public int evalRPN(String[] tokens) {
        int i=0;
        Stack<Integer> s=new Stack<>();
        while(i<tokens.length){
            if(Character.isDigit(tokens[i].charAt(0))||tokens[i].length()>1){
                s.push(Integer.valueOf(tokens[i]));
            }else{
                int a=s.pop();
                int b=s.pop();
                switch(tokens[i].charAt(0)){
                    case '+':
                    s.push(a+b);
                    break;
                    case '-':
                    s.push(b-a);
                    break;
                    case '*':
                    s.push(a*b);
                    break;
                    case '/':
                    s.push(b/a);
                    break;
                }
            }

            i++;
        }

        return s.peek();
    }
}

