 public List<Integer> partitionLabels(String S) {
         int[] longestIndex = new int[26];
	        for(int i=0;i<S.length();i++)
	        {
	        	//record the farthest index of each char
	        	longestIndex[S.charAt(i)-'a'] = i;
	        }
	        
	        int p = 0;
	        List<Integer> list = new ArrayList<Integer>();
	        while(p<S.length()) {
	        	int lastIndex = longestIndex[S.charAt(p)-'a'];
	        	int seg = p+1;
	        	while(seg < lastIndex)
	        	{
	        		//present farthest index dose not cover index in p~lastIndex 
	        		if(longestIndex[S.charAt(seg)-'a'] > lastIndex)
	        		{
	        			lastIndex = longestIndex[S.charAt(seg)-'a'];
	        		}
	        		
	        		seg++;
	        	}
	        	
	        	list.add(lastIndex - p+1);
	        	p = lastIndex +1;
	        	
	        }
	        
	        return list;
    }