class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        int i = 0;
        int j = 0;
        List<List<Integer>> ans = new ArrayList<>();
        int n = s.length();
        
        while(j < n) {
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);

            if(ch1 != ch2) {
                int length = j - i;
                if(length >= 3) {
                    int start = i;
                    int end = j - 1;
                    List<Integer> list = new ArrayList<>();
                    list.add(start);
                    list.add(end);
                    ans.add(new ArrayList<>(list));
                }
                i = j;
            } else {
                j++;
            }
        }

        int length = j - i;
        if(length >= 3) {
            int start = i;
            int end = j - 1;
            List<Integer> list = new ArrayList<>();
            list.add(start);
            list.add(end);
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}