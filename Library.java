import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Library extends Building{

  private Hashtable<String, Boolean> collection; // Hashtable of books and their checkout status'

  /** Full constructor */
  public Library(String name, String address, int nFloors) {
    super(name, address, nFloors);
    this.collection = new Hashtable<String, Boolean>(); 
    System.out.println("You have built a library: 📖");
  }

  /** Default constructor */
  public Library() {
    super();
    this.collection = new Hashtable<String, Boolean>(); 
    System.out.println("You have built a library: 📖");
  }

  /** Shows available methods */
  public void showOptions() {
        super.showOptions();
        System.out.println( " + addTitle(t) \n + removeTitle(t) \n + checkOut(t) \n + returnBook(t)\n + containsTitle(t) \n + isAvailable(t) \n + printCollection()");
    }

  /** 
   * Adds a book to collection
   * @param title book to be added
   */
  public void addTitle(String title){
    if (this.containsTitle(title)){
      throw new RuntimeException(title + " is already in the library.");
    }
    else{
      this.collection.put(title, true);
    }
  }

  /**
   * Removes a book from collection
   * @param title book to be removed
   * @return title of removed book
   */
  public String removeTitle(String title){
    if (this.containsTitle(title)){
      this.collection.remove(title);
      return title;
    }
    else{
      throw new RuntimeException(title + " is not in the library.");
    }
  }

  /** 
   * Checks out a book
   * @param title book to be checked out
   */
  public void checkOut(String title){
    if (!this.containsTitle(title)){
      throw new RuntimeException("This library does not have " + title);
    }
    else if (!this.isAvailable(title)){
      throw new RuntimeException(title + " has already been checked out.");
    }
    else{
      this.collection.replace(title, false);
    }
  }

  /**
   * Checks out multiple books
   * @param titles list of books to check out
   */
  public void checkOut(ArrayList<String> titles){
    String title = "";
    for (int i=0; i<titles.size(); i++){
      title = titles.get(i);
      this.checkOut(title);
    }
  }

  /** 
   * Returns a book
   * @param title book to be returned
   */
  public void returnBook(String title){
    if (!this.containsTitle(title)){
      throw new RuntimeException("This library does not have " + title);
    }
    else if (this.isAvailable(title)){
      throw new RuntimeException(title + " has not been checked out.");
    }
    else{
      this.collection.replace(title, true);
    }
  }

  /**
   * Returns multiple books
   * @param titles list of books to return
   */
  public void returnBook(ArrayList<String> titles){
    String title = "";
    for (int i=0; i<titles.size(); i++){
      title = titles.get(i);
      this.returnBook(title);
    }
  }

  /**
   * If a book is in the collection
   * @param title book being inquired about
   * @return if in collection or not
   */
  public boolean containsTitle(String title){
    return this.collection.containsKey(title);
  }

  /**
   * If a book has been checked out
   * @param title book being inquired about
   * @return if already checked out or not
   */
  public boolean isAvailable(String title){
    return this.collection.get(title);
  }

  /** Prints the collection in a readable fashion */
  public void printCollection(){
    System.out.println("The current collection: ");
    if (this.collection.size() == 0){
      System.out.println("There are currently no books in the collection.");
    }
    else{
      String inCollection = " is ";
      String element = "";
      for (Enumeration<String> e = this.collection.keys(); e.hasMoreElements();){
        element = e.nextElement();
        if (!this.collection.get(element)){
          inCollection = " is not ";
        }
        System.out.println(element + inCollection + "currently checked out.");
      }
    }
  }

  public static void main(String[] args) {
    Library l = new Library("Josten", "1 Green St", 4);
    l.enter();
    l.goToFloor(3);
  }
}