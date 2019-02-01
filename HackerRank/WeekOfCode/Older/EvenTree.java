package WeekOfCode.Older;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.*;

/**
 * HackerRank WeekOfCode.Older.EvenTree
 * https://www.hackerrank.com/challenges/even-tree
 */
public class EvenTree {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vertices = scanner.nextInt();
        int edges = scanner.nextInt();
        int[] tree = new int[vertices + 1];

        Map<Integer, Integer> treeMapped = new HashMap<>();

        //Maps each node to number of connected nodes, for root it is +1 because root is also connected to itself
        for (int i = 0; i < edges; i++) {
            int connectedNode = scanner.nextInt();
            int parentNode = scanner.nextInt();

            tree[connectedNode] = parentNode;
            treeMapped.putIfAbsent(parentNode, 1);
            treeMapped.putIfAbsent(connectedNode, 1);

            int connectedNodesCounter = treeMapped.get(parentNode);
            treeMapped.put(parentNode, ++connectedNodesCounter);
            System.out.println("Map: " + treeMapped);
            System.out.println("Array: " + Arrays.toString(tree));

        }
        int result = 0;
        //Start from last node, -- until root is reached
        for (int nodeIndex = tree.length - 1; nodeIndex > 1; nodeIndex--) {
            if (treeMapped.get(nodeIndex) % 2 == 0) {
                boolean hasEven = false;
                for (int i = tree.length - 1; i > 1; i--) {
                    if (tree[i] == nodeIndex) {
                        if (treeMapped.get(i) % 2 == 0) {
                            hasEven = true;
                        }
                    }
                }
                if (!hasEven) {
                    result++;
                    int parent = tree[nodeIndex];
                    tree[nodeIndex] = 0;
                    int count = treeMapped.get(parent);
                    treeMapped.put(parent, --count);
                }
            }
        }
        System.out.println(result);
        scanner.close();
    }
}