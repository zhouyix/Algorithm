public class Solution {
    public String convert(String s, int numRows) {
        char[] arr=s.toCharArray();
        StringBuffer[] strBuf=new StringBuffer[numRows];
        
        for(int i=0;i<numRows;i++)
        strBuf[i]=new StringBuffer();
        int len=arr.length;
        int i=0;
       while(i<len)
        {
            for(int down=0;down<numRows && i< len;down++)
               strBuf[down].append(arr[i++]);
               
            for(int up=numRows-2;up>0 && i<len;up--)
              strBuf[up].append(arr[i++]);
        }
        
        for(int k=1;k<numRows;k++)
          strBuf[0].append(strBuf[k]);
          
         return strBuf[0].toString();
    }
}