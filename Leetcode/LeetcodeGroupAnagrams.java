public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int len=strs.length;
        HashMap<String,ArrayList<String>> hm=new HashMap<String,ArrayList<String>>();
        if(len==0)
          return new ArrayList<List<String>>();
          Arrays.sort(strs);
        for(int i=0;i<len;i++)
        {
            int subLen=strs[i].length();
            char[] arr=strs[i].toCharArray();
            Arrays.sort(arr);
            if(!hm.containsKey(String.valueOf(arr)))
              {
                 hm.put(String.valueOf(arr),new ArrayList<String>());
              }
           
             hm.get(String.valueOf(arr)).add(strs[i]);
        }
        
       return new ArrayList<List<String>>(hm.values());
    }
}