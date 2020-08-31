import java.io.*;

class PConsole {
	/**
	 *   ��������
	 */
	static int inputIntNum() {
		InputStreamReader isr;        // ���͂̂��߂̎d�g���u
		BufferedReader reader;        // ���͂̂��߂̎d�g���u
		
		String str;                   // ���͂��ꂽ��������i�[����
		int num = 0;                  // �ϊ����ꂽ����
		String prompt = "��������>";  // ���͗p�̃v�����v�g

		// ���͂̂��߂̎d�g�ݑ��u��p�ӂ���
		isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);

		// ���̓��[�v
		while(true) {
			try {
				System.out.print(prompt);
				str = reader.readLine();
				num = Integer.parseInt(str);
			} catch (IOException e) {
				; // ���ޗp�Ȃ̂ŗ�O���o�͂��Ȃ��B
			} catch (NumberFormatException e) {
				System.out.println("�����ł͂���܂���.���͂������Ă�������.");
				continue;
			}
			break;
		}

		return num;
	}
	
	/**
	 *    ���������
	 */
	static String inputString() {
		InputStreamReader isr;        // ���͂̂��߂̎d�g���u
		BufferedReader reader;        // ���͂̂��߂̎d�g���u
		
		String str;                   // ���͂��ꂽ��������i�[����
		String prompt = "���������>";  // ���͗p�̃v�����v�g

		// ���͂̂��߂̎d�g�ݑ��u��p�ӂ���
		isr = new InputStreamReader(System.in);
		reader = new BufferedReader(isr);

		// ����
		str = "";
		try {
			System.out.print(prompt);
			str = reader.readLine();
		} catch (IOException e) {
			; // ���ޗp�Ȃ̂ŗ�O���o�͂��Ȃ��B
		}

		return str;
	}
}
