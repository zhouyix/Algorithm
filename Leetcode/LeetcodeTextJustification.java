public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len=words.length;
        int index=0;
        ArrayList<String> result=new ArrayList<String>();
        while(index < len)
        { 
            int count=words[index].length();
            int next=index+1;
            while(next < len )
            {
                if(words[next].length()+count+1> maxWidth)
                 break;
                 count=count+words[next].length()+1;
                next++;
            }
            
            StringBuilder builder = new StringBuilder();
            int diff = next - index - 1;//目前单词间的空格
            if(next==words.length || diff==0)//如果只有一个单词，或者到最后一个单词了
            {
                for(int i=index;i<next;i++)
                   builder.append(words[i]+" ");
                builder.deleteCharAt(builder.length()-1);//最后一个说不定不需要空格
                for(int i=builder.length();i<maxWidth;i++)
                   builder.append(" ");
            }
            else
            {
                int space=(maxWidth - count)/diff;//算上了之前每个单词带的空格后，平均每个单词之间再插入多少个空格
                int r=(maxWidth-count)%diff;//剩余多少空格需要均匀插入到前面，肯定是小于diff的
                for(int i=index;i<next;i++)
                {
                    builder.append(words[i]);
                    if(i < next -1)
                       {
                           for(int j=0;j<=(space+((i-index)<r ? 1:0));j++)
                              builder.append(" ");
                       }
                }
            }
            result.add(builder.toString());
            index=next;
            
        }
        return result;
    }
}