package practice.t4;

public enum Weekday {
    Monday("周一"),
    Tuesday("周二"),
    Wednesday("周三"),
    Thursday("周四"),
    Friday("周五"),
    Saturday("周六"),
    Sunday("周日");

    private final String chineseName;

    Weekday(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getChineseName() {
        return chineseName;
    }

    public static boolean isWeekend(String weekday) {
        return Saturday.chineseName.equals(weekday) || Sunday.chineseName.equals(weekday);
    }

    public static void main(String[] args) {
        System.out.println(Weekday.isWeekend("周一"));
        System.out.println(Weekday.isWeekend("周日"));
    }
}
