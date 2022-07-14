package ex18lambda;

public class Human {

	String name;
	String gender;
	int score;
	//생성자
	public Human(String name, String gender, int score) {
		super();
		this.name = name;
		this.gender = gender;
		this.score = score; 
	}
	//게터세터
	public String getName() {
		return name;
	}
	public String getGender() {
		return gender;
	}
	public int getScore() {
		return score;
	}
}
	
