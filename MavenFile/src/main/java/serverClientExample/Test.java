package serverClientExample;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;

/**
 * <pre>
 * serverClientExample 
 * Test.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 10. 11.
 * @author : yhyeon
 * @version : v1.0
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "C:\\Users\\yhyeon\\testTxt\\20201011191702319.txt";
		File file = null;
		try {
			file = new File(path);
			byte[] fileContent1 = Files.readAllBytes(file.toPath());
			System.out.println(new String(fileContent1, Charset.forName("UTF-8")));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
