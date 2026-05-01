class Solution {
    List<String> result = new ArrayList<>(); 

    public List<String> generateParenthesis(int n) {
        generateParenth(n, 0, 0, "");
        return result;        
    }

    private void generateParenth(int n, int open, int close, String val) {
        if(open > n) {
            return;
        }

        if(close > open) {
            return;
        }

        if(open == n && close == n) {
            result.add(val);
            return;
        }

        generateParenth(n, open+1, close, val+"(");
        generateParenth(n, open, close+1, val+")");
    }
}
