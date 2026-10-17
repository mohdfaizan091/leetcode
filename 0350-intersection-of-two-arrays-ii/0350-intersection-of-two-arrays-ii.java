class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i=0 ; i<n1 ; i++) {
            int ele = nums1[i];
            if(!map.containsKey(ele)) {
                map.put(ele , 1);
            } else {
                int freq = map.get(ele);
                map.put(ele , freq + 1);
            }
        }

        List<Integer> ans = new ArrayList<>();

        for(int temp : nums2) {
            if(map.containsKey(temp)) {
                int freq = map.get(temp);
                if(freq > 0) {
                    ans.add(temp);
                }
                map.put(temp , freq - 1);
            }
        }

        int[] result = new int[ans.size()];
        for(int i=0 ; i<ans.size() ; i++) {
            result[i] = ans.get(i);
        }
        return result;
    }
}