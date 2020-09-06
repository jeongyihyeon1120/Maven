package News;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;

public class Server {
	static Input i = null;

	public static void main(String[] args) throws IOException {
		ArrayList<String> b = new ArrayList<String>();
		Anno_query anno = new Anno_query();
		ServerSocket server = null;
		Socket sock = null;
		System.out.println(". . . Waiting Connect . . .");
		server = new ServerSocket(10001);
		while (true) {

			try {
				sock = server.accept();
//				if (b.size() == 52) {
//					System.out.println();
//				}
				InputStream in = sock.getInputStream();
				BufferedReader br = new BufferedReader(new InputStreamReader(in));
				i = new Gson().fromJson(br.readLine(), Input.class);
				b.add(i.id);
				System.out.println(b.size());
				System.out.println(i.id);
				System.out.println(i.title);
				anno.infoSave(i.category,i.id, i.title, i.script, i.date);
			} catch (Exception e) {
			} finally {
				sock.close();
			}
		}

	}
}
