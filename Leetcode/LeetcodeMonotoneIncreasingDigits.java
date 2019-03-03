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
        
        //ie. 332 -> 299,at frist find number which is before the first not valid number, minus 1,turn the rest to 9
	    //ATTENTION 332->329 ,this is caused by in 332,the fist and second is same ,after the second minus 1 ,it change to i(i-1)rest
         while(i-1>=0 && list.get(i) == list.get(i-1))
	        {
	        	i--;
	        }
	        
	        int res = 0;
	        for(int j=0;j<len;j++)
	        {
	        	int value = 0;
	        	if(j == i)
	        		//minus the number which is before the first not valid number
	        		value = list.get(j)-1;
	        	else if(j<i)
	        		//number before not change
	        		value = list.get(j);
	        	else
	        		//change the rest to 9
	        		value = 9;
	        	  res = res +value *(int) Math.pow(10,len-1-j); 
	        
	        }
	        	
	        return res;
    }


    //从后往前遍历的最后一个值升高的位置，让前一位减1，并把当前位以及后面的所有位都变成9
    public int solution2(int N)
    {
    	 char[] arr = (N+"").toCharArray();
		
		
		int len = arr.length;
		
		int j= len;
		for(int i=len-1;i>0 ;i--)
		{
			if(arr[i] >= arr[i-1])
				continue;
			arr[i-1]--;
			j = i;
		}
		
		for(int i=j;i<len;i++)
		{
			arr[i]='9';
		}
		
		int res=0;
		for(int i=0;i<len;i++)
		{
			  res = res +(arr[i]-'0') *(int) Math.pow(10,len-1-i); 
		}
	  
		return res;
    }