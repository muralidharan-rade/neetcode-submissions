class Solution {
    public boolean validPalindrome(String s) {
        char[] word = s.toCharArray();
        boolean isValid = true;
        
        int l = 0;
        int r = word.length - 1;

        while(l < r) {
            if(word[l] != word[r]) {
                return isDeltaValid(word, l+1, r) || isDeltaValid(word, l, r-1);
            }
            l++;
            r--;
        }
            
        return isValid;        
    }

    private boolean isDeltaValid(char[] word, int l, int r) {
        while(l < r) {
            if(word[l] != word[r]) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }
}