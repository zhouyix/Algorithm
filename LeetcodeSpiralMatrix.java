public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
       ArrayList<Integer> list=new ArrayList<Integer>();
    
       int m=matrix.length;
       if(m==0)
        return list;
       int n=matrix[0].length;
        if(n==0)
        return list;
    
    int iMin=0;
    int iMax=m-1;
    int jMin=0;
    int jMax=n-1;
     int i=0,j=0;
       while(iMin <=iMax && jMin <=jMax)
       {
         
           while(j<=jMax)
             list.add(matrix[i][j++]);
          j--;
          i++;
          if(i>iMax)
            break;
            
        while(i<=iMax)
          list.add(matrix[i++][j]);
         i--;
         j--;
         if(j<jMin)
           break;
         
         
        while(j>=jMin)
          list.add(matrix[i][j--]);
        j++;
        i--;
        if(i<=iMin)
        break;
        
        while(i >=iMin+1)
        list.add(matrix[i--][j]);
        i++;
        j++;
        // if(j > jMax)
        //  break;
         
        iMin++;
        iMax--;
        jMin++;
        jMax--;
         
           
       }
        return list;
  
    }
    
}