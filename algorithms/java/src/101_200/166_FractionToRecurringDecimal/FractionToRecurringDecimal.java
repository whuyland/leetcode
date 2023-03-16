import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/fraction-to-recurring-decimal/
public class FractionToRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        long quotient = (long) numerator / denominator;
        long denom = denominator;
        long reminder = numerator % denominator;
        if (reminder == 0) {
            return Long.toString(quotient);
        }
        boolean negative = false;
        if (reminder < 0) {
            reminder *= -1;
            negative = !negative;
        }
        if (denom < 0) {
            denom *= -1;
            negative = !negative;
        }
        List<Long> frac = new ArrayList<>();
        Map<Long, Integer> seen = new HashMap<>();
        while (reminder != 0 && !seen.containsKey(reminder)) {
            seen.put(reminder, seen.size());
            reminder *= 10;
            if (reminder < denom) {
                frac.add(0L);
            } else {
                frac.add(reminder / denom);
                reminder %= denom;
            }
        }
        seen.put(0L, frac.size());
        StringBuilder sb = new StringBuilder();
        if (negative && quotient == 0) {
            sb.append("-");
        }
        sb.append(quotient).append(".");
        int n = seen.get(reminder);
        for (int i = 0; i < n; ++i) {
            sb.append(frac.get(i));
        }
        if (reminder != 0) {
            sb.append("(");
            for (int i = n; i < frac.size(); ++i) {
                sb.append(frac.get(i));
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
