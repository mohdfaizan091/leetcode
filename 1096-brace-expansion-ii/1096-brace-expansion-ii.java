class Solution {

    int i = 0;

    public List<String> braceExpansionII(String expression) {
        Set<String> set = parse(expression);

        List<String> result = new ArrayList<>(set);
        Collections.sort(result);

        return result;
    }

    public Set<String> parse(String s) {

        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");

        while (i < s.length() && s.charAt(i) != '}') {

            if (s.charAt(i) == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                i++;
            }

            else if (s.charAt(i) == '{') {
                i++;

                Set<String> inner = parse(s);

                i++;

                current = multiply(current, inner);
            }

            else {
                StringBuilder word = new StringBuilder();

                while (i < s.length() && Character.isLetter(s.charAt(i))) {
                    word.append(s.charAt(i));
                    i++;
                }

                Set<String> temp = new HashSet<>();
                temp.add(word.toString());

                current = multiply(current, temp);
            }
        }

        result.addAll(current);

        return result;
    }

    public Set<String> multiply(Set<String> a, Set<String> b) {

        Set<String> result = new HashSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}