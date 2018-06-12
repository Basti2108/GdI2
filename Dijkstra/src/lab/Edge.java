package lab;

public class Edge {
	final private int id; 
	final private String source; 
	final private String destination; 
	final private int distance;
	final private int speed; 
	
	
	
	
	
	public Edge(int id, String source, String destination, int distance, int speed) {
		this.id = id; 
		this.source = source; 
		this.destination = destination; 
		this.distance = distance;
		this.speed = speed; 
	}
	
	
	
	public int getId() {
		return id; 
	}
	
	public String getSource() {
		return source; 
	}

	public String getDestination() {
		return destination; 
	}
	
	public int getDistance() {
		return distance; 
	}
	
	public int getSpeed() {
		return speed; 
	}
	
	public String toString() {
		return source + " -> " + destination + " [label=\""+ distance + ","+ speed + "\"];";
	}
}
