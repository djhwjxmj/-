package udpTest;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


/*发送端
 * 1.使用DatagramSocket 指定端口 创建接收端
 * 2.将基本类型 转成字节数组
 * 3.封装成DatagramPacket 包裹，需要指定目的地
 * 4.发送包裹send包裹receive（DatagramPacket p）
 * 5.释放资源
 */

public class UdpTypeClient2 {
	public static void main(String[] args) throws IOException {
		System.out.println("发送方启动中......");
		//1.使用DatagramSocket 指定端口 创建接收端
		DatagramSocket client =new DatagramSocket(8888);
		//2.将基本类型 转成字节数组
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos= new DataOutputStream(baos);
		dos.writeUTF("编码辛酸泪");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas=baos.toByteArray();
		//3.封装成DatagramPacket 包裹，需要指定目的地
		DatagramPacket packet= new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("localhost",9999));
		//4.发送包裹send包裹receive（DatagramPacket p）
		client.send(packet);
		//5.释放资源
		client.close();
	}

}
