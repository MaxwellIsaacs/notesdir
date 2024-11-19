public class ItemList {
  private StoreItem[] mainDir;

  public ItemList (StoreItem[] mainDir) {
    this.mainDir = new StoreItem[mainDir.length];
    this.mainDir = mainDir;
  }

  public ItemList () {
    this.mainDir = new StoreItem[0]; 
  }

  public int getSize () {
    return mainDir.length;
  }

  public StoreItem[] getAllItems()  {
    return mainDir;
  }

  public void addItem (StoreItem x) {
    StoreItem[] temp = new StoreItem[this.getSize() + 1];
    for (int i = 0; i < this.getSize(); i++) {
      temp[i] = mainDir[i];
    }
    temp[temp.length-1] = x;
    this.mainDir = temp;
  }

  public void removeItem (StoreItem x) {
    StoreItem[] temp = new StoreItem[this.getSize() -1];
    int i = 0;
    for (; i < temp.length; i++) {
      if (mainDir[i].equals(x)){
        break;
      }
    }

    if (i != this.getSize()) {
      for (int y = 0; y < temp.length; y++) {
        if (y == i) continue;
        temp[y] = this.mainDir[y];
      }
      this.mainDir = temp;
    }
  }

  public StoreItem[] findEqualItems (StoreItem x) {
    int[] indecies = new int[this.getSize()];
    int length = 0;
    for (int i = 0; i < this.getSize(); i++) {
      if (this.mainDir[i].equals(x)) {
        indecies[length] = i;
        length++;
      }
    } 

    StoreItem[] temp = new StoreItem[length];
    for (int i = 0; i < length; i++) {
      temp[i] = this.mainDir[indecies[i]];
    }
    return temp;
  }
}
