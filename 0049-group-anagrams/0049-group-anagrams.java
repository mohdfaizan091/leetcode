import java.util.*;

class Solution { 
    public List<List<String>> groupAnagrams(String[] strs) { 
        int n = strs.length; 

        HashMap<String, List<String>> map = new HashMap<>(); 
        
        for(int i = 0; i < n; i++) { 
            String temp = strs[i]; 
            char[] ch = strs[i].toCharArray(); 
            Arrays.sort(ch); 
            String str = new String(ch); 
            
            if(!map.containsKey(str)) { 
                List<String> list = new ArrayList<>();
                list.add(strs[i]); 
                map.put(str, list); 
            } else { 
                map.get(str).add(strs[i]); 
            } 
        } 
        
        List<List<String>> ans = new ArrayList<>();
        for(String s: map.keySet()) {
            List<String> curr = map.get(s);
            ans.add(new ArrayList<>(curr));
        }
        return ans;
    } 
}
