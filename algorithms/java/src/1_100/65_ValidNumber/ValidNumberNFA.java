import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

// https://leetcode.com/problems/valid-number/
public class ValidNumberNFA {
    static private final Map<Integer, Map<Integer, int[]>> machine = new HashMap<>();

    static {
        Map<Integer, int[]> s0 = new HashMap<>();
        s0.put(0, new int[]{2, 4, 6});
        s0.put(1, new int[]{1, 5});
        s0.put(2, new int[]{3});
        machine.put(0, s0);

        Map<Integer, int[]> s1 = new HashMap<>();
        s1.put(0, new int[]{2, 4});
        s1.put(2, new int[]{3});
        machine.put(1, s1);

        Map<Integer, int[]> s2 = new HashMap<>();
        s2.put(0, new int[]{2});
        s2.put(2, new int[]{3});
        machine.put(2, s2);

        Map<Integer, int[]> s3 = new HashMap<>();
        s3.put(0, new int[]{4});
        machine.put(3, s3);

        Map<Integer, int[]> s4 = new HashMap<>();
        s4.put(0, new int[]{4});
        s4.put(3, new int[]{8});
        s4.put(4, new int[]{11});
        machine.put(4, s4);

        Map<Integer, int[]> s5 = new HashMap<>();
        s5.put(0, new int[]{6});
        machine.put(5, s5);

        Map<Integer, int[]> s6 = new HashMap<>();
        s6.put(0, new int[]{6});
        s6.put(2, new int[]{7});
        machine.put(6, s6);

        Map<Integer, int[]> s7 = new HashMap<>();
        s7.put(3, new int[]{8});
        s7.put(4, new int[]{11});
        machine.put(7, s7);

        Map<Integer, int[]> s8 = new HashMap<>();
        s8.put(0, new int[]{10});
        s8.put(1, new int[]{9});
        machine.put(8, s8);

        Map<Integer, int[]> s9 = new HashMap<>();
        s9.put(0, new int[]{10});
        machine.put(9, s9);

        Map<Integer, int[]> s10 = new HashMap<>();
        s10.put(0, new int[]{10});
        s10.put(4, new int[]{11});
        machine.put(10, s10);
    }

    public boolean isNumber(String s) {
        LinkedList<Integer> states = new LinkedList<>();
        states.add(0);
        int i = 0;
        while (!states.isEmpty() && i <= s.length()) {
            int index = getIndex(s, i);
            if (index == -1) {
                return false;
            }
            int len = states.size();
            for (int j = 0; j < len; ++j) {
                Map<Integer, int[]> nextStates = machine.get(states.removeFirst());
                if (nextStates.containsKey(index)) {
                    for (int ss : nextStates.get(index)) {
                        states.add(ss);
                    }
                }
            }
            ++i;
        }
        return !states.isEmpty();
    }

    private int getIndex(String s, int index) {
        if (index == s.length()) {
            return 4;
        }
        char c = s.charAt(index);
        if (c >= '0' && c <= '9') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (c == '.') {
            return 2;
        }
        if (c == 'e' || c == 'E') {
            return 3;
        }
        return -1;
    }
}
