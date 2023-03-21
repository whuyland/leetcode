import java.util.*;

// https://leetcode.com/problems/flatten-nested-list-iterator/
public class FlattenNestedListIterator implements Iterator<Integer> {
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

    private final Stack<ListIterator<NestedInteger>> stack;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        stack.add(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger top = stack.peek().next();
                if (top.isInteger()) {
                    stack.peek().previous(); // move it back
                    return true;
                }
                stack.push(top.getList().listIterator());
            }
        }
        return false;
    }
}
