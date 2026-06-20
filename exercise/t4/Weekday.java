package exercise.t4;

public enum Weekday {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday;

    public boolean isWeekend() {
        return this == Saturday || this == Sunday;
    }

    public static void main(String[] args) {
        System.out.println(Weekday.Monday.isWeekend());
    }
}
