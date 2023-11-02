import java.util.HashMap;

public class Room {
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	private String desc; // desc = description
	private boolean locked; // Is the room locked?
	private String name;
	
	private HashMap<String, Item> roomItems;
	
	// Constructor Method
	public Room(String n, String d) {
		name = n;
		desc = d;
		locked = false;
		roomItems = new HashMap<String, Item>();
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isLocked() {
		return locked;
	}
	
	public void setLocked(boolean b) {
		locked = b;
	}
	
	public Item removeItem(String name) {
		Item it = roomItems.get(name);
		roomItems.remove(name);
		return it;
		
		// room roomItems.removeItem(name);
	}
	
	public void addItem(Item i) {
		roomItems.put(i.getName(), i);
	}
	
	public Item getItem(String itemName) {
		return roomItems.get(itemName);
	}
	
	public boolean hasItem(String name) {
		return roomItems.containsKey(name);
	}
	
	public Room getExit(char d) {
		if(d == 'e') {
			return east;
		} else if(d == 'w') {
			return west;
		} else if(d == 'n') {
			return north;
		} else if (d == 's') {
			return south;
		} else if (d == 'u') {
			return up;
		} else if (d == 'd') {
			return down;
		} else {
			return null;
		}
	}
	
	public void addExit(Room r, char d) {
		if(d == 'e') {
			east = r;
		} else if(d == 'w') {
			west = r;
		} else if(d == 'n') {
			north = r;
		} else if (d == 's') {
			south = r;
		} else if (d == 'u') {
			up = r;
		} else if (d == 'd') {
			down = r;
		}
	}
	
	public String toString() {
		return desc;
	}
	
}
