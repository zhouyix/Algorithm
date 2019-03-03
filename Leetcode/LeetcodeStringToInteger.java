public class Solution {
    public int myAtoi(String str) {
         int len=str.length();
	        if(len == 0)
	        	return 0;
	        int i=0;
	        while(str.charAt(i)==' ')
	        	i++;
	        int flag=str.charAt(i)=='-'?0:1;
	        int cal=0;
	        if(str.charAt(i)=='+' || str.charAt(i)=='-')
	        {
	        	i++;	
	        	cal=1;
	        }
	        
	        if(cal ==1 && len<i+1)
	        	return 0;
	        
	        int sum=0;
	        while(i<len){
	        	char c=str.charAt(i);
	        	int num=-1;
	        	switch(c)
	        	{
	        		case '0':
	        			num=0;
	        			break;
	        		case '1':
	        			num=1;
	        			break;
	        		case '2':
	        			num=2;
	        			break;
	        		case '3':
	        			num=3;
	        			break;
	        		case '4':
	        			num=4;
	        			break;
	        		case '5':
	        			num=5;
	        			break;
	        		case '6':
	        			num=6;
	        			break;
	        		case '7':
	        			num=7;
	        			break;
	        		case '8':
	        			num=8;
	        			break;
	        		case '9':
	        			num=9;
	        			break;
	        		default:
	        			break;
	        			
	        		}
	        	i++;
	        	if(num>=0 && num <=9)
	        	{
	        	
	        		if(flag==1 && ((sum == Integer.MAX_VALUE/10 && num > 7)|| sum>Integer.MAX_VALUE/10))
	        			return Integer.MAX_VALUE;
	        		if(flag==0 && ((sum == Integer.MAX_VALUE/10 && num > 8 )|| sum>Integer.MAX_VALUE/10))
	        			return Integer.MIN_VALUE;	  
	        		  sum=sum*10+num;
	        	}
	        	
	        	else
	        		break;
	        }
	        
	        return flag==1?sum : -sum;
	    }
}