import java.util.LinkedList;

// https://leetcode.com/problems/simplify-path/
public class SimplifyPath {
    public String simplifyPath(String path) {
        path = path + "/";
        LinkedList<String> paths = new LinkedList<>();
        int left = 0;

        while (left < path.length()) {
            int right = left;
            int numDot = 0;
            while (right < path.length()) {
                char c = path.charAt(right);
                if (c == '/') {
                    int numSlash = 0;
                    do {
                        ++numSlash;
                        ++right;
                    } while (right < path.length() && path.charAt(right) == '/');
                    int len = right - numSlash - left;

                    if (numDot == 2 && len == 2) {
                        if (!paths.isEmpty()) {
                            paths.removeLast();
                        }
                    } else if (numDot != 1 || len != 1) {
                        if (len > 0) {
                            paths.add(path.substring(left, right - numSlash));
                        }
                    }
                    left = right;

                    break;
                }
                if (c == '.') {
                    ++numDot;
                }
                ++right;
            }
        }
        if (paths.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!paths.isEmpty()) {
            sb.append("/").append(paths.removeFirst());
        }
        return sb.toString();
    }
}
