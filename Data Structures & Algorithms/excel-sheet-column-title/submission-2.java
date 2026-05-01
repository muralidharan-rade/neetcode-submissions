class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        int n = columnNumber;

        while (n > 0) {
            n--;
            int val = (n) % 26;
            char ch = (char) (val + 'A');
            sb.insert(0, ch);
            n  = n / 26;
        }

        return sb.toString();
    }
}