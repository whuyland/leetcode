// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        encode(root, sb);
        return sb.toString();
    }

    private void encode(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        int baseLen = sb.length();
        encode(root.left, sb);
        int leftLen = sb.length() - baseLen;
        encode(root.right, sb);
        encodeInt32(sb, leftLen);
        encodeInt32(sb, root.val);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        return decode(data, 0, data.length());
    }

    private TreeNode decode(String data, int start, int end) {
        if (end - start < 8) {
            return null;
        }
        TreeNode root = new TreeNode(decodeInt32(data, end - 1));
        end -= 4;
        int leftLen = decodeInt32(data, end - 1);
        end -= 4;
        root.left = decode(data, start, start + leftLen);
        root.right = decode(data, start + leftLen, end);
        return root;
    }

    private void encodeInt32(StringBuilder sb, int val) {
        for (int i = 0; i < 4; ++i) {
            sb.append((char) (val & 0xff));
            val >>>= 8;
        }
    }

    private int decodeInt32(String s, int index) {
        int val = 0;
        for (int i = 0; i < 4; ++i) {
            val = (val << 8) | s.charAt(index - i);
        }
        return val;
    }
}
