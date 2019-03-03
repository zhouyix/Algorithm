public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> list=new ArrayList<String>();
        if(s.length()==0)
          return list;
        String str="";
        helper(list,s,0,1,str);
        return list;
    }
    void helper(List<String> list,String s,int i,int seg,String item)
    {
        if(i==s.length())
        {
            return ;
        }
        if(seg==4)
        {
            String str=s.substring(i);//最后一层
            if(isValid(str))
            {
                list.add(item+"."+str);
            }
            return;
        }
        
        for(int k=1;k<=3;k++)
        {
            if(i+k <= s.length() && isValid(s.substring(i,i+k)))
               {
                   String str=s.substring(i,i+k);
                   if(seg==1)
                     helper(list,s,i+k,seg+1,str);
                   else
                     helper(list,s,i+k,seg+1,item+"."+str);
               }
        }
    }
    boolean isValid(String s)
    {
        if(s.length()>3)
          return false;
          
        int num=Integer.parseInt(s);
        if(s.charAt(0)=='0' && s.length()>1)
        return false;
        
        return num >=0 && num<=255;
    }
}