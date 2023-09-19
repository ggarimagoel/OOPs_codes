package TreeSizeCalculator;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Node root = new Node(10);
        root.right = new Node(30);
        root.left = new Node(30);
        root.right.right = new Node(11);
        root.right.left = new Node(11);
        root.left.right = new Node(11);

        ExecutorService executorService = Executors.newCachedThreadPool();
        TreeSizeCal treeSizeCal = new TreeSizeCal(root,executorService);
        Future<Integer> treeSize = executorService.submit(treeSizeCal);

        System.out.println( "size of tree :  " + treeSize.get());
    }
}
