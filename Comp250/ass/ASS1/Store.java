public class Store {
  private ItemList mainDir;
  private double totalRevenue;

  public Store (ItemList x) {
     this.mainDir = x;
  }

  public double getRevenue () {
    return this.totalRevenue;
  }

  public ItemList getItems () {
    return mainDir;
  }

  public void cleanUp () {
    StoreItem[] x = mainDir.getAllItems();
    for (int i = 0; i < x.length; i++) { 
      if (x[i] instanceof Snack){
        Snack temporary = (Snack) x[i];
        if (temporary.isExpired()) {
          mainDir.removeItem (temporary);
       }
     }
    }
  }

  public int completeSale(ItemList itemsSold) {
    StoreItem[] soldItems = itemsSold.getAllItems();
    int totalHappiness = 0;
    double totalSaleValue = 0;

    for (StoreItem item : soldItems) {
        StoreItem[] storeItems = mainDir.findEqualItems(item);
        if (storeItems.length == 0) continue;

        if (item instanceof Drink) {
            Drink drinkToSell = (Drink) item;
            for (StoreItem storeItem : storeItems) {
                Drink storeDrink = (Drink) storeItem;
                int bottlesToSell = Math.min(storeDrink.getSize(), drinkToSell.getSize());
                if (bottlesToSell > 0) {
                    Drink portionToSell = storeDrink.getPortion(bottlesToSell);
                    totalHappiness += portionToSell.getHappyIndex() * bottlesToSell;
                    totalSaleValue += portionToSell.getPrice() * bottlesToSell;
                    storeDrink.combine(drinkToSell);
                }
            }
        } else {
            totalHappiness += item.getHappyIndex();
            totalSaleValue += item.getPrice();
            mainDir.removeItem(item);
        }
    }

    this.totalRevenue += totalSaleValue;
    return totalHappiness;
  }

  public void refillDrinkInventory(Drink[] drinks) {
      for (Drink drink : drinks) {
          StoreItem[] storeItems = mainDir.findEqualItems(drink);
          boolean drinkCombined = false;
          for (StoreItem storeItem : storeItems) {
              if (storeItem instanceof Drink && ((Drink) storeItem).combine(drink)) {
                  drinkCombined = true;
                  break;
              }
          }
          if (!drinkCombined) mainDir.addItem(drink);
      }
  }
}
