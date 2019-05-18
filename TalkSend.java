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


/*���Ͷ�
 * 1.ʹ��DatagramSocket ָ���˿� �������ն�
 * 2.���������� ת���ֽ�����
 * 3.��װ��DatagramPacket ��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send����receive��DatagramPacket p��
 * 5.�ͷ���Դ
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
