public class Solution {
    public int LenLongestFibSubseq(int[] A) {
         int res = 0;
           HashSet<int> set = new HashSet<int>();
            foreach (var i in A)
            {
                set.Add(i);
            }
            for (int i = 0; i < A.Length; i++)
            {
                for (int j = i + 1; j < A.Length; j++)
                {
                    int a = A[i];
                    int b = A[j];
                    int l = 2;
                    int c = a + b;
                    while (set.Contains(c))
                    {
                        a = b;
                        b = c;
                        c = a + b;
                        res = Math.Max(res, ++l);
                    }
                }  
            }
            return res;
    }

    public int LenLongestFibSubseq(int[] A)
    {
        int res = 0;
            Dictionary<int, int> dic = new Dictionary<int, int>();
            for (int i = 0; i < A.Length; i++)
            {
                dic[A[i]] = i;
            }

            int[,] dp = new int[A.Length, A.Length];
            for (int i = 0; i < A.Length; i++)
            {
                for (int j = i + 1; j < A.Length; j++)
                {
                    dp[i, j] = 2;
                    int key = A[j] - A[i];
                    if (key >= A[i])
                        continue;
                    if (dic.ContainsKey(key))
                    {
                        int index = dic[key];
                        dp[i, j] = dp[index, i] + 1;
                        res = Math.Max(res, dp[i, j]);
                    }
                }
            }

            return res;
    }

    // at first dic[A[i]] = 1,means the longestFib which ends with A[i]
    //so 1,2,3,4,7 dic[3]=3(1,2,3)  and dic[7] = 1(represents 4)+dic[3]=4
    //but 1,2,3,4,7 is not the Fib ,because 2+3 != 4
    //actually use dic to save number and index , dp[indexI,indexJ]
    public int LenLongestFibSubseq(int[] A) {
       
           int res = 0;
            Dictionary<int, int> dic = new Dictionary<int, int>();
            for (int i = 0; i < A.Length; i++)
            {
                dic[A[i]] = i;
            }

            int[,] dp = new int[A.Length, A.Length];
            for (int i = 1; i < A.Length; i++)
            {
                for (int j = i - 1; j >= 0; j--)
                {
                    //initialize the dp[indexJ,indexI]
                    dp[j, i] = 2;
                    var key = A[i] - A[j];

                    //prune ,must let index of key < j < i so key < A[j]
                    if (key >= A[j])
                        continue;
                    //must contains the key
                    if (!dic.ContainsKey(key))
                        continue;
                    int tmp = dic[key];
                    dp[j, i] = Math.Max(dp[j, i], dp[tmp, j] + 1);
                    res = Math.Max(res, dp[j, i]);
                }
            }

            return res;
    }
}