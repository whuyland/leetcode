// https://leetcode.com/problems/multiply-strings/
public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // Normally we multiply one digit in nums2 with nums1,
        // and it needs two digits multiplication and carry calculation.
        // But we can just multiply two digits and place the result in the right place,
        // and do the carry toghter in the end.
        // If we number the digits in nums1/2 in reverse order,
        // we know, nums1[i] * nums2[j] will place answer at result[i + j + 1, i + j]

        int m = num1.length();
        int n = num2.length();
        int[] digits1 = new int[m];
        int[] digits2 = new int[n];
        int[] result = new int[m + n];

        for (int i = 0; i < m; ++i) {
            digits1[m - i - 1] = num1.charAt(i) - '0';
        }
        for (int i = 0; i < n; ++i) {
            digits2[n - i - 1] = num2.charAt(i) - '0';
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int mul = digits1[i] * digits2[j];
                // this way, as we do the calculation from right to left,
                // at last we are at m - 1 and n - 1, we will do final the carry
                int sum = result[i + j] + mul;
                result[i + j] = sum % 10;
                result[i + j + 1] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;
        for (int i = m + n - 1; i >= 0; --i) {
            if (leadingZero && result[i] == 0) {
                continue;
            }
            leadingZero = false;
            sb.append(result[i]);
        }
        return sb.toString();
    }
}
