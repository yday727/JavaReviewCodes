package exercise.t2;

public class Score {
    public double score;

    public Score(double score) {
        try {
            this.score = checkScore(score);
        } catch (ScoreLessThanZeroException | ScoreMoreThanHundredException e) {
            System.err.println(e.getMessage());
        }
    }

    public double checkScore(double score) throws ScoreLessThanZeroException, ScoreMoreThanHundredException {
        if (score < 0) {
            throw new ScoreLessThanZeroException("成绩不能小于0。");
        } else if (score > 100) {
            throw new ScoreMoreThanHundredException("成绩不能大于100。");
        } else {
            return score;
        }
    }

    public static void main(String[] args) {
        try {
            Score score1 = new Score(-10);
        } finally {
            System.out.println("score1判断完成");
        }

        try {
            Score score2 = new Score(110);
        } finally {
            System.out.println("score2判断完成");
        }
    }
}
