package serverClientExample;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import scala.annotation.meta.field;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.TimeoutException;

/**
 * <pre>
 * serverClientExample 
 * SendRabbitMQ.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 10. 4.
 * @author : yhyeon
 * @version : v1.0
 */
public class SendRabbitMQ {
	
	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws IOException, TimeoutException{
		// TODO Auto-generated method stub
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("59.12.245.249");
		factory.setUsername("admin");
        factory.setPassword("admin1234");
        factory.setVirtualHost("admin");
		int seekSize = 1048576;
		try (Connection connection = factory.newConnection(); Channel channel = connection.createChannel()) {
			RandomAccessFile rdma = new RandomAccessFile("C:\\Users\\yhyeon\\test.txt","r");
			channel.queueDeclare(QUEUE_NAME, false, false, false, null);
			byte[] readBuffer = null;
			long fileSize = rdma.length();
			long size = rdma.length()/seekSize+(rdma.length()%seekSize == 0 ? 0:1);
			for (int i = 0; i < size; i++) {
				if(fileSize < seekSize) {
					readBuffer = new byte[(int) fileSize];
				} else {
					readBuffer = new byte[seekSize];
				}
				rdma.seek(i * seekSize);
				rdma.read(readBuffer);
				fileSize = fileSize - seekSize;
				channel.basicPublish("", QUEUE_NAME, null, readBuffer);
				System.out.println(new String(readBuffer));
			}
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
