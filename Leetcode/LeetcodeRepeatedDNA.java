public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        if(s == null || s.length() <= 10)
          return new ArrayList<String>();
          
        ArrayList<String> list = new ArrayList<String>();
        HashSet<Integer> words = new HashSet<Integer>();
        HashSet<Integer> twoWords = new HashSet<Integer>();
        char[] map = new char[26];
        map['C' -'A'] = 1;
        map['G'-'A'] = 2;
        map['T'-'A'] = 3;
        
        for(int i =0 ;i < s.length()-9 ;i++){
            int v = 0;
            for(int j =0;j<10;j++){
                v <<= 2;
                v |= map[s.charAt(i+j)-'A'];
            }
            
            if(!words.add(v) && twoWords.add(v)){
                list.add(s.substring(i,i+10));
            }
        }
        
        return list;
        
    }
}