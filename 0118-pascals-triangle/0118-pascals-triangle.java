class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                temp.add(1);
            }
            ans.add(temp);
        }
        for(int i = 2; i < n; i++) {
            for(int j = 1; j < i; j++) {
                int value = ans.get(i - 1).get(j - 1)+ ans.get(i - 1).get(j);
                ans.get(i).set(j, value);
            }
        }
        return ans;
    }
}