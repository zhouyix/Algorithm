public class Solution {
    public String minWindow(String s, String t) {
        if(s.length()==0)
          return "";
          
          HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
          for(int i=0;i<t.length();i++)
           {
               if(hm.containsKey(t.charAt(i)) )
                    hm.put(t.charAt(i),hm.get(t.charAt(i))+1) ;
                else
                   hm.put(t.charAt(i),1);
           }
            
        int left =0;
        int count=0;
        int start =0;//开始的位置
        int len=s.length()+1;//比较最小的长度
        
        for(int right=0;right < s.length();right++)
        {
            if(hm.containsKey(s.charAt(right))){
                hm.put(s.charAt(right),hm.get(s.charAt(right))-1);
                
                
              if(hm.get(s.charAt(right))>=0)
                 count++;
                 
               while(count==t.length())
               {
                   if(right-left+1 < len)
                   {
                       len=right-left+1;
                       start=left;
                   }
                   if(hm.containsKey(s.charAt(left)))
                   {
                       hm.put(s.charAt(left),hm.get(s.charAt(left))+1);
                       if(hm.get(s.charAt(left))>0)
                         count--;
                   }
                   left++;
               }
                 
                 
            }
        }
          if(len > s.length())
      return "";
      
      return s.substring(start,start+len);
    }
    
  
}