import java.util.ArrayList;

public class TP1 {
	public static void main(String args[]) {
		String algo = args[1];
		String path = args[3];
		
		// Read file & convert it to an array of integers
		CustomReader reader = new CustomReader(path);
		CustomReaderQuick readerQuick = new CustomReaderQuick(path);
		ArrayList<Integer> numbers = reader.read();
		ArrayList<Long> numbersQuick = readerQuick.read();

		ArrayList<Integer> result = null;
		ArrayList<Long> resultQuick = null;
		
		AlgoInterface currentAlgo = null;	
		QuickAlgo currentAlgoQuick = null;

		long start = 0;
		long end = 0;

		if (algo.equals("counting")) {
			currentAlgo = new CountingAlgo();
			start = System.currentTimeMillis();
			result = currentAlgo.handle(numbers);
			end = System.currentTimeMillis();
		} else if (algo.equals("quick")) {
			currentAlgoQuick = new QuickAlgo(0, 1);
			start = System.currentTimeMillis();
			resultQuick = currentAlgoQuick.handle(numbersQuick);
			end = System.currentTimeMillis();
		} else if (algo.equals("quickSeuil")) {
			currentAlgoQuick = new QuickAlgo(0, 20);
			start = System.currentTimeMillis();
			resultQuick = currentAlgoQuick.handle(numbersQuick);
			end = System.currentTimeMillis();
		} else if (algo.equals("quickRandomSeuil")) {
			int rand = (int)(Math.random() * numbersQuick.size());
			currentAlgoQuick = new QuickAlgo(rand, 20);
			start = System.currentTimeMillis();
			resultQuick = currentAlgoQuick.handle(numbersQuick);
			end = System.currentTimeMillis();
		} else {
			System.out.println("Whoops! You did not provided a good algorithm.");
			return;
		}
		
		if(result != null){
			if (args.length >= 5) {
				if (args[4].equals("-p")) {
					printArray(result);
				} else if (args[4].equals("-t")) {
					System.out.println((end - start));
				}
			}
			
			if (args.length == 6) {
				if (args[5].equals("-p") && ! args[4].equals("-p")) {
					printArray(result);
				} else if (args[5].equals("-t") && ! args[4].equals("-t")) {
					System.out.println((end - start));
				}
			}
		}
		else{
			if (args.length >= 5) {
				if (args[4].equals("-p")) {
					printArrayQuick(resultQuick);
				} else if (args[4].equals("-t")) {
					System.out.println((end - start));
				}
			}
			
			if (args.length == 6) {
				if (args[5].equals("-p") && ! args[4].equals("-p")) {
					printArrayQuick(resultQuick);
				} else if (args[5].equals("-t") && ! args[4].equals("-t")) {
					System.out.println((end - start));
				}
			}
		}
	}

	//public static void startAlgo(ArrayList<Any> numbers){
	//	long start = System.currentTimeMillis();
	//	result = currentAlgo.handle(numbers);
	//	long end = System.currentTimeMillis();
	//}
	
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
	
	public static void printArrayQuick(ArrayList<Long> result){
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
