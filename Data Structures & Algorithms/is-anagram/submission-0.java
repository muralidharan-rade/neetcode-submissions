class Solution {
    public boolean isAnagram(String s, String t) {
        char[] ss = s.toCharArray();
        char[] tt = t.toCharArray();
        int ns = ss.length;
        int nt = tt.length;

        if (ns != nt) {
            return false;
        }

        Arrays.sort(ss);
        Arrays.sort(tt);

        for(int i=0; i<ss.length; i++) {
            if(ss[i] != tt[i]) {
                return false;
            }
        }

        return true;
    }
}
