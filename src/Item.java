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
	
	public void look() {
		System.out.println(desc);
	}
	
	public void use() {
		if(name.equals("key")) {	// key to bedRoom
			if(Game.getCurrentRoom().getName().equals("hallway")) {
				System.out.println("You use the key on the bedroom door and it unlocks");
				Room bedRoom = Game.getCurrentRoom().getExit('w');
				bedRoom.setLocked(false);
			} else {
				System.out.println("There's no where to use this right now");
			}
		} else if(name.equals("newspaper")){	// newspaper
			System.out.println("You read the newspaper");
		} else if(name.equals("broom")) {		// broom
			System.out.println("You really just want to sweep the room?\n" + "I guess you sweep the floor clean\n" + "\u001B[32m[Achievement get: Clean Sweep]\u001B[0m");
		} else {								// No use for item
			System.out.println("You can't use this item...yet.");
		}
	}
}
