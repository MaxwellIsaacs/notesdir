public class ItemListTest {
  
  public static ItemList first = new ItemList ();
  public static ItemList second = new ItemList ();


  public static StoreItem one = new StoreItem (2.0, 1);
  public static StoreItem two = new StoreItem (3.0, 3);


  public static void main(String[] args) {
    System.out.println("Hello");
    
    ItemListTest.first.addItem (ItemListTest.one);
    ItemListTest.first.addItem (ItemListTest.two);

    ItemListTest.second.addItem (ItemListTest.two);
    ItemListTest.second.addItem (ItemListTest.one);

    System.out.println("Size: " + ItemListTest.first.getSize());
    
    System.out.println("Size: " + ItemListTest.second.getSize());

    StoreItem[] temp = first.findEqualItems(one);
    System.out.println("temp length " + temp.length);


  


    /*
    if (first.equals(second)) {
      System.out.println("Works!");
    } else {
      System.out.println("You're retraded!");
    }
    */
    
  } 
}
