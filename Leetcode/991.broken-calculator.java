/*
 * @lc app=leetcode id=991 lang=java
 *
 * [991] Broken Calculator
 */
class Solution {
    public int brokenCalc(int x ,int y) {
        if(x >= y) return x - y;
        if(y % 2 == 0) return 1 + brokenCalc(x, y / 2);
        return 1 + brokenCalc(x, y + 1);
    }
}

