 public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        dp[0] = triangle.get(0).get(0);

        for (int i = 1; i < triangle.size(); i++) {
            for (int j = i; j >= 0; j--) {
                dp[j] = triangle.get(i).get(j)
                        + Math.min(j == i ? Integer.MAX_VALUE : dp[j], j - 1 >= 0 ? dp[j - 1] : Integer.MAX_VALUE);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            min = Math.min(min, dp[i]);
        }

        return min;
    }

    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>(triangle.size());
        res.add(new ArrayList<>(1));
        res.get(0).add(triangle.get(0).get(0));

        for (int i = 1; i < triangle.size(); i++) {
            res.add(new ArrayList<Integer>(triangle.get(i).size()));
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int value = Math.min(j < i ? res.get(i - 1).get(j) : Integer.MAX_VALUE,
                        j - 1 >= 0 ? res.get(i - 1).get(j - 1) : Integer.MAX_VALUE)

                        + triangle.get(i).get(j);

                res.get(i).add(value);

            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < res.get(triangle.size() - 1).size(); i++) {
            min = Math.min(min, res.get(triangle.size() - 1).get(i));
        }

        return min;
    }

public int maxProduct(int[] nums) {
        int global = nums[0];
        int positive = nums[0];
        int negative = nums[0];
    
        for(int i= 1;i<nums.length;i++){
            int tmp = positive;
           positive = Math.max(nums[i],Math.max(positive*nums[i],negative*nums[i]));
           negative = Math.min(nums[i],Math.min(tmp*nums[i],negative*nums[i]));

           global = Math.max(global,positive);
        }

        return global;
        
    }

    public int maxProduct1(int[] nums) {
        //end with nums[i] maximum or minmum product
        int[] dpP = new int[nums.length];
        int[] dpN = new int[nums.length];

        int global = nums[0];
        dpP[0] = nums[0];
        dpN[0] = nums[0];
        for(int i= 1;i<nums.length;i++){
           dpP[i] = Math.max(nums[i],Math.max(dpP[i-1]*nums[i],dpN[i-1]*nums[i]));
           dpN[i] = Math.min(nums[i],Math.min(dpP[i-1]*nums[i],dpN[i-1]*nums[i]));

           global = Math.max(global,dpP[i]);
        }

        return global;
        
    }
    
    
    
    
    
    
