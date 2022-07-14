package study;

import java.util.Scanner;

public class S01avg {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double sum = 0;
		double max = 0;
		double[] score = new double[sc.nextInt()];
		for(int i=0; i<score.length; i++) {
			score[i] = sc.nextInt();
			if(score[i]>max) {
				max = score[i]; 
			}
		}
		for(int i=0; i<score.length; i++) {
			sum += (score[i]/max)*100;
		}
		System.out.println(sum/score.length);
	}
}


