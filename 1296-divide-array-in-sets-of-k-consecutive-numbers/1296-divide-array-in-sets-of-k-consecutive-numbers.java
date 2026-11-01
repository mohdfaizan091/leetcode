class Solution {
    public boolean isPossibleDivide(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;

        HashMap<Integer, Integer> Map = new HashMap<>();
        for (int ele : hand) {
            if (Map.containsKey(ele)) {
                int freq = Map.get(ele);
                Map.put(ele, freq + 1);
            } else {
                Map.put(ele, 1);
            }
        }

        Arrays.sort(hand);

        for (int ele : hand) {
            if (Map.get(ele) == 0) {
                continue;
            }

            for (int i = 0; i < groupSize; i++) {
                int currentCard = ele + i;
                if (!Map.containsKey(currentCard) || Map.get(currentCard) == 0) {
                    return false;
                }
                
                Map.put(currentCard, Map.get(currentCard) - 1);
            }
        }

        return true;
    }
}
