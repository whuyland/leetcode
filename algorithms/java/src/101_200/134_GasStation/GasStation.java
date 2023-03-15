// https://leetcode.com/problems/gas-station/
public class GasStation {
    // https://leetcode.com/problems/gas-station/solutions/1237895/easy-c-solution-in-o-n-time-complexity/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        int costSum = 0;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; ++i) {
            gasSum += gas[i];
            costSum += cost[i];
            tank += gas[i] - cost[i];
            if (tank < 0) {
                // before i, there is a range [x, i-1] can be covered,
                // and this i-th cost too much,
                // Therefore every time we reset, there is some negative leftover.
                tank = 0;
                start = i + 1;
            }
        }
        // At end, we need to check if we have total gas more than total cost,
        // if there are, we can always compensate the negative leftover with some gas
        return gasSum >= costSum ? start : -1;
    }
}
