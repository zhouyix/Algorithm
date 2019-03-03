public class Solution {
    public List<Integer> grayCode(int n) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        if(n==0)
          {
              list.add(0);
              return list;
          }
          
         list.add(0);
         list.add(1);
         
         for(int i=2;i<=n;i++)
         {
             int size=list.size();
             for(int j=size-1;j>=0;j--)
             {
                 list.add(list.get(j)+(1<<(i-1)));
             }
         }
         
         return list;
    }
}