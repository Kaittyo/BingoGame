import java.util.ArrayList;
import java.util.Collections;

public class Randomizer {
    ArrayList<Integer> randomNum = new ArrayList<Integer>();
    int bingoNum;

    // コンストラクタ
    public Randomizer() {
        for (int i = 1; i <= 75; i++) {
            this.randomNum.add(i);
            Collections.shuffle(this.randomNum);
        }
    }

    // メソッド
    // 玉を出す
    public int ballThrow(int num) {
        this.bingoNum = this.randomNum.get(num);
        return this.bingoNum;
    }
}