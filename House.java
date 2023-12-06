import java.util.ArrayList;

public class House extends Building{

  private ArrayList<String> residents; // List of all current residents
  private boolean hasDiningRoom; // Boolean saying if the house has a dining room
  private boolean hasElevator; //Boolean saying if the house has an elevator

  /** Full constructor */
  public House(String name, String address, int nFloors, boolean diningRoom, boolean hasElevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String> ();
    this.hasDiningRoom = diningRoom;
    this.hasElevator = hasElevator;
    System.out.println("You have built a house: 🏠");
  }

  /** Default constructor */
  public House() {
    super();
    this.residents = new ArrayList<String> ();
    this.hasDiningRoom = false;
    System.out.println("You have built a house: 🏠");
  }

  /** Shows available methods */
  public void showOptions() {
    super.showOptions();
    System.out.println( " + hasDiningRoom() \n + nResidents() \n + moveIn(r) \n + moveOut(r)\n + isResident(r)");
  }

  /** Accessor for if house has dining room */
  public boolean hasDiningRoom(){
    return this.hasDiningRoom;
  }

  /** Accessor for if house has elevator */
  public boolean hasElevator(){
    return this.hasElevator;
  }

  /** Accessor for number of residents */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Adds resident to list of current residents
   * @param name name of resident
   */
  public void moveIn(String name){
    if (!this.residents.contains(name)) {
      this.residents.add(name);
    }
    else{
      throw new RuntimeException("This person is already a resident of " + this.name);
    }
  }

  /**
   * Adds multiple residents to list of current residents
   * @param names list of names of residents moving in
   */
  public void moveIn(ArrayList<String> names){
    String name = "";
    for (int i=0; i<names.size(); i++){
      name = names.get(i);
      this.moveIn(name);
    }
  }
  
  /** 
   * Removes resident from list of current residents
   * @param name name of resident
   * @return name of resident who moved out
   */
  public String moveOut(String name){
    if (this.residents.contains(name)){
      this.residents.remove(name);
      return name;}
    else{
      throw new RuntimeException(name + " is not a resident of " + this.name);
    }
  }

  /** 
   * Removes multiple residents from list of current residents
   * @param names names of residents moving out
   * @return ArrayList of names of resident who moved out
   */
  public ArrayList<String> moveOut(ArrayList<String> names){
    String name = "";
    ArrayList<String> movedOut = new ArrayList<String>();
    for (int i=0; i<names.size() ; i++){
      name=names.get(i);
      // this.moveOut(name);
      movedOut.add(this.moveOut(name));
    }
    return movedOut;
  }

  /**
   * If a person is a resident of the house
   * @param person the person who may live in the house
   * @return if they live in the house
   */
  public boolean isResident(String person){
    return residents.contains(person);
  }

  /**
   * Goes to a floor
   * @param floorNum floor number to move to
   */
  public void goToFloor(int floorNum){
    if (Math.abs(this.activeFloor-floorNum) > 1 && !this.hasElevator){
      throw new RuntimeException("This house has no elevator. You can only move 1 floor at a time.");
    }
    else{
      super.goToFloor(floorNum);
    }
  }

  public static void main(String[] args) {
    new House();
  }
}