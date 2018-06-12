package lab;

public class Vertex {
	 
	final private String name;
	final private String latency;

	
	public Vertex(String name, String latency) {
		this.name = name; 
		this.latency = latency; 
		
	}
	
	public String getLatency() {
		return latency; 
	}
	
	public String getName() {
		return name; 
	}
}
