public IList<TreeNode> FindDuplicateSubtrees(TreeNode root)
        {
            IList<TreeNode> res = new List<TreeNode>();
            var map = new Dictionary<string, List<TreeNode>>();
            Serialize(root, map);
            foreach (var key in map.Keys)
            {
                if(map[key].Count > 1)
                {
                    res.Add(map[key][0]);
                }
            }
                return res;
        }

        public string Serialize(TreeNode root, Dictionary<string, List<TreeNode>> dict)
        {
            if (root == null)
                return "";
            var str = root.val + "," + Serialize(root.left, dict) + "," + Serialize(root.right, dict);
            if (!dict.ContainsKey(str))
            {
                dict[str] = new List<TreeNode>();
            }


            dict[str].Add(root);


            return str;

        }