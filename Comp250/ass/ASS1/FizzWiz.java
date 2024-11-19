public class FizzWiz extends Drink {
  public FizzWiz (double price, int happyIndex, int bottleIndex) {
    super (price, happyIndex, bottleIndex, true); 
  } 

  @Override
  public boolean equals (Object b) {
    FizzWiz temp = (FizzWiz) b;
    return (b.getClass() == this.getClass() && temp.getPrice() == this.getPrice() && temp.getHappyIndex() == this.getHappyIndex() && temp.getBuzzy() == this.getBuzzy()); 
  } 

  public FizzWiz getPortion (int portion) {
    if (portion > super.getSize()) return null;
    FizzWiz temp = new FizzWiz (super.getPrice(), this.getHappyIndex(), portion);
    for (int i = 0; i < portion; i++) {
      if (super.getSize() == 0) {
        break;
      }
      temp.currentSize++;
      this.currentSize--;
    }
    return temp;
  }
}
