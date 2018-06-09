package ase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

import dbdao.DbStorage;

public class WeightFunction {

	Socket pingSocket = null;
	PrintWriter out = null;
	BufferedReader in = null;

	DbStorage Storage = new DbStorage();
	public WeightFunction() {
		try {
			this.pingSocket = new Socket("169.254.2.2", 8000);
			System.out.println("step one");
			this.out = new PrintWriter(pingSocket.getOutputStream(), true);
			System.out.println("step two");
			this.in = new BufferedReader(new InputStreamReader(pingSocket.getInputStream()));
			System.out.println("step three");
		} catch(IOException e) {
			System.out.println("fail");
		}
	}
	// S crlf
	public int getWeight() {
		try {
			out.println("S");
			String str = in.readLine().replaceAll("\\D+","");
			int h = Integer.parseInt(str);
			return h;
		} catch (IOException e) {
			return -1;
		}

	}

	// T crlf
	public int WeightTare() throws IOException {
		try {
			out.println("T");
			String str = in.readLine().replaceAll("\\D+","");
			int h = Integer.parseInt(str);
			return h;
		} catch (IOException e) {
			return -1;
		}
	}

	// D "text" crlf
	public void writeInDisplay(String text, int seconds) {
		out.println("D \"" + text + "\"");
		try {
			TimeUnit.SECONDS.sleep(seconds);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//DW crlf
	public void returnToWeight() {
		out.println("DW");
		try {
			in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//P111 "text" crlf
	public void writeLongStringInDisplay(String text, int seconds) {
		out.println("P111 \"" + text + "\"");
		try {
			in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getStringFromDisplay(String msg) throws IOException {
		out.println("RM20 8 \""+ msg + "\" \"\" \"&3\"");
		in.readLine();
		in.readLine();
		while(!in.ready()) {
			
		}
		
		in.skip(6);
		String str = in.readLine();
		return str;
	}

	public void resetInputStream() {
		String str = null;
		try {
			while(str != null) {
				str = in.readLine();
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
