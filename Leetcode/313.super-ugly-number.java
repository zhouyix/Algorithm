import java.util.ArrayList;

/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 */
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        int[] ugly = new int[n];
        ugly[0] = 1;
      
        int[] indexOfPrimes = new int[primes.length];
    
            for(int i=1;i<n;i++){
                ugly[i] = Integer.MAX_VALUE;

                for(int j=0;j<primes.length;j++)
                   ugly[i] = Math.min(ugly[i],primes[j] * ugly[indexOfPrimes[j]]);
          
            for(int k=0;k<primes.length;k++){
                while(primes[k]*ugly[indexOfPrimes[k]] <= ugly[i])
                   indexOfPrimes[k]++;
            }
        }

        return ugly[n-1];
    }
}

