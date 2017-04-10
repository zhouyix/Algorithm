public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
       int len=intervals.size();
	        ArrayList<Interval> list=new ArrayList<Interval>();
	        if(len==0)
	          return list;
	        if(len ==1)
	        {
	            list.add(intervals.get(0));
	            return list;
	        }
	       Collections.sort(intervals, new Comparator<Interval>() {
	           @Override
	           public int compare(Interval i1, Interval i2) {
	        	   if(i1.start==i2.start)
	        		   return Integer.compare(i1.end, i2.end);
	               return Integer.compare(i1.start, i2.start);
	           }
	       }); 
	        
	       //int start=intervals.get(0).start;
	       //int end=intervals.get(0).end;
	       
	       //for(Interval interval : intervals)
	       //{
	       //    if(interval.start <=end)
	       //    {
	       //        end=Math.max(end,interval.end);
	       //    }
	       //    else
	       //    {
	       //        list.add(new Interval(start,end));
	       //        start=interval.start;
	       //        end=interval.end;
	       //    }
	       //}
	       
	       //list.add(new Interval(start,end));
	       Iterator it=intervals.iterator();
	       Interval cur=(Interval)it.next();
	       while(it.hasNext())
	       {
	           Interval next=(Interval)it.next();
	           if(cur.end < next.start)
	           {
	               cur = next;
	               continue;
	           }
	           else
	           {
	               cur.end=Math.max(cur.end,next.end);
	               it.remove();
	           }
	       }
	        return intervals;
}
}