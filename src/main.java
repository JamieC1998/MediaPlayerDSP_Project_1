import java.io.File;

public class main {

	public static void main(String[] args) {
		File directory = new File("C:\\Users\\Admin\\Downloads");
		
		File[] contents = directory.listFiles();
		
		
		for(int i = 0; i < contents.length; i++) {
			if(contents[i].isFile())
				System.out.format("File Name: %s%n", contents[i].getName());
			
			else if(contents[i].isDirectory())
				System.out.format("File Name: %s%n", contents[i].getName());
		}
		
	}

}
