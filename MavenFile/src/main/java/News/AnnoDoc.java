package News;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//import javax.print.DocFlavor.STRING;

@Entity
@Table(name = "NEWS")
public class AnnoDoc {
	@Id
	@Column(name = "category",columnDefinition = "VARCHAR")
	private String category;
	
	@Column(name = "id",columnDefinition = "INT")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	
	@Column(name = "title",columnDefinition = "VARCHAR")
	private String title;
	
	@Column(name = "script",columnDefinition = "TEXT")
	private String script;
	
	@Column(name = "date", columnDefinition = "VARCHAR")
	private String date;
	
	public AnnoDoc() {
		// TODO Auto-generated constructor stub
	}
	
	public AnnoDoc(String category ,String id, String title, String script, String date) {
		// TODO Auto-generated constructor stub
		this.category = category;
		this.id = id;
		this.title = title;
		this.script = script;
		this.date = date;
	}
	

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getScript() {
		return script;
	}
}
