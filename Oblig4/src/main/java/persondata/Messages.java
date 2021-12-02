package persondata;

import java.sql.Timestamp;
import java.util.Random;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(schema = "obl4")
public class Messages {
	
	@Id
	private int message_id;
	
	private String message_subject;
	private String message_contents;
	private Timestamp created_on;
	private int message_author;
	
	public Messages() {
		
	}
	
	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public String getMessage_subject() {
		return message_subject;
	}

	public void setMessage_subject(String message_subject) {
		this.message_subject = message_subject;
	}

	public String getMessage_contents() {
		return message_contents;
	}

	public void setMessage_contents(String message_contents) {
		this.message_contents = message_contents;
	}

	public Timestamp getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Timestamp created_on) {
		this.created_on = created_on;
	}

	public int getMessage_author() {
		return message_author;
	}

	public void setMessage_author(int message_author) {
		this.message_author = message_author;
	}

	public Messages(String message_subject, String message_contents, Timestamp created_on, int message_author) {
		this.message_id = generateId();
		this.message_subject = message_subject;
		this.message_contents = message_contents;
		this.created_on = created_on;
		this.message_author = message_author;
	}

	@Override
	public String toString() {
		return "Messages [message_id=" + message_id + ", message_subject=" + message_subject + ", message_contents="
				+ message_contents + ", created_on=" + created_on + ", message_author=" + message_author + "]";
	}
	
	private int generateId() {
		Random r = new Random();
		String result = "";
		for(int i = 0; i < 8; i++) {
			result += r.nextInt(10);
		}
		int res = Integer.parseInt(result);
		return res;
	}
	

}
