
public class Chain extends Item {
	
    public Chain() {
        super("chain");
    }

    public void use() {
        if (Game.getCurrentRoom().getName().equals("hallway")) {
        	Game.print("You pull the chain as goo pours over you");
            Item goo = new Item("goo");
            goo.setDesc("You are covered in sticky goo.");
            Game.addToInventory(goo);
            Game.getCurrentRoom().setRoomID("hallway_a");
        } else {
        	Game.print("There doesn't seem to be a chain to pull here.");
        }
    }
}
