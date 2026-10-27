
class Solution {
    public int calPoints(String[] operations) {

        List<Integer> ans = new ArrayList<>();
        
        for (String op : operations) {
            switch (op) {
                case "+":
                    int v1 = ans.get(ans.size() - 1);
                    int v2 = ans.get(ans.size() - 2);
                    ans.add(v1 + v2);
                    break;
                    
                case "D":
                    ans.add(2 * ans.get(ans.size() - 1));
                    break;
                    
                case "C":
                    ans.remove(ans.size() - 1);
                    break;
                    
                default:
                    ans.add(Integer.parseInt(op));
                    break;
            }
        }
        
        int totalSum = 0;
        for (int score : ans) {
            totalSum += score;
        }
        
        return totalSum;
    }
}
