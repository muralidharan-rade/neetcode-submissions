/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.isEmpty()) {
            return true;
        }

        intervals.sort(new IntervalConpare());
        
        boolean isMeetingPossible = true;

        int endTime = intervals.get(0).end;

        for(int i=1; i<intervals.size(); i++) {
            int s1 = intervals.get(i).start;
            if(s1 < endTime) {
                isMeetingPossible = false;
                break;
            } else {
                endTime = intervals.get(i).end;
            }
        }

        return isMeetingPossible;
    }
}

class IntervalConpare implements Comparator<Interval> {

    @Override
    public int compare(Interval o1, Interval o2) {
        if (o1.start < o2.start) {
            return -1;
        } else if (o1.start == o2.start) {
            return 0;
        } else {
            return 1;
        }
    }
}
