public class Solution {
    /*
      This method is O(n^2)
    */
    public int lengthOfLongestSubstring(String s) {
        int[] map = new int[256];  
        int j = 0;
        int i = 0;
        int ans = 0;
        for (i = 0; i < s.length(); i++) {
            while (j < s.length() && map[s.charAt(j)]==0) {
                map[s.charAt(j)] = 1;
                ans = Math.max(ans, j-i + 1);
                j ++;
            }
            map[s.charAt(i)] = 0;
        }
        
        return ans;
    }
    
    /*
      First I think about using two pointers p,q
      while(q<len)
      if map<char,index> doesn't contains the arr[q] then map.add(arr[p],p),result = max(result,q-p+1)
       else use lastP=p,p=map.get(arr[q])+1,remove map key in arr[lastP...p-1] and map.add(arr[q],q),result = max(result,q-p+1)
       
       q++
       }
       
       Then in order to remove the map.remove loop,I think the key problem is p.
       Question is if don't remove the old char, later arr contains it how to update p
       'abba',when p=0,q reaches b then p should be map.get(arr[q])+1,and q moves to a,although map.contains(a,0) but this value is legacy
        p should be max(p,map.get(arr[q])+1) .this case p is not changed.
    */
    
     public int lengthOfLongestSubstring2(String s) {
         int p = 0,q=0,gap=0;
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        char[] arr = s.toCharArray();
       while(q < arr.length)
       {
    	   if(map.containsKey(arr[q]))
    	   {  
    		   gap = Math.max(gap, q-p);
    		   p = Math.max(p,map.get(arr[q])+1); 
    	   }
           
             map.put(arr[q], q); // update the new index
             gap = Math.max(gap, q-p+1); 
    	
    	   q++;
       }
       
       return gap;
  
    }
    
    
    /*
      In order to refine the code ,paste the leetcode recommended solution
      i represents the len,j represents the start point
      
    */
     public int lengthOfLongestSubstring3(String s) {
        char[] chars = s.toCharArray();
        if(2 > chars.length){
            return chars.length;
        }
        int max = 0;
        int split_at = 0;
        int cur_len = 1;
        for(int i=1;i<chars.length;i++){
            int j = split_at;
            for(;j<i;j++){
                if(chars[i] == chars[j]){
                    break;
                }
            }
            if(j < i){
                split_at = j+1;
                cur_len = i-j;
            }else{
                cur_len++;
            }
            if(cur_len > max) max = cur_len;
        }
        return max;
    }
}
