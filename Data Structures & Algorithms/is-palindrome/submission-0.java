class Solution {
    public boolean isPalindrome(String s) {
        char[] sArr = s.toCharArray();
        int n = sArr.length;

        if(n == 0 || n == 1) {
            return true;
        }

        int i = 0;
        int j = n - 1;

        while(i < j) {
            if(!Character.isLetterOrDigit(sArr[i])) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(sArr[j])) {
                j--;
                continue;
            }
            char ic = sArr[i];
            char jc = sArr[j];
            if(Character.isUpperCase(ic) || Character.isUpperCase(jc)) {
                ic = Character.toLowerCase(ic);
                jc = Character.toLowerCase(jc);
            }
            if(ic != jc) {                
                return false;
            }
            i++;
            j--;
        }

        return true;        
    }
}
