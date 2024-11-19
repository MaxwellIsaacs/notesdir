public class StoreItem {
  private double price;
  private int happyIndex;

  public StoreItem (double price, int happyIndex) {
    if (price < 0 || happyIndex < 0) {
      throw new IllegalArgumentException("Negative input");
    }
    this.price = price;
    this.happyIndex = happyIndex;
  }

  public double getPrice () {
    return this.price;
  }

  public int getHappyIndex () {
    return this.happyIndex;
  }

  @Override
  public boolean equals(Object b) {
    if (b == this) {
      return true;
    }

    if (b == null || !(b.getClass() == this.getClass())) {
      return false;
    }

    StoreItem temp = (StoreItem) b;
    if (Math.abs(temp.getPrice() - this.getPrice()) < .001 && 
        Math.abs(temp.getHappyIndex() - this.getHappyIndex()) < .001) {
        return true;
    } 

    return false;
  }
}






