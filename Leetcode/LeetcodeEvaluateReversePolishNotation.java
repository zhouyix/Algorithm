public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length==0)
         return 0;
        int i = 0;
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(Integer.parseInt(tokens[0]));
        i=1;
        while(i<tokens.length){
            switch(tokens[i]){
              case "+" :
                  {
                      int a = stack.pop();
                      int b = stack.pop();
                      stack.push(a + b);
                      break;
                  }
              case "-":
                   {
                      int a = stack.pop();
                      int b = stack.pop();
                      stack.push(b-a);
                      break;
                  }
              case "*":
                   {
                      int a = stack.pop();
                      int b =stack.pop();
                      stack.push(a * b);
                      break;
                  }
              case "/":
                   {
                      int a = stack.pop();
                      int b = stack.pop();
                      stack.push(b/a);
                      break;
                  }
            default:
               stack.push(Integer.parseInt(tokens[i]));
            }
               
               i++;
               
               
        }
        
        return stack.pop();
    }
}