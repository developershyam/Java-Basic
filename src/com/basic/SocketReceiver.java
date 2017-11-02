package com.basic;

import java.io.*;
import java.net.*;

public class SocketReceiver {

	public static void main(String[] args) {
		try {
			Socket s = new Socket("localhost", 6666);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello Server");
			dout.flush();
			dout.close();
			s.close();
			System.out.println("Client send messsage...");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
