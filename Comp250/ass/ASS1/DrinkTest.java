public class DrinkTest {
  public static ItemList first = new ItemList (null);
  public static ItemList second = new ItemList (null);

  public static StoreItem one = new StoreItem (2.0, 1);
  public static StoreItem two = new StoreItem (3.0, 3);


//  public static Drink first = new Drink (1.0, 2, 3, false);
 // lpublic static Drink second = new Drink (1.0, 2, 5, false);

  public static void main(String[] args) {
    /*
    if (first.equals(second)) {
      System.out.println("Woks!");
    } else {
      System.out.println("wrong");
    }
    */
    System.out.println("He"); 
    ItemListTest.first.addItem (ItemListTest.one);
    ItemListTest.second.addItem (ItemListTest.two);

    System.out.println("Size: " + ItemListTest.first.getSize());
    
    System.out.println("Size: " + ItemListTest.second.getSize());

  }
}
