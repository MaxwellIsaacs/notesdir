public class Snack extends StoreItem {
  private String name;
  private MyDate expireDate;
  public Snack (double price, int happyIndex, String name, MyDate expireDate) {
    super(price, happyIndex);
    this.name = name;
    this.expireDate = expireDate;
  } 

  public String getName () {
    return this.name;
  }

  public boolean isExpired () {
    MyDate today = MyDate.today();
    if (today.getYear() > expireDate.getYear()) {
      return true;
    } else if (today.getYear() == expireDate.getYear()) {
      if (today.getMonth() > expireDate.getMonth()) {
        return true;
      } else if (today.getMonth() == expireDate.getMonth()) {
        if (today.getDay() > expireDate.getDay()) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public int getHappyIndex () {
    return this.isExpired() ? super.getHappyIndex() : super.getHappyIndex() / 2;
  }

  public String getString () {
    return this.name;
  }
 

  @Override
  public boolean equals (Object b) {
    Snack temp = (Snack) b;
    return ( super.equals (b) && this.name.equals(temp.getName()));
  }
} 
