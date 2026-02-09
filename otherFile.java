//**************************************PUT IN SEPARATE FILE!!!***************************
public class MeetingInterval {
	private int startTime;
	private int endTime;
	
	public MeetingInterval(int myStart, int myEnd) {
		startTime = myStart;
		endTime = myEnd;
	}
	public int getStart() {
		return startTime;
	}
	public int getEnd() {
		return endTime;
	}
	public String toString() {
		return "["+startTime+"]["+endTime+"]";
	}
}
