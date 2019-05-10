 public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1)
            return Arrays.asList(0);

        HashMap<Integer, List<Integer>> g = new HashMap<>();
        init(g, edges);
        // return bfs(g);
        return delLeaves(g, n);
    }

    public List<Integer> delLeaves(HashMap<Integer, List<Integer>> g, int n) {
        LinkedList<Integer> leaves = new LinkedList<Integer>();
        for (int key : g.keySet()) {
            if (g.get(key).size() == 1) {
                leaves.add(key);
            }
        }

        if(leaves.size() == 0)
        return leaves;

       
        while (n > 2) {
            int size = leaves.size(); 
             n = n- size; 
            while (size > 0) {
               int l = leaves.poll();
               for(int next : g.get(l)){
                 g.get(next).remove((Integer)l);
                 if(g.get(next).size()==1){
                     leaves.add(next);
                 }
               }
               size--;
            }
        }

        return leaves;

    }

    public List<Integer> bfs(HashMap<Integer, List<Integer>> g) {
        int min = Integer.MAX_VALUE;
        HashMap<Integer, Integer> res = new HashMap<>();
        for (Integer key : g.keySet()) {
            LinkedList<Integer> q = new LinkedList<>();
            List<Integer> visited = new ArrayList<>();
            int h = 1;
            visited.add(key);
            for (Integer next : g.get(key)) {
                if (!visited.contains(next))
                    q.add(next);
            }

            int size = q.size();
            while (size > 0) {
                int v = q.poll();
                visited.add(v);
                size--;
                for (Integer next : g.get(v)) {
                    if (!visited.contains(next))
                        q.add(next);
                }

                if (size == 0) {
                    h++;
                    size = q.size();
                }
            }

            res.put(key, h);
            min = Math.min(min, h);
        }

        List<Integer> list = new ArrayList<>();
        for (int key : res.keySet()) {
            if (res.get(key) == min) {
                list.add(key);
            }
        }

        return list;
    }

    public void init(HashMap<Integer, List<Integer>> g, int[][] edges) {
        for (int i = 0; i < edges.length; i++) {
            if (!g.containsKey(edges[i][0])) {
                g.put(edges[i][0], new ArrayList<Integer>());
            }

            if (!g.containsKey(edges[i][1])) {
                g.put(edges[i][1], new ArrayList<Integer>());
            }

            g.get(edges[i][0]).add(edges[i][1]);
            g.get(edges[i][1]).add(edges[i][0]);
        }
    }
    
     public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0)
            return true;

        HashMap<Integer, List<Integer>> g = new HashMap<>();
        init(g, prerequisites);
        return delLeaves(g, numCourses);
    }

      

    public boolean delLeaves(HashMap<Integer, List<Integer>> g, int n) {
        LinkedList<Integer> leaves = new LinkedList<Integer>();
        for (int key : g.keySet()) {
            if (g.get(key).size() == 0) {
                leaves.add(key);
            }
        }
 
       int size = leaves.size();
       int nodeInPres = g.keySet().size();
            while (size > 0) {
                Integer l = leaves.poll(); 
                size--; 
                 nodeInPres--;
                for (int key : g.keySet()) {
                    if (g.get(key).contains(l)) {
                        g.get(key).remove(l);
                        if (g.get(key).size() == 0) {
                            leaves.add(key);
                        }
                    }
                }
            
                if(size == 0) size = leaves.size();
        }

        return nodeInPres==0;

    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> g = new HashMap<>();
        init(g, prerequisites);

        ArrayList<Integer> list = new ArrayList();
        int order = 0;
        for (int i = 0; i < numCourses; i++) {
            if(!list.contains(i)) 
              if(!dfs(g, list, i,new HashSet<Integer>())){
                return new int[0];
              }
        }

        if (list.size() != numCourses) {
            return new int[0];
        }

        int[] res = new int[numCourses];
        for (int i : list) {
            res[order++] = i;
        }
        return res;
    }

    public boolean dfs(HashMap<Integer, List<Integer>> g, ArrayList<Integer> list, int i, HashSet<Integer> inProgress) {
        if (list.contains(i)) {
            return true;
        }

        if (!g.containsKey(i)) {
            list.add(i);
            return true;
        }

        if (g.get(i).size() == 0) {
            list.add(i);
            return true;
        }

        if(inProgress.contains(i)){
            return false;
        }

        inProgress.add(i);
        for (int pre : g.get(i)) {
            if (!list.contains(pre))
               if(!dfs(g, list, pre,inProgress))
               {
                   return false;
               }
        }

        list.add(i);
        inProgress.remove(i);
        return true;
    }


    
    
