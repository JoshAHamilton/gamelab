
public class Shower extends Item {
    public Shower() {
        super("shower");
    }

    public void use() {
    	if (Game.getCurrentRoom().hasItem("shower")) {
            if (Game.removeFromInventory("goo")) {
                System.out.println("You step into the shower and wash away the goo.");
                Game.getCurrentRoom().removeItem("goo");
            } else {
                System.out.println("You're not dirty, no need for a shower right now.");
            }
        } else {
            System.out.println("There is no shower in here.");
        }
    }
}