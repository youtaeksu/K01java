package ex20io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
1byte씩 읽어서 복사하는 것보다 1kb(1024byte)씩 읽을수 있는 버퍼(buffer)를
이용하기 때문에 복사 속도가 훨씬 빨라진다.
스트림 혹은 네트워크를 통해 파일을 전송할때에도 버퍼를 사용하는 이유는
바로 이런 속도차 때문이다.
 */
public class E02ByteBufferFileCopy {

	public static void main(String[] args) {

		try {
			//원본파일과 복사본파일에 각각 입출력 스트림을 생성한다.
			InputStream in =
					new FileInputStream("src/ex20io/d2codingfont-master_copy.zip");
			OutputStream out =
					new FileOutputStream("src/ex20io/d2codingfont-master_copy2.zip");
			
			//복사된 크기, 한번에 읽어올 크기
			int copyByte = 0;
			int readLen ; 
			
			//1kbyte씩 파일의 내용을 읽어 저장하기 위한 버퍼 생성(byte형 배열)
			byte buffer[] = new byte[1024];
			
			while(true) {
				//배열의 크기 즉 1kbyte씩 파일을 읽어온다.
				readLen = in.read(buffer);
				if(readLen==-1) {
					break;
				}
				/*
				읽어온 내용을 파일에 입력한다. 버퍼에 저장된 데이터를 인덱스
				0의 위치에서 readLen의 크기만큼 전송한다.
				 */
				out.write(buffer, 0, readLen);
				copyByte += readLen;
			}
			
			if(in!=null) in.close();
			if(out!=null) out.close();
			
			System.out.println("복사된 파일크기:"+ copyByte +"byte");
			System.out.println("복사된 파일크기:"+ (copyByte/1024) +"Kbyte");
			System.out.println("복사된 파일크기:"+ (copyByte/(1024*1024)) +"Mbyte");
		}
		catch(FileNotFoundException e) {
			System.out.println("파일이없습니다.");
		}
		catch(IOException e) {
			System.out.println("IO작업중 예외가 발생되었습니다.");
		}
		catch(Exception e) {
			System.out.println("알수없는 예외가 발생되었습니다.");
		}
	}
}
