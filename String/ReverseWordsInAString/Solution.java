class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] stringArray = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(int index = stringArray.length-1;index >= 0; index--)
        {
            if(stringArray[index].isEmpty())
                continue;
            result.append(stringArray[index]);
            if(index>0)
                result.append(" ");
        }
        return result.toString();
    }
}