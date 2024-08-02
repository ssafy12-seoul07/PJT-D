package PJT;

public class Review {
    private String user;
    private String content;
    private int rating;

    public Review(String user, String content, int rating) {
        this.user = user;
        this.content = content;
        this.rating = rating;
    }

    public String display() {
        return user + ": " + content + " (" + rating + "/5)";
    }

    public void edit(String content) {
        this.content = content;
    }

    public void delete() {
        // 삭제 로직은 리뷰 리스트에서 직접 제거해야 합니다.
    }

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

    // Getter와 Setter 추가 가능
}
