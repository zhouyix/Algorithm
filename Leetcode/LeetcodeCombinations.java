public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> lists=new ArrayList<List<Integer>>();
        ArrayList<Integer> list=new ArrayList<Integer>();
        combinations(lists,n,k,list,1);
        return lists;
        
    }
    
    public void combinations( List<List<Integer>> lists,int n,int k,ArrayList<Integer> list,int start)
    {
        if(list.size()==k)
        {
          lists.add(new ArrayList<Integer>(list));
          return ;
        }
          
        for(int t=start;t<=n;t++)
          {
              if(list.size()==0 || t > list.get(list.size()-1)){
              list.add(t);
              combinations(lists,n,k,list,t+1);
              list.remove(list.size()-1);
              }
          }
    }
}