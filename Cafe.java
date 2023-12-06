public class Cafe extends Building{

    private int nCoffeeOunces; // The number of ounces of coffee remaining in inventory
    private int nSugarPackets; // The number of sugar packets remaining in inventory
    private int nCreams; // The number of "splashes" of cream remaining in inventory
    private int nCups; // The number of cups remaining in inventory

    /** Full constructor */
    public Cafe(String name, String address, int nFloors) {
        super(name, address, nFloors);
        this.nCoffeeOunces = 128;
        this.nSugarPackets = 10;
        this.nCreams = 10;
        this.nCups = 10;
        System.out.println("You have built a cafe: ☕");
    }

    /** Default constructor */
    public Cafe() {
        super();
        this.nCoffeeOunces = 128;
        this.nSugarPackets = 10;
        this.nCreams = 10;
        this.nCups = 10;
        System.out.println("You have built a cafe: ☕");
      }

    /** Shows available methods */
    public void showOptions() {
        super.showOptions();
        System.out.println( " + sellCoffee(oz,sugar,cream) \n + restock(oz,sugar,cream,cups)");
    }

    /** 
     * Reduces amount of items in inventory 
     * @param size amount of coffee
     * @param nSugarPackets # of sugar packets
     * @param nCreams # of splashes of cream 
     * */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if ((this.nCoffeeOunces<size) || (this.nSugarPackets<nSugarPackets) 
            ||  (this.nCreams<nCreams) || (this.nCups<1)){
            this.restock(128, 10, 10, 10);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -=nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
    }

    /** Sells default 12oz black coffee */
    public void sellCoffee(){
        if(this.nCoffeeOunces<12){
            this.restock("coffee", 128);
        }
        this.nCoffeeOunces -= 12;
    }

    /**
     * Restocks inventory
     * @param nCoffeeOunces amount of coffee in oz
     * @param nSugarPackets # of sugar packets
     * @param nCreams # of splashes of cream
     * @param nCups # of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        this.nCoffeeOunces = nCoffeeOunces;
        this.nSugarPackets = nSugarPackets;
        this.nCreams = nCreams;
        this.nCups = nCups;
    }

    /** 
     * Restocks coffee 
     * @param nCoffeeOunces amount of coffee in oz
    */
    private void restock(String restockItem, int restockAmount){
        if (restockItem.equals("coffee")){
            this.nCoffeeOunces += restockAmount;}
        else if (restockItem.equals("sugar")){
            this.nSugarPackets += restockAmount;}
        else if (restockItem.equals("cream")){
            this.nCreams += restockAmount;}
        else if (restockItem.equals("cups")){
            this.nCups += restockAmount;}
        else{
            throw new RuntimeException("Can only restock 'coffee', 'sugar', 'cream', or 'cups'.");
        }
    }

    /**
     * Goes to a floor
     * @param floorNum floor number to move to
     */
    public void goToFloor(int floorNum) {
        if (floorNum!= 1){
            throw new RuntimeException("You only have access to the first floor.");
        }
        super.goToFloor(floorNum);
    }
    public static void main(String[] args) {
        new Cafe();
    }  
}
