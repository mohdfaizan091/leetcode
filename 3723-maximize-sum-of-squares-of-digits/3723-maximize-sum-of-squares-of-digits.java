class Solution {
    // Not done my me- I had to do it.
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        // Calculate the number of 9s and the remaining digit
        int nines = sum / 9;
        int rem = sum % 9;

        // Calculate the remaining positions to be filled with 0s
        int zeros = num - nines - (rem > 0 ? 1 : 0);

        // Append 9s first to maximize the number's value lexicographically
        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }

        // Append the remainder digit if it's greater than 0
        if (rem > 0) {
            sb.append(rem);
        }

        // Fill the rest of the length constraint with 0s
        for (int i = 0; i < zeros; i++) {
            sb.append('0');
        }

        return sb.toString();
    }
}