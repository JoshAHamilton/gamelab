import java.io.Serializable;

public class Item implements Serializable{
	private String name;
	private String desc;
	private boolean heavy;
	private boolean used;
	
	public Item(String n) {
		name = n;
		heavy = false;
		used = false;
	}
	
	public void setHeavy(boolean b) {
		heavy = b;
	}
	
	public boolean isHeavy() {
		return heavy;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isUsed() {
		return used;
	}
	
	public void setUsed(boolean b) {
		used = b;
	}
	
	public String toString() {
		return name;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public void take() {
		if(heavy) {
			Game.print("That's too heavy to carry around!");
		} else {
			Game.inventory.add(Game.getCurrentRoom().removeItem(name));
			Game.print("You pick up the " + name + ".");
		}
	}
	
	public void look() {
		Game.print(desc);
	}
	
	public void use() {
		if(name.equals("key")) {	// key to bedRoom
			if(Game.getCurrentRoom().getName().equals("hallway")) {
				Game.print("You use the key on the bedroom door and it unlocks");
				Room bedRoom = Game.getCurrentRoom().getExit('w');
				bedRoom.setLocked(false);
			} else {
				Game.print("There's no where to use this right now");
			}
		} else if(name.equals("newspaper")){	// newspaper
			Game.print("You read the newspaper");
		} else if(name.equals("broom")) {		// broom
			Game.print("You really just want to sweep the room?\n" + "I guess you sweep the floor clean\n" + "\u001B[32m[Achievement get: Clean Sweep]\u001B[0m");
		} else {								// No use for item
			Game.print("You can't use this item...yet.");
		}
	}
}
