package ex19thread;

//2개의 쓰레드가 공유객체로 사용할 클래스
class SumMulti2 {
	int num;
	public SumMulti2() {
		num=0;
	}
	/*
	쓰레드의 동기화
	: synchronized 선언으로 인해 정확한 결과가 나오긴 하지만 코드 실행기간이
	기존에 비해 길어지게 되는 단점이 있다.
	즉 동기화 작업은 성능의 감소를 초래하므로 필요한 부분에 대해서만 동기화
	처리를 해주는것이 좋다..
	메서드 전체를 동기화 하는 방법과 필요한 코드만 동기화하는 2가지 방법이 있다.
	 */
	
	//동기화방법1 : 동기화 메서드 
//	synchronized public void addNum(int n) {
//		num += n;
//	}
	
	//동기화방법2 : 동기화 블럭(필요한 코드만 동기화한다.) => 조금 더 좋은 성능을 보임
	public void addNum(int n) {
		synchronized(this) {
			num += n;
		}
	}
	
	
	//멤버변수 반환
	public int getNum() {
		return num;
	}
}
class MultiAdderThread2 extends Thread {
	//앞에서 정의한 공유객체를 멤버변수로 선언
	SumMulti2 sumInst;
	int start, end;
	//생성자에서는 메멉변수 초기화
	public MultiAdderThread2(SumMulti2 sum, int s, int e) {
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

public class Ex05Sync2Method {

	public static void main(String[] args) {

		/*
		하나의 객체를 두개의 쓰레드가 공유해서 사용하는 형태로 동작시킨다.
		 */
		SumMulti2 s = new SumMulti2();
		MultiAdderThread2 mat1 = new MultiAdderThread2(s, 1, 5000);
		MultiAdderThread2 mat2 = new MultiAdderThread2(s, 5001, 10000);
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
