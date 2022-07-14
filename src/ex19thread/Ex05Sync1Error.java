package ex19thread;

//2개의 쓰레드가 공유객체로 사용할 클래스
class SumMulti {
	int num;
	public SumMulti() {
		num=0;
	}
	//매개변수로 전달되는 n을 멤버변수에 더한다.
	public void addNum(int n) {
		num += n;
	}
	//멤버변수 반환
	public int getNum() {
		return num;
	}
}
class MultiAdderThread extends Thread {
	//앞에서 정의한 공유객체를 멤버변수로 선언
	SumMulti sumInst;
	int start, end;
	//생성자에서는 메멉변수 초기화
	public MultiAdderThread(SumMulti sum, int s, int e) {
		sumInst = sum;
		start = s;
		end = e;
	}
	/*
	쓰레드를 통해 반복적으로 공유객체인 sumInst의 addNum()을 호출한다.
	이 경우 동기화 처리가 되지않아 동시에 접근이되는 경우가 발생하게 되어
	잘못된 결과가 출력된다.
	 */
	
	public void run() {
		for(int i=start ; i<=end ; i++) {
			sumInst.addNum(i);
		}
	}
}

public class Ex05Sync1Error {

	public static void main(String[] args) {

		/*
		하나의 객체를 두개의 쓰레드가 공유해서 사용하는 형태로 동작시킨다.
		 */
		SumMulti s = new SumMulti();
		MultiAdderThread mat1 = new MultiAdderThread(s, 1, 5000);
		MultiAdderThread mat2 = new MultiAdderThread(s, 5001, 10000);
		mat1.start();
		mat2.start();
		try {
			mat1.join();
			mat2.join();
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1~10000까지의합:"+s.getNum());
	}
}
