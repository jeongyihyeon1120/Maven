package serverClientExample;

import java.io.*;
import java.nio.file.*;

/**
 * <pre>
 * serverClientExample 
 * Monitor.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 10. 25.
 * @author : yhyeon
 * @version : v1.0
 */
public class Monitor {
	public static void main(String args[]) throws IOException, InterruptedException {
		monitoringDir("C:\\Users\\yhyeon\\testTxt\\");
	}

	static void monitoringDir(String dir) throws IOException, InterruptedException {
		/**
		 * public abstract WatchService newWatchService() throws IOException;
		 * WatchService란 파일변화, 이벤트변화 등에 대해 오브젝트를 등록하는 것 예를들면 디렉토리등의 파일 변화를 감지하기에 적합하다.
		 */
		WatchService myWatchService = FileSystems.getDefault().newWatchService();
		String targetPath = null;
		Monitor m = new Monitor();
		// 모니터링을 원하는 디렉토리 Path를 얻는다.
		Path path = Paths.get(dir); // Get the directory to be monitored

		// 모니터링 서비스를 할 path에 의해 파일로케이션을 등록
		WatchKey watchKey = path.register(myWatchService, StandardWatchEventKinds.ENTRY_CREATE,
				StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE); // Register the directory

		// 무한루프
		while (true) {
			File file = null;
			// 변화가 감지되는 경우 이벤트 종류와 파일명을 출력
			for (WatchEvent event : watchKey.pollEvents()) {
				System.out.println(event.kind() + ": " + event.context());
				targetPath = dir + event.context().toString();
				file = m.read1(targetPath);
//				m.delete(m.read1(targetPath));

			}
			m.delete(file);
			// * Resets this watch key.
			// * @return {@code true} if the watch key is valid and has been reset
			// * {@code false} if the watch key could not be reset because it is
			// * no longer {@link #isValid valid}, 디렉토리등이 삭제되는 경우
			if (!watchKey.reset()) {
				break; // 디렉토리등이 삭제되는 경우
			}
		}
	}

	public void read(String targetPath) {
		try {
			// 파일 객체 생성
			File file = new File(targetPath);
			// 입력 스트림 생성
			FileReader filereader = new FileReader(file);
			int singleCh = 0;
			String message = "";
			while ((singleCh = filereader.read()) != -1) {
//                System.out.print((char)singleCh);
				message = message + (char) singleCh;
			}
			System.out.println(message + "\n");
			filereader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	public File read1(String targetPath) {
		InputStream ios = null;
		File file = new File(targetPath);
//		Thread th = new Thread();
		try {
			byte[] buffer = new byte[4096];
			ios = new FileInputStream(file);
			int read = 0;
			while ((read = ios.read(buffer)) != -1) {
			}
			String message = new String(buffer, "UTF-8");
			System.out.println(message);
			return file;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if (ios != null)
					ios.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public void delete(File file) {
		if (file != null) {
			if (file.delete()) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("삭제 실패");
			}
		}
	}

}
