import java.time.LocalDate;
public class MyDate {
  private int day;
  private int month;
  private int year;

  public static int[] SUMMER_MONTHS = {3, 4, 5, 6, 7, 8};
  public static int[] WINTER_MONTHS = {9, 10, 11, 12, 1, 2};

  public MyDate (int day, int month, int year) {
    if (year >= 1 && year <= 9999 && month >= 1 && month <= 12 &&
        day >= 1 && day <= (new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}[month - 1])) {
        this.day = day;
        this.month = month;
        this.year = year;
    } else {
      throw new IllegalArgumentException("Invalid date");
    }
  }

  public final int getDay () {
    return this.day;
  }

  public final int getMonth () {
    return this.month;
  }

  public final int getYear () {
    return this.year;
  }

  @Override
  public boolean equals(Object obj) {
      if (this == obj) return true;
      if (obj == null || getClass() != obj.getClass()) return false;
      MyDate myDate = (MyDate) obj;
      return day == myDate.day &&
            month == myDate.month &&
            year == myDate.year;
  }

  public static MyDate today() {
    LocalDate currentDate = LocalDate.now();
    int day = currentDate.getDayOfMonth();
    int month = currentDate.getMonthValue();
    int year = currentDate.getYear();
    return new MyDate(day, month, year);
}


}
