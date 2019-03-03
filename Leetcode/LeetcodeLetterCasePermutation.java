public class Solution {
    public IList<string> LetterCasePermutation(string S) {
        List<string> res = new List<string>();
            char[] arr = S.ToCharArray();
            StringBuilder builder = new StringBuilder();
            dfs(res, arr, builder, 0);

            return res;
    }
    
     public void dfs(List<string> res, char[] arr, StringBuilder builder, int index)
        {
            if (index == arr.Length)
            {
                res.Add(builder.ToString());
                return;
            }

           
                var append = arr[index];
                builder.Append(append);
                dfs(res, arr, builder, index + 1);
                builder.Remove(builder.Length - 1, 1);

                if (arr[index] >= 'a' && arr[index] <= 'z')
                {
                    append = (char)((int)append - 32);
                    builder.Append(append);
                    dfs(res, arr, builder, index + 1);
                    builder.Remove(builder.Length - 1, 1);
                }
                else if(arr[index] >= 'A' && arr[index] <= 'Z')
                {
                     append = (char)((int)append + 32);
                    builder.Append(append);
                    dfs(res, arr, builder, index + 1);
                    builder.Remove(builder.Length - 1, 1);
                }

           
        }
}