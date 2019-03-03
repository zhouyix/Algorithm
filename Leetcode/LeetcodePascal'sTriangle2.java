public class Solution {
    public List<Integer> getRow(int rowIndex) {	
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(1);
            int layer =0;
            while(layer < rowIndex)
             {
    	      List<Integer> li = new ArrayList<Integer>();
    	      li.add(1);
    	      for(int i = 0;i<pre.size()-1;i++)
    	      {
                  li.add(pre.get(i)+pre.get(i+1));
    	      }
    	      li.add(1);
    	      pre=li;
    	      layer++;
             }
        return pre;
    }
}