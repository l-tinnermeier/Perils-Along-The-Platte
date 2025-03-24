package main;

public class WeatherEvent {
	private String eventName; 
	private String eventDescription;
	private long frequencyMin;
	private long frequencyMax;
	
	public WeatherEvent(String name, String desc, long fMin, long fMax) {
		eventName = name;
		eventDescription = desc;
		frequencyMin = fMin;
		frequencyMax = fMax;
	}
	
	public String getDesc() {
		return eventDescription;
	}
	
	public String getName() {
		return eventName;
	}
	
	public long getFreqMin() {
		return frequencyMin;
	}
	
	public long getFreqMax() {
		return frequencyMax;
	}
	
	// test
}
