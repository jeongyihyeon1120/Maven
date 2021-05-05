package serverClientExample;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import scala.reflect.macros.Attachments;

/**
 * <pre>
 * serverClientExample 
 * ReceiverMQ.java
 *
 * 설명 :
 * </pre>
 * 
 * @since : 2020. 10. 4.
 * @author : yhyeon
 * @version : v1.0
 */
public class ReceiverMQ {

	private final static String QUEUE_NAME = "hello";
	
	public static void main(String[] args) throws IOException, TimeoutException {
		// TODO Auto-generated method stub
		ReceiverMQ mq = new ReceiverMQ();
		mq.receiveQ();
	}
	
	public void receiveQ() throws IOException, TimeoutException {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("59.12.245.249");
		factory.setUsername("admin");
        factory.setPassword("admin1234");
        factory.setVirtualHost("admin");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		Consumer consumer = new DefaultConsumer(channel) {
			private HttpPost request;
			private CloseableHttpClient client;
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties,
					byte[] body) throws IOException {
				client = HttpClients.createDefault();
				request = new HttpPost("http://localhost:45678/message");
//				String message = new String(body, "UTF-8");
//				System.out.println(body);
				if (body != null && body.length > 0) {	
//					System.out.println(body);
//					postSend(body);
					try {
						//  추가할 데이터
						HttpEntity entity = new ByteArrayEntity(body);
						request.setEntity(entity);
						
						//  전송
						HttpResponse response = client.execute(request);
						
						//  응답
						String result = EntityUtils.toString(response.getEntity());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
				} else {
					System.out.println("없습니다");
				}
//				System.out.println(" [x] Received '" + message + "'");
			}
		};
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
	
//	private void postSend(byte[] data) {
//		
//		try {
//			//  추가할 데이터
//			HttpEntity entity = new ByteArrayEntity(data);
//			request.setEntity(entity);
//			
//			//  전송
//			HttpResponse response = client.execute(request);
//			
//			//  응답
//			String result = EntityUtils.toString(response.getEntity());
//			System.out.println(result);
//		} catch (IOException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//		
//	}
}
