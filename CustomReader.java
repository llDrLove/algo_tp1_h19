import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class CustomReader {
	private String path;
	
	CustomReader(String path) {
		this.path = path;
	}
	
	public ArrayList<Integer> read() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		try {
			FileReader fileReader = new FileReader(this.path);
			BufferedReader bufferedReader = new BufferedReader(fileReader); 
			
			String singleLine = null;
			while ( (singleLine = bufferedReader.readLine() ) != null ) {
				list.add(Integer.parseInt(singleLine));
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("Error: The file was not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error reading the file : " + this.path);
			e.printStackTrace();
		} catch (Exception e) {
			return new ArrayList<Integer>();
		}
		
		return list;
	}
}
