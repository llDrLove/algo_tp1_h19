import java.util.ArrayList;


// source : https://www.hackerearth.com/fr/practice/algorithms/sorting/counting-sort/tutorial/?fbclid=IwAR2srf-2PhLlh-M9VuQ692BtZIrmLQ3jdhV4n3DWi6ZMrSI6mU_oDdZs41g
public class CountingAlgo implements AlgoInterface {
	public ArrayList<Integer> handle(ArrayList<Integer> numbers) {
		
		// find max value
		int max = 0;
		for(int i = 0; i < numbers.size(); i++){
			if(max <= numbers.get(i)){
				max = numbers.get(i);
			}
		}
		
		// set tab for counting each index
		ArrayList<Integer> planningTab = new ArrayList<Integer>();
		for(int i = 0; i <= max; i++){
			planningTab.add(0);
		}
		
		// fill the array with frequency
		for(int i = 0; i < numbers.size(); i++){
			int value = planningTab.get(numbers.get(i));
			planningTab.set(numbers.get(i), ++value);
		}
		
		// create the sorted list
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i < planningTab.size(); i++){
			for(int j = 0; j < planningTab.get(i); j++){
				result.add(i);
			}
		}
		
		return result;
	}
}
