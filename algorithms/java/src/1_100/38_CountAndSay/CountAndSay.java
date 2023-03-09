// https://leetcode.com/problems/count-and-say/
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        StringBuilder sb = new StringBuilder();
        String next = countAndSay(n - 1);
        int digit = next.charAt(0) - '0';
        int cnt = 1;

        for (int i = 1; i < next.length(); ++i) {
            int curDigit = next.charAt(i) - '0';
            if (curDigit == digit) {
                ++cnt;
            } else {
                sb.append(cnt).append((char) ('0' + digit));
                cnt = 1;
                digit = curDigit;
            }
        }
        sb.append(cnt).append((char) ('0' + digit));
        return sb.toString();
    }
}
