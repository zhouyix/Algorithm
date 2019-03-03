public class Solution {
   public boolean isInterleave(String s1, String s2, String s3) {
        int len1= s1.length(),len2= s2.length();
        if(len1+len2!=s3.length())
        	return false;
        boolean[][] res = new boolean[len1+1][len2+1]; 
        
       res[0][0] = true;
       for(int i =1;i<=len1 ;i++)
       {
       	if(s3.charAt(i-1)==s1.charAt(i-1))
       		res[i][0]=true;
        else
        	break;
       }

        for(int i =1;i<=len2 ;i++)
       {
       	if(s3.charAt(i-1)==s2.charAt(i-1))
       		res[0][i]=true;
        else
        	break;
       }

        for(int i =1 ; i<= len1 ;i++)
        	for(int j =1 ; j <= len2 ;j++)
        	{
        		res[i][j] = (res[i-1][j] && s1.charAt(i-1) == s3.charAt(i+j-1))||
        		            (res[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
        	}

        	return res[len1][len2];
    }
}