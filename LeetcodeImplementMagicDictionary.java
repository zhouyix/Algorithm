public class MagicDictionary {
    
   public class Node
    {
        char c;
        HashMap<Character,Node> children;
        boolean end;
        public Node(char t)
        {
        	c = t;
        	children = new HashMap<Character,Node>();
        }
    } 
    
   public Node root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Node('#');
    }
    
    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for(String w:dict)
        {
        	Node cur = root;
        	char[] arr = w.toCharArray();
        	for(char c:arr)
        	{
        		cur.children.putIfAbsent(c, new Node(c));
        		cur = cur.children.get(c);
        	}	
            
            cur.end = true;
        }
    }
    
    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        return helper(root,arr,0,false);
    }
    
    public boolean helper(Node cur,char[] arr,int index,boolean diff)
    {
    	if(index == arr.length && diff && cur.end)	
    	{
    		return true;
    	}
    	
    	if(index == arr.length)
    		return false;
    
    	for(Character c : cur.children.keySet())
    	{
    		boolean flag = diff;
    		if((char)c!=arr[index])
    		{
    			if(!diff)
    			{
    				diff = true;
    			}	
    			else
    				continue;
    		}
    		
    		Node tmp = cur.children.get(c);
    		boolean res = helper(tmp,arr,index+1,diff);
    		if(res)
    			return res;
    		diff = flag;
    	}
    	
    	return false;
    }
}