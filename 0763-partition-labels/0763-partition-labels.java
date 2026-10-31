class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character , Integer> lastIdx = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++) {
            lastIdx.put(s.charAt(i) , i);
        }

        int start = 0;
        int end = 0;
        List<Integer> result = new ArrayList<>();
        for(int i=0 ; i<s.length() ; i++) {
            char ch = s.charAt(i);
            int lastIndex = lastIdx.get(ch);
            end = Math.max(end , lastIndex);
            if(end == i) {
                int ans = end - start + 1;
                result.add(ans);
                start = i + 1;
            }
        }

        return result;
    }
}