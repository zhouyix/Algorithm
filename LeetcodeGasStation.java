public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas.length==0 || cost.length==0)
           return -1;
          
        int start =0,total=0,sum=0;
        for(int i=0;i<gas.length;i++)
        {
            total = total+gas[i]-cost[i];
            if(sum < 0){
                start = i;
                sum = gas[i]-cost[i];
            }
            else
              sum= sum+ gas[i]-cost[i];
        }
        
        if(total < 0)
           return -1;
        return start;
    }
}