package com.basic;

import java.net.*;

//Java DatagramPacket is a message that can be sent or received. If you send multiple packet, it may arrive in any order. 
//Additionally, packet delivery is not guaranteed.

public class DatagramPacketReceive {

	public static void main(String[] args) throws Exception {
		
		DatagramSocket ds = new DatagramSocket(3000);
		byte[] buf = new byte[1024];
		DatagramPacket dp = new DatagramPacket(buf, 1024);
		ds.receive(dp);
		
		System.out.println("Receiver received packet...");
		
		String str = new String(dp.getData(), 0, dp.getLength());
		System.out.println(str);
		ds.close();
	}
}
