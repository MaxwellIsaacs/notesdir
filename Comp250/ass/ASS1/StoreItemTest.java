public class StoreItemTest {
  
  public static StoreItem first = new StoreItem (1.0, 2);
  public static StoreItem second = new StoreItem (9.0, 2);

  public static void main (String[] args) {
    if (!first.equals(second)) {
      System.out.println("Works!");
    } else {
      System.out.println("You're retarded");
    }
  }
}
