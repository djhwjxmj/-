package udpTest;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/*���ն�
 * 1.ʹ��DatagramSocket ָ���˿� �������ն�
 * 2.׼������ ��װ��DatagramPacket ����
 * 3.����ʽ���հ���receive��DatagramPacket p��
 * 4.��������
 * byte[] getData()
 *        getLength()
 * 5.�ͷ���Դ
 */
public class UdpTypeServer2 {
	public static void main(String[] args) throws IOException {
		System.out.println("���շ�������......");
		//1.ʹ��DatagramSocket ָ���˿� �������ն�
		DatagramSocket server=new DatagramSocket(9999);
		// 2.׼������ ��װ��DatagramPacket ����
		byte[] container=new byte [1024*60];
		DatagramPacket packet=new DatagramPacket(container,0,container.length);
		// 3.����ʽ���հ���receive��DatagramPacket p��
		server.receive(packet);//����ʽ
		// 4.��������
		byte[] datas=packet.getData();
		int len=packet.getLength();
		
		DataInputStream dis= new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		String mas=dis.readUTF();
		int age=dis.readInt();
		boolean flag =dis.readBoolean();
		char ch=dis.readChar();
		System.out.println(flag+"-"+mas);
		// byte[] getData()
		//        getLength()
		// 5.�ͷ���Դ
		server.close();
	}

}
