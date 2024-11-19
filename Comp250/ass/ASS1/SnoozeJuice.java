public class SnoozeJuice extends Drink {
  private double temp;
  public static int HOT_COLD_BOOST;


  public SnoozeJuice (double price, int happyIndex, int bottleIndex, double temp) {
    super(price, happyIndex, bottleIndex, false);
    this.temp = temp;
  }

  public double getTemp () {
    return this.temp;
  }

  public static boolean isCold (MyDate x) { 
    return ((x.getMonth() > 2 && x.getMonth() < 9)  ? true : false );
  }

  @Override
  public boolean equals (Object b) {
    SnoozeJuice x =  (SnoozeJuice) b;
    return (super.equals(b) && x.getTemp() == this.getTemp());
  }

  @Override 
  public int getHappyIndex() {
    if (this.temp > 65 || this.temp < 4) {
        return 0;
    }
    if ((this.isCold(MyDate.today()) && (this.temp > 55 && this.temp < 65)) || 
        (!this.isCold(MyDate.today()) && (this.temp > 4 && this.temp < 10))) {    
        return super.getHappyIndex() + SnoozeJuice.HOT_COLD_BOOST;
    }
    return super.getHappyIndex(); 
}


  public SnoozeJuice getPortion (int size) {
    if (this.currentSize < size) return null; 
    SnoozeJuice x = new SnoozeJuice (super.getPrice(), this.getHappyIndex(), super.getSize(), this.temp);
    for (int i = 0; i < size; i++) {
      if (currentSize == 0) break;
      this.currentSize--;
      x.currentSize++;
    }
    return x;
  }
}
