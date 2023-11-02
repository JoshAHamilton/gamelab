
public class Key extends Item {
	
	public Key() {
		super("chestKey");
	}
	
	public void use() {
		if(Game.getCurrentRoom().getName().equals("bedRoom")) {
			if(isUsed()) {
				System.out.println("The chest is already open.");
			} else {
				System.out.println("The key fits into the chest! You open the chest and " + "find a diamond inside!");
				Item diamond = new Item("diamond");
				diamond.setDesc("diamond");
				Game.getCurrentRoom().addItem(diamond);
				setUsed(true);
			} 
		} else {
			System.out.println("The key doesn't fit in this room.");
		}
	}
}
