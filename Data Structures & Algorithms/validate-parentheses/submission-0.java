class Solution {
    public boolean isValid(String s) {
        char[] str = s.toCharArray();
        Stack<Character> stac = new Stack<>();

        for(int i=0; i<str.length; i++) {
            if(str[i] == '(' || str[i] == '{' || str[i] == '[') {
                stac.push(str[i]);
            } else {
                if(stac.isEmpty()) {
                    return false;
                }

                char letter = stac.pop();

                if(str[i] == '}') {
                    if(letter == '{') {

                    } else {
                        return false;
                    }
                } else if (str[i] == ']') {
                    if(letter == '[') {

                    } else {
                        return false;
                    }
                } else if (str[i] == ')') {
                    if(letter == '(') {

                    } else {
                        return false;
                    }
                }
            }
        }

        if(!stac.isEmpty()) {
            return false;
        }

        return true;        
    }
}
