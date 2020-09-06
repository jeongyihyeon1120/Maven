package News;

import com.mysql.fabric.xmlrpc.base.Struct;

public class Input {
	String title;
	String script;
	String id;
	String date;
	String category;
	private String getId() {
		return id;
	}
	public String getN() {
		return title;
	}
	public String getS() {
		return script;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getCat() {
		return category;
	}
	public Input(String category, String id, String date, String title, String script) {
		this.category = category;
		this.id = id;
		this.date = date;
		this.title = title;
		this.script = script;
	}
	@Override
	public String toString() {
		return "제목: " + title + "// 본문:" + script + "// 아이디: "+ id +"\n - - - - - - - - - - - - - - - - - - - - - - - - - - 0 - - - - - - - - - - - - - - - - - - - - - - - - - -";
	}
}
