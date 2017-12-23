import java.util.Stack;


/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.*/

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";  //Valid
        s = "()[]{}";     //Valid
        s = "(]";         //Invalid
        s = "([)]";       //Invalid
        s = "([])";       //Valid
        //s = "([]p";       //Invalid
        System.out.println("Is valid: " + isValid(s));
    }

    //Passed above 5 tests
    public static boolean isValid(String s) {
        Stack st = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char extracted = s.charAt(i);
            if (extracted == '(' || extracted == '[' || extracted == '{')
                st.push(extracted);
                //Check if we can pop last and check validity
            else if (extracted == ')') {
                if ((Character) st.peek() == '(')
                    st.pop();   //valid, so pop
                else
                    return false;
            } else if (extracted == ']') {
                if ((Character) st.peek() == '[')
                    st.pop();
                else
                    return false;
            } else if (extracted == '}') {
                if ((Character) st.peek() == '{')
                    st.pop();
                else
                    return false;
            } else {
                System.out.println("Invalid characters detected");
                return false;
            }
        }
        return true;    //If we make it through intact...
    }
}
