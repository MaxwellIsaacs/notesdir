abstract public class Drink extends StoreItem {
  public static int MAX_PACK_SIZE;
  public static int BUZZY_HAPPINESS_BOOST = 11;

  protected int currentSize;
  private boolean isBuzzy;
  
  public Drink (double price, int happyIndex, int size, boolean isBuzzy) {
    super (price, happyIndex);
    this.currentSize = size;
    this.isBuzzy = isBuzzy; 
  }

  public int getSize () {
    return this.currentSize;
  }

  @Override
  public boolean equals (Object b) {
    if (b == null) return false;
    if (this == b) return true;
    Drink temp = (Drink) b;
    if (temp.getHappyIndex() == this.getHappyIndex() &&
        temp.getBuzzy() == this.getBuzzy() &&
        temp.getPrice() == this.getPrice() && 
        temp.getClass() == this.getClass()) {
      return true;
    }
    return false;
  }

  @Override 
  public int getHappyIndex () {
    return super.getHappyIndex() + BUZZY_HAPPINESS_BOOST;
  }

  public boolean getBuzzy () {
    return this.isBuzzy;
  }


  public boolean combine (Drink b) {
    if (this.getSize() >= MAX_PACK_SIZE || !this.equals(b)) {
      return false;
    }
    
    while (this.getSize() < MAX_PACK_SIZE) {
      if (b.getSize() == 0) {
        break;
      }
      this.currentSize++;
      b.currentSize--; 
    }
    return true;
  }
  
  public abstract Drink getPortion (int portionSize);
}


