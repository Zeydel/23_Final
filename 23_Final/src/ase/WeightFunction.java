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

	public WeightFunction() {
		try {
			this.pingSocket = new Socket("169.254.2.3", 8000);
			this.out = new PrintWriter(pingSocket.getOutputStream(), true);
			this.in = new BufferedReader(new InputStreamReader(pingSocket.getInputStream()));
			in.readLine();
			out.println("K 3");
		} catch(IOException e) {
			System.out.println("Connection Failed");
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
	public void writeLongStringInDisplay(String text) {
		out.println("P111 \"" + text + "\"");
		try {
			in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getStringFromDisplay(String msg) throws IOException {
		out.flush();
		out.println("RM20 8 \""+ msg + "\" \"\" \"&3\"");
		String strtest = in.readLine();
		in.skip(6);
		String str = in.readLine();
		return str;
	}
	
	public void waitForInput() {
		try {
			while(!in.ready()) {
				
			};
		in.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearInputStream() {
		String str;
		try {
			while((str = in.readLine()) != null) {
				System.out.println(str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
