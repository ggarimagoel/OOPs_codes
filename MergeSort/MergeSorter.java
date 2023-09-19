package MergeSort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MergeSorter implements Callable<List<Integer>> {
    List<Integer> listToSort;
    ExecutorService executorService;

    public MergeSorter(List<Integer> listToSort , ExecutorService executorService){
        this.listToSort = listToSort;
        this.executorService = executorService;
    }
    public List<Integer> call() throws ExecutionException, InterruptedException {

        if(listToSort.size() <= 1){
            return listToSort;
        }
        List<Integer> firstHalf = new ArrayList<>();
        List<Integer> secondHalf = new ArrayList<>();

        // populating firstHalf and SeconfHalf lists with half and half values of listToSort
        for(int i = 0; i < listToSort.size(); i++){
            if(i < listToSort.size()/2){
                firstHalf.add(listToSort.get(i));
            }else{
                secondHalf.add(listToSort.get(i));
            }
        }
        MergeSorter mergeSorterLeft = new MergeSorter(firstHalf, executorService);
        MergeSorter mergeSorterRight = new MergeSorter(secondHalf, executorService);

        /*
        List<Integer> sortedLeft = mergeSorterLeft.call();
        List<Integer> sortedRight = mergeSorterRight.call();

        the above code is using just 2 threads , main and one in mergeSorter and not the thread pool,
        because we are directly using call() method (bec of call() this function is called directly)
         */

        // so we use .submit() , .get() method, which will use thread pool and ExecutorService

        Future<List<Integer>> promiseLeft = executorService.submit(mergeSorterLeft);
        Future<List<Integer>> promiseRight = executorService.submit(mergeSorterRight);

        List<Integer> sortedLeft = promiseLeft.get();
        List<Integer> sortedRight= promiseRight.get();

        List<Integer> sortedList = new ArrayList<>();
        int i = 0; int j = 0; int k = 0;

        while(i < sortedLeft.size() && j <  sortedRight.size()) {
            if (sortedLeft.get(i) <= sortedRight.get(j)) {
                sortedList.add(sortedLeft.get(i));
                i++;
                k++;
            } else {
                sortedList.add(sortedRight.get(j));
                j++;
                k++;
            }
        }
            while(i < sortedLeft.size()){
                sortedList.add(sortedLeft.get(i));
                i++;k++;
            }
            while(j < sortedRight.size()){
                sortedList.add(sortedRight.get(j));
                j++;k++;
            }
        return sortedList;
    }
}
