package exercise.t1;

public class Score {
    public double score;

    public Score(double score) {
        this.score = score;
    }

    public String getRank() {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
}
