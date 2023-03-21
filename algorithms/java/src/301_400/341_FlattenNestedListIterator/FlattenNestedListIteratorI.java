import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/flatten-nested-list-iterator/
public class FlattenNestedListIteratorI implements Iterator<Integer> {
    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

    private final LinkedList<NestedInteger> data;

    public FlattenNestedListIteratorI(List<NestedInteger> nestedList) {
        data = new LinkedList<>(nestedList);
    }


    @Override
    public Integer next() {
        return data.removeFirst().getInteger();
    }


    @Override
    public boolean hasNext() {
        while (!data.isEmpty() && !data.getFirst().isInteger()) {
            data.addAll(0, data.removeFirst().getList());
        }
        return !data.isEmpty();
    }
}
