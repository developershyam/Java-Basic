package com.basic;

import java.io.*;
import java.net.*;

//Socket and ServerSocket classes are used for connection-oriented socket programming and DatagramSocket.

public class SocketSender {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(6666);
			Socket s = ss.accept();// establishes connection
			DataInputStream dis = new DataInputStream(s.getInputStream());
			String str = (String) dis.readUTF();
			System.out.println("Server received messsage...");
			System.out.println("message= " + str);
			ss.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
