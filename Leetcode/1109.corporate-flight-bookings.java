/*
 * @lc app=leetcode id=1109 lang=java
 *
 * [1109] Corporate Flight Bookings
 */
class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {   
         int[] res = new int[n];
        for(int i=0;i<bookings.length;i++){
            for(int k=bookings[i][0];k<=bookings[i][1];k++){
               res[k-1] = res[k-1] + bookings[i][2];
            }
        }

    
        return res;
    }
}

