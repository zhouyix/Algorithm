/*
 * @lc app=leetcode id=946 lang=java
 *
 * [946] Validate Stack Sequences
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int j=0;
        LinkedList<Integer> l = new LinkedList();
        for(int v:pushed){
           l.add(v);
           while(!l.isEmpty() && l.peekLast()==popped[j]){
               j++;
               l.removeLast();
           }
        }

        return l.isEmpty();
    }
    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        if(pushed.length == popped.length && pushed.length==0){
            return true;
        }
        int i= 0 ,j=0;
        Stack<Integer> s = new Stack();
        while(j < popped.length){
             if(s.isEmpty()){
                 s.push(pushed[i++]);
             }else if(s.peek () != popped[j] && i < pushed.length){
                 s.push(pushed[i++]);
             }else if(s.peek () != popped[j]){
                 return false;
             }
             else
             {
                 s.pop();
                 j++;
             }
        }

        return j==popped.length;
    }
}

