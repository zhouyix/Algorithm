
/*
 * @lc app=leetcode id=241 lang=java
 *
 * [241] Different Ways to Add Parentheses
 */
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res=new ArrayList<Integer>();
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)=='+'|| input.charAt(i)=='-'||input.charAt(i)=='*'){
                String p1= input.substring(0, i);
                String p2=input.substring(i+1);

                List<Integer> res1=diffWaysToCompute(p1);
                List<Integer> res2=diffWaysToCompute(p2);

                for(int a:res1){
                    for(int b:res2){
                        int c=0;
                        switch(input.charAt(i)){
                            case '+':
                            c=a+b;
                            break;
                            case '-':
                            c=a-b;
                            break;
                            case '*':
                            c=a*b;
                            break;
                        }

                        res.add(c);
                    }
                }
            }
        }

        if(res.size()==0){
            res.add(Integer.valueOf(input));
        }

        return res;
    }
}

