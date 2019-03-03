public class Solution {
    public int candy(int[] ratings) {
        if(ratings.length<=1)
           return ratings.length;
           
        int[] num = new int[ratings.length];
        for(int i=0;i<ratings.length;i++){
            num[i] = 1;
        }
        
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1] && num[i]<=num[i-1])
               num[i] = num[i-1]+1;
        }
        for(int i=ratings.length-2;i>=0;i--){
             if(ratings[i]>ratings[i+1] && num[i]<=num[i+1])
               num[i] = num[i+1]+1;
        }
        
        int sum=0;
        for(int i=0;i<ratings.length;i++)
          sum=sum+num[i];
          
        return sum;
    }
}