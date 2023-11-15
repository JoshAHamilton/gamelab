
public class Key extends Item {
	
	public Key() {
		super("chestKey");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("bedRoom")) {
			if(isUsed()) {
				Game.print("The chest is already open.");
			} else {
				Game.print("The key fits into the chest! You open the chest and " + "find a diamond inside!");
				Item diamond = new Item("diamond");
				diamond.setDesc("diamond");
				Game.getCurrentRoom().addItem(diamond);
				setUsed(true);
			} 
		} else {
			Game.print("The key doesn't fit in this room.");
		}
	}
}
