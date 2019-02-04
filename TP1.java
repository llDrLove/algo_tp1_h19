import java.util.ArrayList;

public class TP1 {
	public static void main(String args[]) {
		String algo = args[1];
		String path = args[3];
		
		// Read file & convert it to an array of integers
		CustomReader reader = new CustomReader(path);
		ArrayList<Integer> numbers = reader.read();
		
		AlgoInterface currentAlgo = null;	
		if (algo.equals("counting")) {
			currentAlgo = new CountingAlgo();
		} else if (algo.equals("quick")) {
			currentAlgo = new QuickAlgo(0, 1);
		} else if (algo.equals("quickSeuil")) {
			currentAlgo = new QuickAlgo(0, 30);
		} else if (algo.equals("quickRandomSeuil")) {
			int rand = (int)(Math.random() * numbers.size());
			currentAlgo = new QuickAlgo(rand, 25);
		} else {
			System.out.println("Whoops! You did not provided a good algorithm.");
			return;
		}
		
		long start = System.currentTimeMillis();
		ArrayList<Integer> result = currentAlgo.handle(numbers);
		long end = System.currentTimeMillis();
		
		if (args.length >= 5) {
			if (args[4].equals("-p")) {
				printArray(result);
			} else if (args[4].equals("-t")) {
				System.out.println(path + "," + (result.size() > 0 ? (end - start) : 0) );
				//System.out.println("The time took : " + (end - start) + " ms");
			}
		}
		
		if (args.length == 6) {
			if (args[5].equals("-p") && ! args[4].equals("-p")) {
				printArray(result);
			} else if (args[5].equals("-t") && ! args[4].equals("-t")) {
				System.out.println(path + "," + (end - start));
				//System.out.println("The time took : " + (end - start) + " ms");
			}
		}
	}
	
	public static void printArray(ArrayList<Integer> result){
		System.out.print("[");
		for(int i = 0; i < result.size(); i++){
			System.out.print(result.get(i));
			if (i != result.size() - 1) {
				System.out.print(",");
			}
		}
		System.out.print("]");
	}
}
