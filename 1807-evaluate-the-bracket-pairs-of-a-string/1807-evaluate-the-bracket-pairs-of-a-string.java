class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        int n = s.length();
        int m = knowledge.size();
        HashMap<String , String> map = new HashMap<>();
        for(int i=0 ; i<m ; i++) {
            String s1 = knowledge.get(i).get(0);
            if(!map.containsKey(s1)) {
                map.put(s1 , knowledge.get(i).get(1));
            }
        }
        int i = 0;
        String sb = "";

        while(i < n) {
            char ch = s.charAt(i);

            if(ch != '(') {
                sb = sb + ch;
                i++;
            }
            else {
                int j = i + 1;
                while(s.charAt(j) != ')') {
                    j++;
                }
                if(map.containsKey(s.substring(i + 1, j))) {
                    sb += map.get(s.substring(i + 1, j));
                } else {
                    sb += "?";
                }
                i = j + 1;
            }
        }

        return sb;
    }
}