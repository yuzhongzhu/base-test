package com.huaming.test.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TomcatTest {
	private static int PORT = 8080;
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORT);
			System.out.println("等待请求处理");
			Socket socket = serverSocket.accept();
			InputStream inputStream = socket.getInputStream();
			byte[] buffer = new byte[1024];
			String str  = "";
			
			int len = inputStream.read(buffer);
			if(len>0){
				str += new String(buffer);
				System.out.println(str);
			}
			
			System.out.println("请求处理");
			OutputStream outPutStream = socket.getOutputStream();
			PrintStream printWrite = new PrintStream(outPutStream);
			printWrite.println("HTTP/1.1 200 OK ");
			printWrite.println("Content-type:text/html;charset=utf-8");
			printWrite.println();
			printWrite.print("hello world");
			printWrite.close();
			outPutStream.flush();
			outPutStream.close();
			//inputStream.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			serverSocket.close();
		}
	}
}
