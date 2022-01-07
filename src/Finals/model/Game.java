package Finals.model;

import java.util.ArrayList;

public class Game {
	String title;
	int id;
	ArrayList<Review> reviews = new ArrayList<Review>();
	
	public String getTitle() {
        return title;
    }
	
	public int getid() {
        return id;
    }
	
	public ArrayList<Review> getReviews(){
		return reviews;
	}
	
	public void setTitle(String a) {
        this.title = a;
    }
	
	public void setid(int a) {
        this.id = a;
    }
	
	public void setReviews(ArrayList<Review> a){
		this.reviews = a;
	}
	
	public String getAvg() {
		String avg = "N/A";
		int temp = 0;
		if (reviews.size()>0) {
			for (int i = 0; i < reviews.size();++i) {
				temp += reviews.get(i).rating;
			}
			avg = "" + Math.round(temp/reviews.size()) + "";
		}
		System.out.println("review:" + avg);
		System.out.print(reviews.size());
		
		return avg;
	}
	
	
}
