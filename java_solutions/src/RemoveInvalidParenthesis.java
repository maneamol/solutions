import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RemoveInvalidParenthesis {
    private int currentMaxLen = -1;
    private Set<String> set = new HashSet<>();

    private void removeParentheses(String s, int pos, int lc, int rc, StringBuilder sb) {
        if (pos == s.length()) {
            if (lc == rc) {
                if (sb.length() > currentMaxLen) {
                    currentMaxLen = sb.length();
                    set = new HashSet<>();
                    set.add(sb.toString());
                } else if (sb.length() == currentMaxLen) {
                    set.add(sb.toString());
                }
            }
        } else {
            char currentChar = s.charAt(pos);
//            removeParentheses(s, pos + 1, lc, rc, sb.append(currentChar));
            if (currentChar == '(') {
                removeParentheses(s, pos + 1, lc + 1, rc, sb.append(currentChar));
                sb.deleteCharAt(sb.length() - 1);

                removeParentheses(s, pos + 1, lc, rc, sb);
            } else if (currentChar == ')') {
                if (lc > rc) {
                    removeParentheses(s, pos + 1, lc, rc + 1, sb.append(currentChar));
                    sb.deleteCharAt(sb.length() - 1);
                }
                removeParentheses(s, pos + 1, lc, rc, sb);
            } else {
                removeParentheses(s, pos + 1, lc, rc, sb.append(currentChar));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        removeParentheses("()())()", 0, 0, 0, new StringBuilder() );
        return set.stream().toList();
    }

    public static void main(String[] args) {
        RemoveInvalidParenthesis obj = new RemoveInvalidParenthesis();
        obj.removeInvalidParentheses("");
    }
}
