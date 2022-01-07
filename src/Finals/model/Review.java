package Finals.model;

public class Review {
	int g_id;
	int id;
	String author;
	int rating;
	String review;
	
	public int getid() {
        return id;
    }
	
	public int getg_id() {
        return g_id;
    }
	
	public int getrating() {
        return rating;
    }
	
	public String getauthor() {
        return author;
    }
	
	public String getreview() {
        return review;
    }
	
	public void setid(int a) {
		this.id = a;
    }
	
	public void setg_id(int a) {
		this.g_id = a;
    }
	
	public void setrating(int a) {
		this.rating = a;
    }
	
	public void setauthor(String a) {
		this.author = a;
    }
	
	public void setreview(String a) {
		this.review = a;
    }
}
