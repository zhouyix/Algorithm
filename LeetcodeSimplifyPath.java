public class Solution {
    public String simplifyPath(String path) {
       LinkedList<String> stack = new LinkedList<String>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for(String dir:path.split("/"))
        {
            if(dir.equals("..")&&!stack.isEmpty())
              stack.pop();
             else
             if(!skip.contains(dir))
               stack.push(dir);
        }
        
        String res="";
        for(String dir:stack)
          res="/"+dir+res;
          
         return res.isEmpty()?"/":res;
    }
}