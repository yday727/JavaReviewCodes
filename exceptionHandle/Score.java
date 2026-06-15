package exceptionHandle;

public class Score {
    private int score1;
    private int score2;

    // 对checkScore1抛出的错误进行处理，后续调用Score构造方法无需进行异常声明
    public Score(int score1, int score2){
        try {
            this.score1 = checkScore1(score1);
            this.score2 = checkScore2(score2);
        } catch (ScoreException1 e) {
            e.printStackTrace();
        }
    }

    // 所有可能抛出检查型错误Score Exception1的签名方法都要进行异常声明，添加throws ScoreException1，而非检查型ScoreException2不用
    public int checkScore1(int score) throws ScoreException1 {
        try {
            if (score < 0 || score > 100) {
                throw new ScoreException1("分数错误");  // 手动抛出异常
            }
        } finally{
            // 无论是否发生异常都会执行的代码
            System.out.println("score1检查完毕");
        }

        return score;
    }

    public int checkScore2(int score){
        try {
            if (score < 0 || score > 100) {
                throw new ScoreException2("分数错误");
            }
        } finally {
            // 无论是否发生异常都会执行的代码
            System.out.println("score2检查完毕");
        }

        return score;
    }
}
