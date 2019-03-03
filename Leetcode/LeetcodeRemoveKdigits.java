  //try to keep the string Monotonically increasing
  public String removeKdigits(String num, int k) {
         List<Character> list = new ArrayList<Character>();
		 for(int i=0;i<num.length();i++)
		 {
			 list.add(num.charAt(i));
		 }
		 
		 while(k>0)
		 {
			 int start = 0;
			 int len = list.size();
			 while(start+1 < len&& list.get(start) <= list.get(start+1))
			 {
				 start++;
			 }
			 
			 if(start < len)
			 {
				
				list.remove(start);
			 }
			 
			 k--;
		 }
		 
		 StringBuffer sb = new StringBuffer();
		 int start = 0;
		 while(start < list.size() && list.get(start)=='0')
			 start++;
		 
		 for(int i=start;i<list.size();i++)
		 {
			sb.append(list.get(i));
		 }
	       return sb.length()==0?"0":sb.toString();
    }