class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        getParanthesis(n , "", ans , 0 , 0);
        return ans;
    }
    public void getParanthesis(int n , String str ,List<String> ans , int open , int closed) {
        if(str.length() == 2 * n) {
            if(open == closed) {
                ans.add(str);
            }
            return;
        }
        if(open < n) {
            getParanthesis(n, str + "(", ans,open + 1, closed);
        } 
        if(open > closed) {
            getParanthesis(n, str + ")", ans,open, closed + 1);
        } 
    }
    
}