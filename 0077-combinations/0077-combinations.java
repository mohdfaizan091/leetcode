class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        computeNoOfCombination(result , temp , n , k , 0);
        return result;
    }
    
    public void computeNoOfCombination(List<List<Integer>> result , List<Integer> temp , int n , int k , int idx) {
        if(temp.size() == k) {
            // combination of size k is generated
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=idx ; i<n ; i++) {
            temp.add(i + 1);
            computeNoOfCombination(result , temp , n , k , i + 1);
            temp.remove(temp.size()-1);
        }
    }
}