class Solution {
    public int minLength(String s) {
        if(!s.contains("AB") && !s.contains("CD"))
            return s.length();
        s = s.replace("AB",""); 
        s = s.replace("CD","");
        return minLength(s);
    }
}