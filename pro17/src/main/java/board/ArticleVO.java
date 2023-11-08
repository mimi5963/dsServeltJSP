package board;

import java.sql.Date;

import lombok.Data;

@Data
public class ArticleVO {
	private int articleno;
	private String title;
	private String content;
	private String imageFileName;
	private Date writeDate;
	private String id;
	private int gno; //그룹번호
	private int ono; // 그룹내 순서
	private int nested; // 들여쓰기정도
	
	public String getContentToHtml() {
		return content==null ? "" :content.replace("\n","<br>");
	}
}
