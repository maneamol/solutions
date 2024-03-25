import java.util.HashMap;
import java.util.Map;

public class UnionFindBySize {
    public Map<Integer, Integer> parent;
    public Map<Integer, Integer> size;
    public int maxLength;

    public UnionFindBySize(int[] nums) {
        this.parent = new HashMap<>();
        this.size = new HashMap<>();
        maxLength = 1;
        for (int i: nums) {
            size.put(i, 1);
            parent.put(i, i);
        }
    }

    public int findParent(int num) {
        if (parent.get(num) != num) {
            //path compression
            parent.put(num, findParent(parent.get(num)));
        }
        return parent.get(num);
    }

    public void union(int num1, int num2) {
        int xRoot = findParent(num1);
        int yRoot = findParent(num2);

        //same parent, items ins  same set already
        if (xRoot == yRoot) {
            return;
        }

        // parents are not same
        // add smaller to larger
            // i.e. set larger as parent of smaller
            // update size of larger
        if (size.get(xRoot) < size.get(yRoot)) {
//            int temp = xRoot;
//            xRoot = yRoot;
//            yRoot = temp;
            parent.put(xRoot, yRoot);
            size.put(yRoot, size.get(xRoot) + size.get(yRoot));
            maxLength = Math.max(maxLength, size.get(yRoot));
        } else {
            parent.put(yRoot, xRoot);
            size.put(xRoot, size.get(xRoot) + size.get(yRoot));
            maxLength = Math.max(maxLength, size.get(xRoot));
        }
    }
}
