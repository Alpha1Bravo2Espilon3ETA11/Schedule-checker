//Diego Aldworth
//2/9/2026
//Description: This code project checks incase you have overlapping meeting or conflicts.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class CanAttend {

    //Precondition: meetings is a non-null ArrayList of MeetingInterval objects. Each MeetingInterval has a startTime <= endTime.
	//Postcondition: Returns true if no intervals overlap; returns false if any two intervals share a period of time.
    public static boolean canAttend(ArrayList<MeetingInterval> meetings) {
        if (meetings == null || meetings.size() <= 1) {
            return true;
        }

        // Sort the meetings by start time. 
        // This takes O(n log n) time, which is better than the O(n^2) requirement.
        Collections.sort(meetings, new Comparator<MeetingInterval>() {
            public int compare(MeetingInterval m1, MeetingInterval m2) {
                return Integer.compare(m1.getStart(), m2.getStart());
            }
        });

        // Iterate through the sorted list and check for overlaps
        for (int i = 0; i < meetings.size() - 1; i++) {
            MeetingInterval current = meetings.get(i);
            MeetingInterval next = meetings.get(i + 1);

            // If the next meeting starts before the current one ends, there is a conflict
            if (next.getStart() < current.getEnd()) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Test Case 1: Known Conflict
        ArrayList<MeetingInterval> conflictList = new ArrayList<>();
        conflictList.add(new MeetingInterval(100, 200));
        conflictList.add(new MeetingInterval(150, 250)); // Overlap here
        System.out.println("\nTest 1 (Overlap 100-200, 150-250): " + 
                           (!canAttend(conflictList) ? "PASS (Conflict found)" : "FAIL"));

        // Test Case 2: Back-to-Back (No Conflict)
        ArrayList<MeetingInterval> backToBack = new ArrayList<>();
        backToBack.add(new MeetingInterval(900, 1000));
        backToBack.add(new MeetingInterval(1000, 1100)); 
        System.out.println("Test 2 (Back-to-back 900-1000, 1000-1100): " + 
                           (canAttend(backToBack) ? "PASS (No conflict)" : "FAIL"));

        // Test Case 3: Single Meeting
        ArrayList<MeetingInterval> single = new ArrayList<>();
        single.add(new MeetingInterval(1200, 1300));
        System.out.println("Test 3 (Single meeting): " + 
                           (canAttend(single) ? "PASS" : "FAIL"));
    }
}
