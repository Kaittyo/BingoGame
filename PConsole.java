import java.io.*;

class PConsole {
	/**
	 *   整数入力
	 */
	static int inputIntNum() {
		InputStreamReader isr;        // 入力のための仕組装置
		BufferedReader reader;        // 入力のための仕組装置
		
		String str;                   // 入力された文字列を格納する
		int num = 0;                  // 変換された整数
		String prompt = "整数入力>";  // 入力用のプロンプト

		// 入力のための仕組み装置を用意する
		isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);

		// 入力ループ
		while(true) {
			try {
				System.out.print(prompt);
				str = reader.readLine();
				num = Integer.parseInt(str);
			} catch (IOException e) {
				; // 教材用なので例外送出はしない。
			} catch (NumberFormatException e) {
				System.out.println("整数ではありません.入力し直してください.");
				continue;
			}
			break;
		}

		return num;
	}
	
	/**
	 *    文字列入力
	 */
	static String inputString() {
		InputStreamReader isr;        // 入力のための仕組装置
		BufferedReader reader;        // 入力のための仕組装置
		
		String str;                   // 入力された文字列を格納する
		String prompt = "文字列入力>";  // 入力用のプロンプト

		// 入力のための仕組み装置を用意する
		isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);

		// 入力
		str = "";
		try {
			System.out.print(prompt);
			str = reader.readLine();
		} catch (IOException e) {
			; // 教材用なので例外送出はしない。
		}

		return str;
	}
}
