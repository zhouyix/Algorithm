public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
      List<Integer> result = new ArrayList<>();
    int size = words[0].length();
    if (words.length == 0 ||words[0].isEmpty() || words[0].length() > s.length()) 
        return result;
    Map<String, Integer> hist = new HashMap<>();
    for (String w : words) {
        hist.put(w, !hist.containsKey(w) ? 1 : hist.get(w)+1);
    }
    for (int i = 0; i < size; i++) {  
        Map<String, Integer> currHist = new HashMap<>();
        int begin=i;
        int count=0;
      
        for(int j=i;j+size <= s.length();j=j+size)
        {
            String str=s.substring(j,j+size);
            if(hist.containsKey(str)){
              currHist.put(str, !currHist.containsKey(str) ? 1 : currHist.get(str)+1);
               if(currHist.get(str) <= hist.get(str))
                  count++;
               else
                  {
                    while(currHist.get(str) > hist.get(str))
                    {
                        String tmp=s.substring(begin,begin+size);
                        currHist.put(tmp,currHist.get(tmp)-1);
                        if(currHist.get(tmp) < hist.get(tmp))//这句可以不要吗
                           count--;
                        begin=begin+size;
                    }
                  }
                if(count==words.length)
                {
                    result.add(begin);
                    String tmp=s.substring(begin,begin+size);
                    currHist.put(tmp,currHist.get(tmp)-1);
                    count--;
                    begin=begin+size;
                }
            }
            else
            {
                currHist.clear();
                count=0;
                begin=j+size;
            }
        }
    }
    return result;
    }
}