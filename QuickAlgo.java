import java.util.ArrayList;
import java.util.Collections;

//source : https://gist.github.com/aaani/6337280
// et https://www.techiedelight.com/hybrid-quicksort/?fbclid=IwAR05cm3-l9aOPoolxpFuyCnM2KRwvnG21wey4bmMy1Ey2INABHfmshPsQfQ
public class QuickAlgo {

    private int pivot;
    private int threshold;

    QuickAlgo (int pivot, int threshold){
        // set pivot and threshold
        this.pivot = pivot;
        this. threshold = threshold;
    }

	public ArrayList<Long> handle(ArrayList<Long> numbers) {
        quicksort(numbers,0, numbers.size()-1);
        return numbers;
	}

    public void swap(ArrayList<Long> elements, int i, int j){
        //Method to swap 2 elements in an arraylist
        Long temp= elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
    
    public int partition(ArrayList<Long> elements, int beg, int end){
        
        //Get a fonctionnal pivot
        int myPivot = beg;
        if(pivot != 0){
            myPivot = beg + ((int)Math.random()*(end-beg));
        }

        //New position of pivot element
        int last = end;
        
        //Move the pivot element to right edge of the array
        swap(elements, myPivot, end);
        end--;
        
        while(beg <= end){
            if(elements.get(beg) < elements.get(last)) beg++; //Accumulate smaller elements to the left
            else {
                swap(elements, beg, end);
                end--;
            }
        }
        
        //Move pivot element to its correct position
        swap(elements, beg, last);
        
        return beg;
    }
    
    public void quicksort(ArrayList<Long> elements, int beg, int end){
        if(beg >= end || beg < 0 || end > elements.size() - 1) return;
        
        int oldPivot = partition(elements, beg, end);

        //first half
        if(oldPivot - beg + 1 >= threshold){
            quicksort(elements, beg, oldPivot-1);
        }
        else if(oldPivot - beg > 1){ // if this part of the list is smaller than the threshold
            replaceElem(elements, beg, oldPivot-1);
        }

        //second half
        if(end - oldPivot + 1 >= threshold){
            quicksort(elements, oldPivot+1, end);
        }
        else if(end - oldPivot > 1){ // if this part of the list is smaller than the threshold
            replaceElem(elements, oldPivot+1, end);
        }
    }

    //source : https://www.geeksforgeeks.org/insertion-sort/
    public void replaceElem(ArrayList<Long> numbers, int beg, int end){
        // insertion sort
        for (int i = beg + 1; i <= end; i++)
		{
			long value = numbers.get(i);
			int j = i;

			while (j > beg && numbers.get(j-1) > value)
			{
                numbers.set(j, numbers.get(j-1));
				j--;
			}
			numbers.set(j, value);
		}
    }

}