
class Solution {
    public String[] createGrid(int m, int n) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < m - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            list.add(sb.toString());
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < n; j++) {
            sb.append(".");
        }
        list.add(sb.toString());

        String[] str = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            str[i] = list.get(i);
        }

        return str;
    }
}
