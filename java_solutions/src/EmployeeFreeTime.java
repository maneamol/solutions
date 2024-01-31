import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//https://leetcode.com/problems/employee-free-time/
class Interval {
    int start;
    int end;
    boolean closed;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
        this.closed = true; // by default, the interval is closed
    }

    // set the flag for closed/open
    public void setClosed(boolean closed) {
        this.closed = closed;
    }
}

public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
        for (int i = 0; i< schedule.size(); i++) {
            List l = schedule.get(i);
            for (int j = 0 ; j < l.size(); j++ ) {
                pq.add((Interval) l.get(j));
            }
        }
        List<Interval> result = new ArrayList<>();
        if (pq != null) {
            result.add(pq.poll());
        }

        while (!pq.isEmpty()) {
            Interval i = pq.poll();
            if (result.get(result.size() - 1).end >= i.start) {
                result.get(result.size() - 1).start = Math.min(result.get(result.size() - 1).start, i.start);
                result.get(result.size() - 1).end = Math.max(result.get(result.size() - 1).end, i.end);
            } else {
                result.add(i);
            }
        }
        List<Interval> freeTime = new ArrayList<>();
        for (int i = 1; i < result.size(); i++) {
            freeTime.add(new Interval(result.get( i -1).end, result.get(i).start));
        }

        return freeTime;
    }

    public static void main(String[] args) {
        EmployeeFreeTime obj = new EmployeeFreeTime();
        /*
            [
                [[1,2],[5,6]],
                [[1,3]],[[4,10]]
            ]
         */

        obj.employeeFreeTime(
                Arrays.asList(
                        Arrays.asList(new Interval(1, 2), new Interval(5, 6)),
                        Arrays.asList(new Interval(1, 3), new Interval(4, 10))
                )
        );

/*        obj.employeeFreeTime(
                Arrays.asList(
                        Arrays.asList(new Interval(1, 2), new Interval(3, 4), new Interval(5, 6), new Interval(7, 8)),
                        Arrays.asList(new Interval(2, 3), new Interval(4, 5), new Interval(6, 8))
                )
        );*/
    }
}
