
public class Chain extends Item {
	
    public Chain() {
        super("chain");
    }

    public void use() {
        if (Game.getCurrentRoom().getName().equals("hallway")) {
            System.out.println("You pull the chain as goo pours over you");
            Item goo = new Item("goo");
            goo.setDesc("You are covered in sticky goo.");
            Game.getCurrentRoom().addItem(goo);
            Game.addToInventory(goo);
        } else {
            System.out.println("There doesn't seem to be a chain to pull here.");
        }
    }
}
