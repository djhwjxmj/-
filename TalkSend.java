package udpTest;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


/*发送端
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.将基本类型 转成字节数组
 * 3.封装成DatagramPacket 包裹，需要指定目的地
 * 4.发送包裹send包裹receive（DatagramPacket p）
 * 5.释放资源
 */

public class TalkSend implements Runnable {
	private DatagramSocket client;
	private BufferedReader reader;
	private String toIp;
	private int toPort;
	public TalkSend(int port,String toIp,int toPort) {
		this.toIp=toIp;
		this.toPort=toPort;
		try {
			client=new DatagramSocket(port);
			reader =new BufferedReader(new InputStreamReader(System.in));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void run() {
		while(true) {
			String data;
			try {
				data= reader.readLine();
				byte[] datas=data.getBytes();
				DatagramPacket packet= new DatagramPacket(datas,0,datas.length,
					new InetSocketAddress(this.toIp,this.toPort));
				client.send(packet);
				if(data.equals("bye")){
					break;
			    }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		client.close();
		
		
	}
	
}
