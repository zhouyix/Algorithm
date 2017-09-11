public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(numRows > 0)
           {
           	 List<Integer> lii = new ArrayList<Integer>();
           	 lii.add(1);
           	 list.add(lii);

            int layer =1;
            while(layer < numRows)
             {
    	      List<Integer> li = new ArrayList<Integer>();
    	      li.add(1);

    	      List<Integer> pre= list.get(list.size()-1); 
    	      for(int i = 0;i<pre.size()-1;i++)
    	      {
                  li.add(pre.get(i)+pre.get(i+1));
    	      }
    	      li.add(1);
    	      
    	      list.add(li);
    	      layer++;
             }
           }
        return list;
    }
}