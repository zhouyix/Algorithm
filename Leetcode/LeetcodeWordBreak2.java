public class Solution {
       public ArrayList<String> wordBreak(String s, Set<String> dict) {  
		 return helper(s, dict, new HashMap<String, ArrayList<String>>());
		}  
		
		public ArrayList<String> helper(String s,Set<String> dict,HashMap<String, ArrayList<String>> result){
		    if (result.containsKey(s)) 
                 return result.get(s);
                 
             ArrayList<String>res = new ArrayList<String>();     
               if (s.length() == 0) {
                  res.add("");
                  return res;
                  }     
                  
                  
            for (String word : dict) {
                 if (s.startsWith(word)){
                     ArrayList<String> sublist = helper(s.substring(word.length()), dict, result); 
                    for (String sub : sublist) 
                     res.add(word + (sub.isEmpty() ? "" : " ") + sub);  
                 }
                
            }
            
             result.put(s, res);
             return res;
		}
}