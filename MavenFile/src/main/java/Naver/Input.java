	package Naver;

import java.util.ArrayList;

public class Input {
	String title;
	String scripts;
	String date;

	public String getN() {
		return title;
	}

	public String getS() {
		return scripts;
	}

	public String getD() {
		return date;
	}

	public Input(String n, String s, String d) {
		this.date = d;
		this.scripts = s;
		this.title = n;
	}
}
