import java.util.Stack;

class Solution { 
    public int evalRPN(String[] tokens) { 
        // Declaration or STL used 
        Stack<String> st = new Stack<>(); 
        
        // operation 
        for(String to : tokens) { 
            switch(to) { 
                case "+" : {
                    int val1 = Integer.parseInt(st.pop()); 
                    int val2 = Integer.parseInt(st.pop()); 
                    int Addition = val1 + val2; 
                    st.push(String.valueOf(Addition)); 
                    break; 
                }
                case "-" : {
                    int val1 = Integer.parseInt(st.pop()); 
                    int val2 = Integer.parseInt(st.pop()); 
                    int Substraction = val2 - val1; 
                    st.push(String.valueOf(Substraction)); 
                    break; 
                }
                case "*" : {
                    int val1 = Integer.parseInt(st.pop()); 
                    int val2 = Integer.parseInt(st.pop()); 
                    int Multiply = val1 * val2; 
                    st.push(String.valueOf(Multiply)); 
                    break; 
                }
                case "/" : {
                    int val1 = Integer.parseInt(st.pop()); 
                    int val2 = Integer.parseInt(st.pop()); 
                    int Divivsion = val2 / val1; 
                    st.push(String.valueOf(Divivsion)); 
                    break; 
                }
                default : 
                    st.push(to); 
                    break; 
            } 
        } 
        String str = st.pop(); 
        int ans = Integer.parseInt(str); 
        return ans; 
    } 
}
