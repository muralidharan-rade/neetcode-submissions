class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i = 0;
        int j = 0;
        char[] word11 = word1.toCharArray();
        char[] word22 = word2.toCharArray();
        StringBuilder builder = new StringBuilder();

        while(i < word11.length && j < word22.length) {
            builder.append(word11[i]);
            builder.append(word22[j]);
            i++;
            j++;
        }

        if(i < word11.length) {
            while(i < word11.length) {
                builder.append(word11[i]);
                i++;
            }
        }

        if(j < word22.length) {
            while(j < word22.length) {
                builder.append(word22[j]);
                j++;
            }
        }

        return builder.toString();
    }
}