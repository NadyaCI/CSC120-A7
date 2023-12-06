import java.util.ArrayList;
import java.util.Scanner;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Burton Hall", "46 College Lane Northampton, MA 01063", 3));
        myMap.addBuilding(new Building("Sage Hall", "144 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Library("Josten Library", "122 Green Street Northampton, MA 01063", 2));
        myMap.addBuilding(new Library("Neilson Library", "7 Neilson Drive Northampton, MA 01063", 4));
        myMap.addBuilding(new House("Park House", "134 Elm Street Northampton, MA 01063", 4, true, false));
        myMap.addBuilding(new House("Baldwin House", "15 Bedford Terrace Northampton, MA 01063", 5, true, false));
        myMap.addBuilding(new House("Ziskind House", "1 Henshaw Avenue Northampton, MA 01063", 4, true, true));
        myMap.addBuilding(new Cafe("Compass Cafe", "7 Neilson Drive Northampton, MA 01063", 1));
        myMap.addBuilding(new Cafe("Julia Child Campus Center Cafe", "100 Elm Street Northampton, MA 01063", 1));
        System.out.println(myMap);

        Boolean exploring = true;
        String action;
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Smith College! What would you like to do?");
        Building outside = new Building();
        Building currentBuilding = outside;
        Boolean moved = false;

        while (exploring){
            action = input.nextLine().toLowerCase();
            if (action.contains("leave") && action.contains("smith")){
                exploring = false;
                System.out.println("Thank you for exploring Smith College. Come again soon!");
            }
            else if (action.contains("enter")){
                for (int i = 0; i < myMap.buildings.size(); i ++){
                    if (action.contains(myMap.buildings.get(i).getName().toLowerCase())){
                        currentBuilding=myMap.buildings.get(i);
                        currentBuilding.enter();
                    }
                }
                if (currentBuilding.getName().equals("<Name Unknown>")){
                    throw new RuntimeException("You can only enter buildings on the provided map.");
                }
            }
            else if (action.contains("exit")){
                currentBuilding.exit();
                currentBuilding = outside;
            }
            else if (action.contains("go to") && action.contains("floor")){
                for (int i=1; i <= currentBuilding.getFloors(); i++){
                    if (action.contains(Integer.toString(i))){
                        currentBuilding.goToFloor(i);
                        moved = true;
                    }
                }
                if (moved == false){
                    throw new RuntimeException("Enter a valid floor number");
                }
                moved = false;
            }
            else if (currentBuilding instanceof House){
                System.out.println("Yep, it's a house");
            }
        }
    }
}
