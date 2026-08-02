class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        Combination(ans , combination , 0 , n , k);
        return ans;
    }
    public void Combination(List<List<Integer>> ans , List<Integer> combination , int j , int n , int k) {
        if(combination.size() == k) {
            ans.add(new ArrayList<>(combination));
            return;
        }

        for(int i=j ; i<n ; i++) {
            combination.add(i+1);
            Combination(ans , combination , i + 1 , n , k);
            combination.remove(combination.size()-1);
        }
    }
}