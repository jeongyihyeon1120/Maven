package serverClientExample;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Scanner;

class ReadThread {
	
	String targetDirectory;
//	deleteThread delete = null;
		
	public ReadThread() {
		// TODO Auto-generated constructor stub
	}
	
	public ReadThread(String targetDirectory) {
		this.targetDirectory = targetDirectory;
		System.out.println(targetDirectory);
//		delete = new deleteThread(targetDirectory);
	}
	
	
	public void run1() {
		int seekSize = 1048576;
		try {
			File file = new File(targetDirectory);
			RandomAccessFile rdma = new RandomAccessFile(targetDirectory,"r");
			// 바이트 단위로 파일읽기
			FileInputStream fileStream = null; // 파일 스트림
			fileStream = new FileInputStream(targetDirectory);// 파일 스트림 생성
			System.out.println("total length : " + file.length());
			// 버퍼 선언
			byte[] readBuffer = null;
			long size = rdma.length()/seekSize+(rdma.length()%seekSize == 0 ? 0:1);
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				readBuffer = new byte[seekSize];
				rdma.seek(i * seekSize);
				rdma.read(readBuffer);
				
//				System.out.print(new String(readBuffer));
				System.out.println(2);
			}
			fileStream.read(readBuffer);
			System.out.println(1);
			rdma.close();
			fileStream.close(); // 스트림 닫기
			if(file.delete()) {
				System.out.println("제거 완료");
			} else {
				System.out.println("제거 실패");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}

	}
	
}


public class TestController {
	
	public void read3(String targetDirectory) {
		System.out.println(targetDirectory);
		File file = null;
		try {
			file = new File(targetDirectory);
			byte[] fileContent = Files.readAllBytes(file.toPath());
			System.out.println(new String(fileContent, "utf-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		
		
	}
	
	public void read1(String targetDirectory) {
		System.out.println(targetDirectory);
		File afile = null;
		FileReader fileReader = null;
		BufferedReader reader = null;
		try {
            afile = new File(targetDirectory);
            fileReader = new FileReader(afile);
            reader = new BufferedReader(fileReader);
            
            String line = null;
            while((line = reader.readLine()) != null) {
            	System.out.println(line);
            }
        } catch(Exception ex) {
        	ex.printStackTrace();
        } finally {
        	try {
        		if(reader != null)	reader.close();
				if(fileReader != null) fileReader.close();
				if(afile != null) {
					if(afile.delete()) {
						System.out.println("제거 완료");
					} else {
						System.out.println("제거 실패");
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void read(String targetDirectory) {
		int seekSize = 1048576;
		try {
			File file = new File(targetDirectory);
			RandomAccessFile rdma = new RandomAccessFile(targetDirectory,"r");
			// 바이트 단위로 파일읽기
			FileInputStream fileStream = null; // 파일 스트림
			fileStream = new FileInputStream(targetDirectory);// 파일 스트림 생성
			System.out.println("total length : " + file.length());
			// 버퍼 선언
			byte[] readBuffer = null;
			long size = rdma.length()/seekSize+(rdma.length()%seekSize == 0 ? 0:1);
			System.out.println(size);
			for (int i = 0; i < size; i++) {
				readBuffer = new byte[seekSize];
				rdma.seek(i * seekSize);
				rdma.read(readBuffer);
				
			}
			fileStream.read(readBuffer);
			System.out.println(1);
			rdma.close();
			fileStream.close(); // 스트림 닫기
			if(file.delete()) {
				System.out.println("제거 완료");
			} else {
				System.out.println("제거 실패");
			}
		} catch (Exception e) {
			e.getStackTrace();
		}
		
	}
	
	public void read2(String userpath) {
		File path = new File(userpath);
        File[] f = path.listFiles();
        if (f.length == 0)
            return;
        System.out.println(f.length);
        for (int i = 0; i < f.length; i++) {
            Scanner scanner;
            try {
                scanner = new Scanner(f[i]);
                scanner.useDelimiter("\n");
                StringBuilder sb = new StringBuilder();
                while (scanner.hasNext()) {
                    sb.append(scanner.next());
                }
                scanner.close();
                String message = sb.toString();
                System.out.println(message);
            }catch (Exception e) {
				// TODO: handle exception
			}
        }
	}
	
	public void read4(String targetPath) {
		try{
            //파일 객체 생성
            File file = new File(targetPath);
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            int singleCh = 0;
            while((singleCh = filereader.read()) != -1){
                System.out.print((char)singleCh);
            }
            filereader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }

	}
	
	public static void main(String[] args) {
		String directory = "C:\\Users\\yhyeon\\testTxt\\";
		Path faxFolder = Paths.get(directory);
		String fileContent = null;
		try {

			WatchService fileWatchService = FileSystems.getDefault().newWatchService();
			faxFolder.register(fileWatchService, StandardWatchEventKinds.ENTRY_CREATE);

			boolean valid = true;
			do {
				WatchKey watchKey = fileWatchService.take();

				for (WatchEvent event : watchKey.pollEvents()) {
					WatchEvent.Kind kind = event.kind();
					if (StandardWatchEventKinds.ENTRY_CREATE.equals(event.kind())) {
						String fileName = event.context().toString();
//						ReadThread read = new ReadThread(directory + fileName);
						TestController tc = new TestController();
						tc.read4(directory + fileName);
//						File file = null;
//						try {
//							file = new File(directory + fileName);
//							System.out.println(directory + fileName);
//							byte[] fileContent1 = Files.readAllBytes(file.toPath());
//							System.out.println(new String(fileContent1, Charset.forName("UTF-8")));
//						} catch (IOException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
					}
				}
				valid = watchKey.reset();

			} while (valid);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}