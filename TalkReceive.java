package udpTest;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/*接收端
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.准备容器 封装成DatagramPacket 包裹
 * 3.阻塞式接收包裹receive（DatagramPacket p）
 * 4.分析数据
 * byte[] getData()
 *        getLength()
 * 5.释放资源
 */
public class TalkReceive implements Runnable {
	private DatagramSocket server;
	private String from;
	public TalkReceive (int port,String from) {
		this.from=from;
		try {
			server=new DatagramSocket(port);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		while(true) {
		byte[] container=new byte [1024*60];
		DatagramPacket packet=new DatagramPacket(container,0,container.length);
		
		try {
			server.receive(packet);
			byte[] datas=packet.getData();
			int len=packet.getLength();
			String data=new String(datas,0,len);
			System.out.println(from+":"+data);
			if(data.equals("bye")){
				break;
		    }	
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
		server.close();	
	}
	
	
	
	

}
