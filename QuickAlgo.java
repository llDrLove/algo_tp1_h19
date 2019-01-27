import java.util.ArrayList;
import java.util.Collections;

//source : https://gist.github.com/aaani/6337280
public class QuickAlgo implements AlgoInterface {

    private int pivot;
    private int threshold;

    QuickAlgo (int pivot, int threshold){
        this.pivot = pivot;
        this. threshold = threshold;
    }

	public ArrayList<Integer> handle(ArrayList<Integer> numbers) {
        quicksort(numbers,0, numbers.size()-1);
        return numbers;
	}

    public void swap(ArrayList<Integer> elements, int i, int j){
        //Method to swap 2 elements in an arraylist
        int temp= elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }
    
    public int partition(ArrayList<Integer> elements, int beg, int end){
        
        //Get a fonctionnal pivot
        int myPivot;
        if(pivot == 0){
            myPivot = beg;
        }
        else{
            myPivot = beg + ((int)Math.random()*(elements.size()))/(end-beg+1);
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
    
    public void quicksort(ArrayList<Integer> elements, int beg, int end){
        if(beg >= end || beg < 0 || end > elements.size() - 1) return;
        
        int oldPivot = partition(elements, beg, end);
        if(oldPivot - beg + 1 >= threshold){
            quicksort(elements, beg, oldPivot-1);
        }
        else if(oldPivot - beg > 1){
            replacteElem(elements, beg, oldPivot-1);
        }
        if(end - oldPivot + 1 >= threshold){
            quicksort(elements, oldPivot+1, end);
        }
        else if(end - oldPivot > 1){
            replacteElem(elements, oldPivot+1, end);
        }
        //quicksort(elements, beg, oldPivot-1);
        //quicksort(elements, oldPivot+1, end);
    }

    public void replacteElem(ArrayList<Integer> elements, int beg, int end){
        ArrayList<Integer> tempList = new ArrayList<Integer>(elements.subList(beg, end));
        Collections.sort(tempList);
        int counter = 0;
        for(int i = beg; i < end; i++){
            elements.set(i, tempList.get(counter));
            counter++;
        }
    }

}