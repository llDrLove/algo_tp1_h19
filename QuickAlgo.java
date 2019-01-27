import java.util.ArrayList;


//source : http://www.java2novice.com/java-sorting-algorithms/quick-sort/
public class QuickAlgo implements AlgoInterface {

    private int pivot;
    private int threshold;

    QuickAlgo (int pivot, int threshold){
        this.pivot = pivot;
        this. threshold = threshold;
    }

    private ArrayList<Integer> tempArray = new ArrayList<Integer>();
    private int length;

	public ArrayList<Integer> handle(ArrayList<Integer> numbers) {
		
        if (numbers == null || numbers.size() == 0) {
            return new ArrayList<Integer>();
        }
        tempArray = numbers;
        length = numbers.size();
        quickSort(0, numbers.size() - 1);

		return numbers;
	}

    private void quickSort(int lowerIndex, int higherIndex) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = tempArray.get(lowerIndex+(higherIndex-lowerIndex)/2);
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (tempArray.get(i) < pivot) {
                i++;
            }
            while (tempArray.get(j) > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j);
        if (i < higherIndex)
            quickSort(i, higherIndex);
    }
 
    private void exchangeNumbers(int i, int j) {
        int temp = tempArray.get(i);
        tempArray.set(i, tempArray.get(j));
        tempArray.set(j, temp);
    }
}