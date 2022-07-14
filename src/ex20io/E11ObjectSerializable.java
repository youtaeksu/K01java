package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
직렬화
	: Circle클래슬르 입출력의 대상으로 파일로 저장하기 위해
	Serializable 인터페이스를 구현하여 정의한다. 인스턴스가 파일의
	형태로 저장되는것을 '직렬화'라고 한다. 만약 상속이 되는 경우라면
	부모쪽만 implements 하면 된다.
 */
class Circle implements Serializable
{
	//원의 중심점인 좌표를 x, y로 표현
	int xPos, yPos;
	//반지름
	double radian;
	//생성자에서 멤버변수 초기화
	public Circle(int x, int y, double r) {
		xPos = x;
		yPos = y;
		radian = r;
	}
	//멤버변수 정보 출력
	public void showCircleInfo() {
		System.out.printf("좌표[%d,%d]", xPos, yPos);
		System.out.println("반지름:"+ radian);
	}
}
public class E11ObjectSerializable {

	public static void main(String[] args) {

		try {
			//인스턴스를 파일에 저장하기 위해 출력스트림을 생성한다.
			ObjectOutputStream out = 
					new ObjectOutputStream(
						new FileOutputStream("src/ex20io/circle.obj"));
					
			//Circle인스턴스를 생성한 후 파일에 저장한다.
			out.writeObject(new Circle(1,1,2.4));
			out.writeObject(new Circle(2,2,4.8));
			//Java에서 제공하는 기본클래스는 별도의 처리없이 직렬화가 가능하다.
			out.writeObject(new String("String타입의 오브젝트"));
			out.close();
			
			/*
			인스턴스의 복원(역직렬화)를 위한 스트림을 생성하고 readObject()를 
			통해 복원한다.
			 */
			ObjectInputStream in =
					new ObjectInputStream(
						new FileInputStream("src/ex20io/circle.obj"));
			/*
			저장시 Object기반으로 저장되므로 복원할때는 원래의 자료형으로
			형변환 해야 한다.
			 */
			Circle c1 = (Circle)in.readObject();
			Circle c2 = (Circle)in.readObject();
			String message = (String)in.readObject();
			in.close();
			
			//개발자가 직접 정의한 클래스는 별도의 멤버메서드를 통해 정보를 출력한다.
			c1.showCircleInfo();
			c2.showCircleInfo();
			//기본클래스는 즉시 print() 하면된다.
			System.out.println("String오브젝트:"+ message);
		}
		catch(ClassNotFoundException e) {
			System.out.println("클래스없음");
		}
		catch(FileNotFoundException e) {
			System.out.println("파일없음");
		}
		catch(IOException e) {
			System.out.println("뭔가없음");
		}
	}
}
