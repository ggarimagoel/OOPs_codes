package MergeSort;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = Arrays.asList(2,5,3,9,10,8,1,7);

        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter sorter = new MergeSorter(list,executorService);
        Future<List<Integer>> promisedList = executorService.submit(sorter);
        List<Integer> sortedList = promisedList.get();
        System.out.println(sortedList);
        executorService.shutdown();
    }
}
