import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String,HashMap<String,Double>> graph = new HashMap(); 
         
        for(int i=0;i<equations.size();i++){ 
        String first = equations.get(i).get(0);
        String second = equations.get(i).get(1);
    
        graph.computeIfAbsent(first, l -> new HashMap<String,Double>()).put(second,values[i]);
        graph.computeIfAbsent(second, l -> new HashMap<String,Double>()).put(first,1.0/values[i]);
        }

        double[] res = new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String first = queries.get(i).get(0);
            String second = queries.get(i).get(1);

            if(graph.containsKey(first) && graph.containsKey(second)){
                HashSet<String> visited = new HashSet(); 
                res[i] = dfs(graph,first,second,visited);
            }else{
                res[i] = -1.0;
            }
        }

        return res;
    }

    public double dfs(HashMap<String,HashMap<String,Double>> graph,String s,String e,HashSet<String> vi){
        if(s.equals(e)){
            return 1.0;
        }

        vi.add(s);
        for(Map.Entry<String,Double> en:graph.get(s).entrySet()){
              if(!vi.contains(en.getKey())){
                double v =  dfs(graph,en.getKey(),e,vi);
                if(v>0){
                    return v * en.getValue();
                }
              }
        }

        vi.remove(s);
        return -1.0;
    }
}

