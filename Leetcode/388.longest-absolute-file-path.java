/*
 * @lc app=leetcode id=388 lang=java
 *
 * [388] Longest Absolute File Path
 */
class Solution {
    public class Node{
        public int len;
        public String sep;
        public Node(int vLen,String sep,int parentLen){
            this.len = vLen + 1 + parentLen;
            this.sep = sep.concat("\t");
        }
    }
    public boolean isValidStr(char c){
        return !(c=='\n' || c =='\t');
    }

    public int lengthLongestPath(String input) {
        int i = input.indexOf("\n");
        if(i==-1){
            return input.contains(".") ?input.length() : 0;
        }

        Node root = new Node(i,"\n",0);
        int max = 1;
        Stack<Node> s = new Stack();
        s.push(root);
        while(i<input.length()){
            int begin = i;
            while(i<input.length() && !isValidStr(input.charAt(i))){
                i++;
            }

            String sep = input.substring(begin,i);
            begin = i;
            while(i<input.length() && isValidStr(input.charAt(i))){
                i++;
            }

            while(!s.empty() && !s.peek().sep.equals(sep)){
                s.pop();
            }

            String c = input.substring(begin,i);
            Node n = new Node(c.length(),sep,s.empty() ? 0 :s.peek().len);
            if(c.contains("."))
            {max = Math.max(n.len,max);}
            s.push(n);
        }

        return  max-1;
    }
    
    
     public int lengthLongestPath1(String input){
        int res = 0;
        String[] v = input.split("\n");
        Stack<Integer> st = new Stack();
        for(String s:v){
            int level = s.lastIndexOf("\t")+1;
        
            // find parent
            while(!st.isEmpty() && stack.size() > level){
                st.pop();
            }

            // add parent len + present str len without seperator
            int len = (st.isEmpty() ? 0 : st.peek() + 1) + s.substring(level).length();
            stack.push(len);
            if(s.contains("."))
            res = Math.max(res,len);
        }

        return res;
    }
}

