public class BingoGame {
    public static void main(String[] args) {
        int bingoNum;
        boolean victory = false;    // �����t���O

        // BingoGame�^�̔z����쐬
        System.out.println("�Q������l������͂��Ă��������B");
        int gameNumber = PConsole.inputIntNum();
        BingoCard[] bingoList = new BingoCard[gameNumber];

        // �Q���l�����̃r���S�J�[�h�𐶐�
        for (int i = 0; i < bingoList.length; i++) {
            System.out.println((i+1) + "�l�ڂ̖��O����͂��Ă��������B");
            String name = PConsole.inputString();
            bingoList[i] = new BingoCard(name);
            bingoList[i].displayCard();
        }

        // �ʏo���p�̗����𐶐�
        Randomizer r = new Randomizer();

        // �r���S�J�n
        for (int i = 0; i < r.randomNum.size(); i++) {
            bingoNum = r.ballThrow(i);      // i��ڂ̐�������
            System.out.println(i+1 + "��ڂ̐����́u" + bingoNum + "�v�I");
            for (int j = 0; j < bingoList.length; j++) {
                bingoList[j].hitNumber(bingoNum);
                bingoList[j].judgeBingo();
            }
            for (int j = 0; j < bingoList.length; j++) {
                if (bingoList[j].bingo > 0) {
                    System.out.println(bingoList[j].name + "����̏����ł��I");
                    victory = true;
                }
            }
            if (victory == true) {      // �r���S�����l���o���狭���I��
                break;
            }
            System.out.println();
        }
    }
}