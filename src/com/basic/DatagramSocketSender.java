package com.basic;

import java.net.*;

//Java DatagramSocket class represents a connection-less socket for sending and receiving datagram packets.
//A datagram is basically an information but there is no guarantee of its content, arrival or arrival time.

public class DatagramSocketSender {
	public static void main(String[] args) throws Exception {
		
		DatagramSocket ds = new DatagramSocket();
		InetAddress ip = InetAddress.getByName("127.0.0.1");
		String str = "Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java"+
				"Welcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome javaWelcome java **";
		

		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), ip, 3000);
		
		ds.send(dp);
		System.out.println("Server send packet..."+str);
		ds.close();
	}
}
