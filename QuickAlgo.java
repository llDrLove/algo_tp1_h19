import java.util.ArrayList;
import java.util.Collections;

//source : https://www.techiedelight.com/hybrid-quicksort/?fbclid=IwAR05cm3-l9aOPoolxpFuyCnM2KRwvnG21wey4bmMy1Ey2INABHfmshPsQfQ
public class QuickAlgo {

    private int myPivot;
    private int threshold;

    QuickAlgo (int pivot, int threshold){
        this.myPivot = pivot;
        this. threshold = threshold;
    }

	public ArrayList<Long> handle(ArrayList<Long> numbers) {
        optimizedQuickSort(numbers,0, numbers.size()-1);
        return numbers;
	}

    // perform insertion sort on arr[]
	private void insertionSort(ArrayList<Long> numbers, int low, int n)
	{
		for (int i = low + 1; i <= n; i++)
		{
			long value = numbers.get(i);
			int j = i;

			while (j > low && numbers.get(j-1) > value)
			{
                numbers.set(j, numbers.get(j-1));
				j--;
			}
			numbers.set(j, value);
		}
	}

	private int Partition (ArrayList<Long> numbers, int low, int high)
	{
		long pivot = numbers.get(high);
		int pIndex = low;
		for (int i = low; i < high; i++)
		{
			if (numbers.get(i) <= pivot)
			{
                long temp = numbers.get(i);
                numbers.set(i, numbers.get(pIndex));
                numbers.set(pIndex, temp);

				pIndex++;
			}
		}
		long temp = numbers.get(high);
        numbers.set(high, numbers.get(pIndex));
        numbers.set(pIndex, temp);

		return pIndex;
	}

	private void optimizedQuickSort(ArrayList<Long> numbers, int low, int high)
	{
		while (low < high)
		{
			if(high - low < threshold)
			{
				insertionSort(numbers, low, high);
				break;
			}
			else
			{
				int oldPivot = Partition(numbers, low, high);

				if (oldPivot - low < high - oldPivot) {
					optimizedQuickSort(numbers, low, oldPivot - 1);
					low = oldPivot + 1;
				} else {
					optimizedQuickSort(numbers, oldPivot + 1, high);
					high = oldPivot - 1;
				}
			}
		}
	}

}