public class Solution {
    public int largestRectangleArea(int[] height) {
        int max=0;
        int len=height.length;
        Stack<Integer> stack=new Stack<Integer>();
        int i=0;
       while(i<len)
        {
            if(stack.empty()|| height[i] >= height[stack.peek()])
              {
                  stack.push(i++);
                 
              }
             else
             {
                 int index=stack.pop();
                 
                 max = Math.max(max,height[index] * (stack.empty() ? i : i-stack.peek()-1));//width算的就是这个元素往上已经弹出了几个
             }
        }
        
        //如果一直是递增的情况
        while(!stack.empty())
        {
             int index=stack.pop();
                
                 max = Math.max(max,height[index] * (stack.empty() ? height.length : height.length-stack.peek()-1));
        }
        
        return max;
    }
}