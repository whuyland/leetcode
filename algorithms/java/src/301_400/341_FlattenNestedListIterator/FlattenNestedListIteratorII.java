import java.util.Iterator;
import java.util.List;
import java.util.Stack;

// https://leetcode.com/problems/flatten-nested-list-iterator/
public class FlattenNestedListIteratorII implements Iterator<Integer> {
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

    private final Stack<List<NestedInteger>> data;
    private final Stack<Integer> indices;
    private int index;

    public FlattenNestedListIteratorII(List<NestedInteger> nestedList) {
        data = new Stack<>();
        indices = new Stack<>();
        data.push(nestedList);
        indices.push(0);
    }

    @Override

    public Integer next() {
        int index = indices.pop();
        indices.push(index + 1);
        return data.peek().get(index).getInteger();
    }


    @Override
    public boolean hasNext() {
        if (data.isEmpty()) {
            return false;
        }

        if (indices.peek() >= data.peek().size()) {
            indices.pop();
            data.pop();
            if (!indices.isEmpty()) {
                indices.push(indices.pop() + 1);
            }
            return hasNext();
        }
        NestedInteger top = data.peek().get(indices.peek());
        if (!top.isInteger()) {
            data.push(top.getList());
            indices.push(0);
            return hasNext();
        }
        return true;
    }
}
