package ex15usefulclass;

import java.util.Random;

public class E07Random {

	public static void main(String[] args) {

		/*
		Random클래슨느 객체 생성시 전달되는 Seed(씨앗)을 기반으로 난수를 생성한다.
		만약 Seed가 동일하면 항상 같은 패턴의 난수가 생성되는데, 이를 
		가짜난수(Pseudo-random number)라고 한다.
		 */
		System.out.println("# 가짜난수 : 같은 패턴의 난수만 생성됨");
		Random random1 = new Random(32);
		for (int i = 0; i < 10; i++) {
			System.out.print(random1.nextInt(100)+" ");
		}
		
		/*
		nextInt(N) : 0 ~ N-1까지의 난수가 생성된다.
		 */
		System.out.println("\n# 난수생성1 : 씨드없음");
		Random random2 = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.print(random2.nextInt(100)+" ");
		}
		
		/*
		씨드를 부여하려면 setSeed()메서드를 사용한다. 이때 현재시간을 밀리세컨즈
		단위로 반환하는 currentTimeMillis()를 사용하면 편리하다.
		 */
		System.out.println("\n# 난수생성2 : 변화하는 시간으로 씨드지정");
		Random random3 = new Random();
		random3.setSeed(System.currentTimeMillis());
		for (int i = 0; i < 10; i++) {
			System.out.print(random2.nextInt(100)+" ");
		}
		
		/*
		nextInt()에 인수가 없는 경우에는 음수, 양수가 혼용된 난수가 생성된다.
		 */
		System.out.println("\n# 난수생성3 : nextInt() 인수없음");
		Random random4 = new Random();
		for (int i = 0; i < 10; i++) {
			System.out.print(random4.nextInt()+" ");
		}
	}
}
