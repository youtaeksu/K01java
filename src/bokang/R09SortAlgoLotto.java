package bokang;

import java.util.Random;

class LottoCreater {

	Random random = new Random();
	int[] lottoNum;
	public LottoCreater() {
		this.lottoNum = new int[6];
	}
	// 난수생성1 : 6개의 난수를 먼저 생성한 후 중복확인
	public void randomCreate1() {
		while (true) {
			for (int i = 0; i < lottoNum.length; i++) {
				lottoNum[i] = random.nextInt(45) + 1;
			}
			boolean reTry = true;
			for (int i = 0; i < lottoNum.length; i++) {
				for (int j = 0; j < lottoNum.length; j++) {
					if (i != j && lottoNum[i] == lottoNum[j]) {
						// 중복되는 난수를 발견하면 false로변경
						reTry = false;
					}
				}
			}
			if (reTry == true) break;
		}
	}
	// 난수생성1 : 6개의 난수를 먼저 생성한 후 중복확인
	public void randomCreate2() {
		int index = 0;
		boolean reTry = true;
		while (index < lottoNum.length) {
			// 1~45사이의 난수 생성
			int randomNumber = random.nextInt(45) + 1;
			// 배열에 저장된 요소와 난수를 비교하여 중복이 확인되면 flag를 변경한다.
			for (int i = 0; i < lottoNum.length; i++) {
				if (randomNumber == lottoNum[i]) {
					// 배열내에 난수와 동일한 값이 있다면 true로 변경
					reTry = false;
				}
			}
			if (reTry == false) {
				/*
				중복된 값이 확인되면 처음으로 돌아가서 난수를 다시 생성한다.
				이때 flag를 false로 초기화 해야 한다.
				 */
				reTry = true;
				continue;
			}
			else {
				/*
				중복된 값이 없다면 배열을 처음부터 채워준다. 채운후에는 index를
				1 증가 시킨다.
				 */
				lottoNum[index++] = randomNumber;
			}
		}
	}
	public void showArray() {
		for (int i = 0; i < lottoNum.length; i++) {
			System.out.print(lottoNum[i] + " ");
		}
	}
	// 버블정렬 : 인접한 숫자2개를 비교해서 큰 숫자를 뒤로 이동시킨다.
	public void bubbleSort() {
		int temp;
		for (int i = 0; i < lottoNum.length - 1; i++) {
			for (int j = 0; j < (lottoNum.length - 1) - i; j++) {
				if (lottoNum[j] > lottoNum[j + 1]) {
					temp = lottoNum[j];
					lottoNum[j] = lottoNum[j + 1];
					lottoNum[j + 1] = temp;
				}
			}
		}
	}
	//선택정렬 : 스캔해서 가장 작은 숫자를 찾아 첫번째 숫자와 교환한다. 그것을 반복한다.
	public void SelectionSort() {
		int num, num_index, temp;
		// 0~8까지반복함..배열보다 1작은만큼 반복.
		for (int seq = 0; seq < lottoNum.length - 1; seq++) {
			num = lottoNum[seq];
			num_index = seq;
			for (int i = seq + 1; i < lottoNum.length; i++) {
				// 기준(num)보다 작은 값이 발견되면 즉시 교체하고 다음 원소랑 비교를 반복
				if (num > lottoNum[i]) {
					num = lottoNum[i];
					num_index = i;// 최소값이 있는 인덱스번호
				}
			}
			// swap
			if (lottoNum[seq] > lottoNum[num_index]) {
				temp = lottoNum[seq];// 현재 Loop의 배열요소
				lottoNum[seq] = lottoNum[num_index];
				lottoNum[num_index] = temp;
			}
		}
	}
	public void capsuleLotto() {
		// randomCreate1();
		randomCreate2();
		
		// bubbleSort();
		SelectionSort();
		
		showArray();
	}
}
public class R09SortAlgoLotto {
	public static void main(String[] args) {
		new LottoCreater().capsuleLotto();
	}
}