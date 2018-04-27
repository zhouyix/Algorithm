  public int monotoneIncreasingDigits(int N) {
          List<Integer> list = new ArrayList<Integer>();
	        int tmp = N;
	        while(tmp!=0)
	        {
	        	int single = tmp%10;
	        	list.add(0,single);
	        	tmp = tmp /10;
	        }
	        
	        int i = 0;
	        int len = list.size();
	        for(;i<len-1 ;i++)
	        {
	        	if(list.get(i) > list.get(i+1))
	        	{
	        		break;
	        	}
	        }
	        
	        if(i == len-1)
	        {
	        	return N;
	        }
        
         while(i-1>=0 && list.get(i) == list.get(i-1))
	        {
	        	i--;
	        }
	        
	        int res = 0;
	        for(int j=0;j<len;j++)
	        {
	        	int value = 0;
	        	if(j == i)
	        		value = list.get(j)-1;
	        	else if(j<i)
	        		value = list.get(j);
	        	else
	        		value = 9;
	        	  res = res +value *(int) Math.pow(10,len-1-j); 
	        
	        }
	        	
	        return res;
    }