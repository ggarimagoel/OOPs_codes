package TreeSizeCalculator;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class TreeSizeCal implements Callable<Integer> {
    Node root;
    ExecutorService executorService;

    TreeSizeCal(Node root , ExecutorService executorService){
        this.root = root;
        this.executorService = executorService;
    }
    public Integer call() throws ExecutionException, InterruptedException {
        if (root == null) {
            return 0;
        }

    TreeSizeCal leftTree = new TreeSizeCal(root.left , executorService);
    TreeSizeCal rightTree = new TreeSizeCal(root.right , executorService);

    Future<Integer> leftsize = executorService.submit(leftTree);
    Future<Integer> rightsize = executorService.submit(rightTree);

    return leftsize.get() + rightsize.get() +1;
    }
}
