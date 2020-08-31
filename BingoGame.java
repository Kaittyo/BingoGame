public class BingoGame {
    public static void main(String[] args) {
        int bingoNum;
        boolean victory = false;    // 勝利フラグ

        // BingoGame型の配列を作成
        System.out.println("参加する人数を入力してください。");
        int gameNumber = PConsole.inputIntNum();
        BingoCard[] bingoList = new BingoCard[gameNumber];

        // 参加人数分のビンゴカードを生成
        for (int i = 0; i < bingoList.length; i++) {
            System.out.println((i+1) + "人目の名前を入力してください。");
            String name = PConsole.inputString();
            bingoList[i] = new BingoCard(name);
            bingoList[i].displayCard();
        }

        // 玉出し用の乱数を生成
        Randomizer r = new Randomizer();

        // ビンゴ開始
        for (int i = 0; i < r.randomNum.size(); i++) {
            bingoNum = r.ballThrow(i);      // i回目の数字を代入
            System.out.println(i+1 + "回目の数字は「" + bingoNum + "」！");
            for (int j = 0; j < bingoList.length; j++) {
                bingoList[j].hitNumber(bingoNum);
                bingoList[j].judgeBingo();
            }
            for (int j = 0; j < bingoList.length; j++) {
                if (bingoList[j].bingo > 0) {
                    System.out.println(bingoList[j].name + "さんの勝利です！");
                    victory = true;
                }
            }
            if (victory == true) {      // ビンゴした人が出たら強制終了
                break;
            }
            System.out.println();
        }
    }
}