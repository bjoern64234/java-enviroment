package enums;

public enum DaysOfWeek {
    MONDAY(false), TUESDAY(false), WEDNESDAY(false), THURSDAY(false), FRIDAY(false), SATURDAY(true), SUNDAY(true);

    private final boolean isWeekend;

    DaysOfWeek(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public String getWeekday(DaysOfWeek today) {

        if (today.isWeekend) {
            return "WEEKEND";
        }

        return today.name();
    }
}
