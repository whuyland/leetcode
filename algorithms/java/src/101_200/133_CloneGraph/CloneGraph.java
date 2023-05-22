import java.util.*;

// https://leetcode.com/problems/clone-graph/
public class CloneGraph {
    public GraphNode cloneGraph(GraphNode node) {
        if (node == null) {
            return null;
        }
        Map<GraphNode, GraphNode> origin2Copy = new HashMap<>();
        LinkedList<GraphNode> jobs = new LinkedList<>();
        Set<GraphNode> done = new HashSet<>();
        jobs.add(node);
        while (!jobs.isEmpty()) {
            GraphNode job = jobs.removeFirst();
            if (done.contains(job)) {
                continue;
            }

            GraphNode copy = origin2Copy.getOrDefault(job, new GraphNode(job.val));
            origin2Copy.put(job, copy);
            for (GraphNode neighbor : job.neighbors) {
                if (origin2Copy.containsKey(neighbor)) {
                    // the copy is done somewhere else
                    copy.neighbors.add(origin2Copy.get(neighbor));
                } else {
                    // create new node, and add to list containing nodes to be copied
                    GraphNode neighborCopy = new GraphNode(neighbor.val);
                    copy.neighbors.add(neighborCopy);
                    origin2Copy.put(neighbor, neighborCopy);
                    jobs.add(neighbor);
                }
            }
            done.add(job);
        }
        return origin2Copy.get(node);
    }
}
