import java.util.ArrayList;

/*
 * @lc app=leetcode id=306 lang=java
 *
 * [306] Additive Number
 */
class Solution {
    public boolean isAdditiveNumber(String num) {
        return  helper(num,new ArrayList<Long>());
     }
 
     public boolean helper(String num, ArrayList<Long> exists){
         if(num.length() == 0 && exists.size() > 3 ){
             return true;
         }else if(num.length() == 0){
             return false;
         }
 
         for(int i=0;i<num.length();i++){
             String s =  num.substring(0,i+1);
             long sub = Long.parseLong(s);
             if((s.startsWith("0") && sub!=0)|| sub > Integer.MAX_VALUE || (exists.size()==1 && i==num.length()-1)){
                 return false;
             }
 
             int origin = exists.size();
             if(exists.size()<2){
                 exists.add(sub);
                 if(exists.size()==2){
                     exists.add(exists.get(0)+exists.get(1));
                 }
             } else if(exists.contains(sub) && exists.lastIndexOf(sub) >= 2){
                 for(int k=0;k<origin;k++){
                     exists.add(exists.get(k)+sub);
                 }
             }else{
                continue;
             }
 
             if(helper(num.substring(i+1),exists))
             {
                 return  true;
             }
 
             int present = exists.size();
             for(int k=origin;k<present;k++){
                 exists.remove(exists.size()-1);
             }
         }
 
         return false;
     }
 

}

