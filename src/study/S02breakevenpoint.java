package study;

import java.util.Scanner;

public class S02breakevenpoint {

	public static void main(String[] args) {
		Scanner st = new Scanner(System.in);
		
		int a = st.nextInt();
		int b = st.nextInt();
		int c = st.nextInt();
		
		if (c <= b) {
			System.out.println("-1");
		}
		else {
			System.out.println((a/(c-b)+1));
		}
		
	}

}
