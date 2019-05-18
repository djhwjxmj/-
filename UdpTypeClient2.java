package udpTest;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;


/*���Ͷ�
 * 1.ʹ��DatagramSocket ָ���˿� �������ն�
 * 2.���������� ת���ֽ�����
 * 3.��װ��DatagramPacket ��������Ҫָ��Ŀ�ĵ�
 * 4.���Ͱ���send����receive��DatagramPacket p��
 * 5.�ͷ���Դ
 */

public class UdpTypeClient2 {
	public static void main(String[] args) throws IOException {
		System.out.println("���ͷ�������......");
		//1.ʹ��DatagramSocket ָ���˿� �������ն�
		DatagramSocket client =new DatagramSocket(8888);
		//2.���������� ת���ֽ�����
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		DataOutputStream dos= new DataOutputStream(baos);
		dos.writeUTF("����������");
		dos.writeInt(18);
		dos.writeBoolean(false);
		dos.writeChar('a');
		dos.flush();
		byte[] datas=baos.toByteArray();
		//3.��װ��DatagramPacket ��������Ҫָ��Ŀ�ĵ�
		DatagramPacket packet= new DatagramPacket(datas,0,datas.length,
				new InetSocketAddress("localhost",9999));
		//4.���Ͱ���send����receive��DatagramPacket p��
		client.send(packet);
		//5.�ͷ���Դ
		client.close();
	}

}
