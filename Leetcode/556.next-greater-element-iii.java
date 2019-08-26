/*
 * @lc app=leetcode id=556 lang=java
 *
 * [556] Next Greater Element III
 */
class Solution {
    public int nextGreaterElement(int n) {
        List<Integer> numList = new ArrayList<Integer>();
    while( n != 0 ) {
        numList.add(0, n % 10);
        n /= 10;
    }
    int pivot = -1;
    for(int i = numList.size() - 1; i >= 0; i--) {
        if( i == 0 ) // The digit in n is monotone decreasing
            return -1;
        if( numList.get(i) > numList.get(i - 1) ) { // find the pivot
            pivot = i;
            for(int j = numList.size() - 1; j >= i; j--) {
                if( numList.get(j) > numList.get(i - 1) ) { // swap operation
                    int temp = numList.get(i - 1);
                    numList.set(i - 1, numList.get(j));
                    numList.set(j, temp);
                    break;
                }
            }
            break;
        }
    }
    long num = 0;
    for(int i = 0; i <= pivot - 1; i++)
        num = num * 10 + numList.get(i);
    for(int i = numList.size() - 1; i >= pivot; i--) // reverse from pivot to the end of list
        num = num * 10 + numList.get(i);
    return num > Integer.MAX_VALUE ? -1 : (int)num;

    }
}

