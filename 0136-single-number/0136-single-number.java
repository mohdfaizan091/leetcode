class Solution {
    public int singleNumber(int[] nums) {
        return findSingleNo3(nums);
    }

    //approach 1 : bruteforce
    public int findSingleNo(int[] nums) {
        for(int i=0 ; i<nums.length ; i++) {
            boolean flag = true;
            for(int j=0 ; j<nums.length ; j++) {
                if(i != j && nums[i] == nums[j]) {
                    flag = false;
                }
            }
            if(flag == true) return nums[i];
        }
        return 0;
    }

    //approach 2 : Sorting
    public int findSingleNo2(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        while(i<nums.length-2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
            i = i + 2;
        }
        return nums[i];
    }

    //approach 3 : hashmap
    public int findSingleNo3(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int ele : nums) {
            if(map.containsKey(ele)) {
                map.put(ele , 2);
            } else {
                map.put(ele , 1);
            }
        }
        for(int ele : map.keySet()) {
            int fre = map.get(ele);
            if(fre == 1) return ele;
        }
        return 0;
    }
}