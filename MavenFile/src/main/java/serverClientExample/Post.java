package serverClientExample;

import static spark.Spark.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * <pre>
 * serverClientExample 
 * Post.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 10. 4.
 * @author : yhyeon
 * @version : v1.0
 */
public class Post {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		port(45678);
		post("/message", (request, response) -> {
			String folder = "C:\\Users\\yhyeon\\testTxt";
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			Date now = new Date();
			String fileName = dateFormat.format(now);
			fileName = folder + "\\" + fileName + ".txt";
			try{
//				File file = new File(fileName);
//				file.createNewFile();
	            // BufferedWriter 와 FileWriter를 조합하여 사용 (속도 향상)
				FileWriter fileWriter = new FileWriter(fileName);
	            BufferedWriter fw = new BufferedWriter(fileWriter);
	             
	            // 파일안에 문자열 쓰기
	            fw.write(request.body());
	            fw.flush();
	            System.out.println(request.body());
	            // 객체 닫기
	            fileWriter.close();
	            fw.close();
	            
	            System.out.println("파일이 생성되었습니다.");
	             
	        }catch(Exception e){
	            e.printStackTrace();
	        }
//			try {
//	            RandomAccessFile f = new RandomAccessFile(fileName, "rw");
//	            long size = (1024 * 1024 * 1024) * 1L;
//	            f.setLength(size);
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
			
			return request.body();
		});
		
	}


}
