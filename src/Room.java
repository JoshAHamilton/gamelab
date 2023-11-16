import java.io.Serializable;
import java.util.HashMap;

public class Room implements Serializable{
	
	private Room east;
	private Room west;
	private Room north;
	private Room south;
	private Room up;
	private Room down;
	// private String desc; // desc = description
	private boolean locked; // Is the room locked?
	private String name;
	private String roomID;
	
	private HashMap<String, Item> roomItems;
	private HashMap<String, NPC> roomNPCs;
	
	// Constructor Method
	public Room(String n, String d) {
		name = n;
		roomID = n;
		// desc = d;
		locked = false;
		roomItems = new HashMap<String, Item>();
		roomNPCs = new HashMap<String, NPC>();
		World.rooms.put(name, this); // Room object places itself in the map
	}
	
	public boolean hasNPC(String name) {
		return roomNPCs.containsKey(name);
	}
	
	public void addNPC(NPC npc) {
		roomNPCs.put(npc.getName(), npc);
	}
	
	public NPC removeNPC(String name) {
		NPC it = roomNPCs.get(name);
		roomNPCs.remove(name);
		return it;
	}
	
	public NPC getNPC(String name) {
		return roomNPCs.get(name);
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
	
	public void setRoomID(String id) {
		roomID = id;
	}
	
	public String getDesc(String key) {
		return Game.roomDescs.get(key);
		// return Game.roomDescs.get(roomID);
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
	
	public String toString(String key) {
		return Game.roomDescs.get(key);
		// return desc;
	}
	
}
