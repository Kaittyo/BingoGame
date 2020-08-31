import java.util.ArrayList;
import java.util.Collections;

public class BingoCard {
    String name;
    int[] bingoNo = new int[25];
    String[] displayNo = new String[25];
    int num2;
    int bingoCount;
    int reach;
    int bingo;
    static String RED = "\u001b[00;31m";
    static String END = "\u001b[00m";

    // �������`�F�b�N�p�̃��X�g
    ArrayList<Integer> alreadyNo1 = new ArrayList<Integer>();   // 1���
    ArrayList<Integer> alreadyNo2 = new ArrayList<Integer>();   // 2���
    ArrayList<Integer> alreadyNo3 = new ArrayList<Integer>();   // 3���
    ArrayList<Integer> alreadyNo4 = new ArrayList<Integer>();   // 4���
    ArrayList<Integer> alreadyNo5 = new ArrayList<Integer>();   // 5���

    // �R���X�g���N�^
    public BingoCard(String name) {
        this.name = name;
        
        // �񂲂Ƃɔ��Ȃ��̐����𐶐�
        for (int i = 1; i <= 15; i++) {
            this.alreadyNo1.add(i);
            Collections.shuffle(alreadyNo1);
        }
        for (int i = 16; i <= 30; i++) {
            this.alreadyNo2.add(i);
            Collections.shuffle(alreadyNo2);
        }
        for (int i = 31; i <= 45; i++) {
            this.alreadyNo3.add(i);
            Collections.shuffle(alreadyNo3);
        }
        for (int i = 46; i <= 60; i++) {
            this.alreadyNo4.add(i);
            Collections.shuffle(alreadyNo4);
        }
        for (int i = 61; i <= 75; i++) {
            this.alreadyNo5.add(i);
            Collections.shuffle(alreadyNo5);
        }

        // �r���S�J�[�h�̗񂲂Ƃɐ����������Ă���
        for (int i = 0; i < bingoNo.length; i++) {
            switch (i / 5) {        // 5�Ŋ���Ɨ�Ԃ��v�Z�ł���
                case 0:
                    this.bingoNo[i] = this.alreadyNo1.get(i % 5);
                    break;
                case 1:
                    this.bingoNo[i] = this.alreadyNo2.get(i % 5);
                    break;
                case 2:
                    this.bingoNo[i] = this.alreadyNo3.get(i % 5);
                    break;
                case 3:
                    this.bingoNo[i] = this.alreadyNo4.get(i % 5);
                    break;
                case 4:
                    this.bingoNo[i] = this.alreadyNo5.get(i % 5);
                    break;
                default:
                    break;
            }
        }

        this.bingoNo[12] = 0;    // ���S�̓t���[�X�|�b�g�Ȃ̂�0�������Ă���
    }

    // ���\�b�h
    // �r���S�J�[�h��\������
    public void displayCard() {
        for (int i = 0; i < this.bingoNo.length; i++) {
            if (this.bingoNo[i] == 0) {
                this.displayNo[i] = String.format(RED + "%02d" + END, bingoNo[i]);
            } else {
                this.displayNo[i] = String.format("%02d", bingoNo[i]);
            }
        }

        System.out.println(this.name + "����̃r���S�J�[�h");
        System.out.println("--------------------------");
        for (int i = 0; i < 5; i++) {
            System.out.printf("| %s | %s | %s | %s | %s |", this.displayNo[0 + i], this.displayNo[5 + i], this.displayNo[10 + i], this.displayNo[15 + i], this.displayNo[20 + i]);
            System.out.println();
            System.out.println("--------------------------");
        }
    }

    // �q�b�g����
    public void hitNumber(int num) {
        this.num2 = (num - 1) / 15;  //�����������v�Z
        for (int i = 0; i < 5; i++) {
            if (this.bingoNo[5 * num2 + i] == num) {
                System.out.println(this.name + "����q�b�g�I");
                this.bingoNo[5 * num2 + i] = 0;
                this.displayCard();
                break;
            }
        }
    }

    // �r���S�E���[�`����
    public void judgeBingo() {
        // �J�E���^���Z�b�g
        this.bingoCount = 0;
        this.reach = 0;
        this.bingo = 0;

        // �c5��̔���
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.bingoNo[5 * i + j] == 0) {
                    this.bingoCount++;
                }
            }
            this.bingoCounter(this.bingoCount);
        }

        // ��5��̔���
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (this.bingoNo[5 * j + i] == 0) {
                    this.bingoCount++;
                }
            }
            this.bingoCounter(this.bingoCount);
        }

        // �΂߂̔���
        for (int i = 0; i < 5; i++) {
            if (this.bingoNo[6 * i] == 0) {
                this.bingoCount++;
            }
        }
        this.bingoCounter(this.bingoCount);

        for (int i = 1; i <= 5; i++) {
            if (this.bingoNo[4 * i] == 0) {
                this.bingoCount++;
            }
        }
        this.bingoCounter(this.bingoCount);

        // �r���S�E���[�`�錾
        if (this.bingo > 0) {
            System.out.println(this.name + "���񂪃r���S�I");
        } else if (this.reach > 0) {
            System.out.println(this.name + "����" + this.reach + "�ӏ����[�`�I");
        }
    }

    public void bingoCounter(int bingoCount) {
        switch (bingoCount) {
            case 5:
                this.bingo++;
                break;
            case 4:
                this.reach++;
                break;
            default:
                break;
        }
        this.bingoCount = 0;
    }
}