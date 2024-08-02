package PJT;

public class Video {
    private int no;
    private String title;
    private String part;
    private String url;

    public Video(int no, String title, String part, String url) {
        this.no = no;
        this.title = title;
        this.part = part;
        this.url = url;
    }

    public String getInfo() {
        return no + ": " + title + " (" + part + ") - " + url;
    }

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPart() {
		return part;
	}

	public void setPart(String part) {
		this.part = part;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

    // Getter와 Setter 추가 가능
}