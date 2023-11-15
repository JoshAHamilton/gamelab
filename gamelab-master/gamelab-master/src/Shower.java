
public class Shower extends Item {
    public Shower() {
        super("shower");
    }

    public void use() {
    	if (Game.getCurrentRoom().hasItem("shower")) {
            if (Game.removeFromInventory("goo")) {
            	Game.print("You step into the shower and wash away the goo.");
                Game.getCurrentRoom().removeItem("goo");
            } else {
            	Game.print("You're not dirty, no need for a shower right now.");
            }
        } else {
        	Game.print("There is no shower in here.");
        }
    }
}