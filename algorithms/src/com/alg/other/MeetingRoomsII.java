package com.alg.other;

import java.util.*;

public class MeetingRoomsII {
    /**
     * manually iterating on every room that's been allocated and checking if the room is available or not.
     * @param intervals
     * @return
     */
    public int minMeetingRoomsBrute(int[][] intervals) {
        Map<Integer, Integer> timeSlots = new HashMap<>();
        for(int i = 0; i < intervals.length; i++) {
            for(int j = intervals[i][0]; j < intervals[i][1]; j++) {
                int timePoint = j;
                int cumulatedMeetings = timeSlots.getOrDefault(timePoint, 0);
                timeSlots.put(timePoint, ++cumulatedMeetings);
            }
        }

        int maxNumberOfRooms = (timeSlots.values()).stream()
                .mapToInt(i->i).max().getAsInt();
        return maxNumberOfRooms;
    }

    /**
     * Answer from Leetcode:
     * Algorithm
     *
     * 1.Sort the given meetings by their start time.
     * 2.Initialize a new min-heap and add the first meeting's ending time to the heap. We simply need to keep track of
     * the ending times as that tells us when a meeting room will get free.
     * 3.For every meeting room check if the minimum element of the heap i.e. the room at the top of the heap is free or
     * not.
     * 4.If the room is free, then we extract the topmost element and add it back with the ending time of the current
     * meeting we are processing.
     * 5.If not, then we allocate a new room and add it to the heap.
     * 6.After processing all the meetings, the size of the heap will tell us the number of rooms allocated. This will
     * be the minimum number of rooms needed to accommodate all the meetings.
     * @param intervals
     * @return
     */
    public int minMeetingRooms(int[][] intervals) {
        // Check for the base case. If there are no intervals, return 0
        if (intervals.length == 0) {
            return 0;
        }

        // Min heap
        PriorityQueue<Integer> allocator =
                new PriorityQueue<Integer>(
                        intervals.length,
                        new Comparator<Integer>() {
                            public int compare(Integer a, Integer b) {
                                return a - b;
                            }
                        });

        // Sort the intervals by start time
        Arrays.sort(
                intervals,
                new Comparator<int[]>() {
                    public int compare(final int[] a, final int[] b) {
                        return a[0] - b[0];
                    }
                });

        // Add the first meeting
        allocator.add(intervals[0][1]);

        // Iterate over remaining intervals
        for (int i = 1; i < intervals.length; i++) {

            // If the room due to free up the earliest is free, assign that room to this meeting.
            if (intervals[i][0] >= allocator.peek()) {
                int end = allocator.poll();
                System.out.println("Polled: " + end);
            }

            // If a new room is to be assigned, then also we add to the heap,
            // If an old room is allocated, then also we have to add to the heap with updated end time.
            allocator.add(intervals[i][1]);
            System.out.println("New interval: ["+ intervals[i][0] + ", " + intervals[i][1] + "]");
            System.out.println("Rooms needed: "+ allocator.size());
        }

        // The size of the heap tells us the minimum rooms required for all the meetings.
        return allocator.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,10},{2,7},{3,19},{8,12},{10,20},{11,30}, {14, 25}, {30, 35}};
        int[][] intervals_2 = {{55720,349290},{688809,868579},{405490,841727},{145683,162453},{161225,936277},
                {319899,784036},{47904,139575},{58916,998828},{223305,745027},{353070,801099},{498237,899576},
                {545153,689213},{580153,668329},{36374,364587},{73797,257807},{389937,930931},{238654,297234},
                {222415,942372},{83322,317295},{53474,516376},{78109,194849},{312232,728350},{62606,892477},
                {289983,677972},{524923,626259},{421051,862946},{854186,876721},{398669,740947},{198520,864653},
                {273686,541633},{59923,106998},{206544,211760},{754288,843998},{850133,982427},{559760,676574},
                {189946,459169},{934775,952899},{195284,312052},{75317,138600},{84724,484201}, {3472,970066},
                {182813,247978},{113082,897914},{443140,666044},{140111,928781},{322697,855303},{238006,298073},
                {178580,740526},{43876,97211},{76529,458293},{586411,809637},{513611,518730},{262290,391753},
                {169619,895289},{550535,708133},{205321,997268},{278572,445336},{172270,179282},{879628,991532},
                {509348,541320},{301939,470129},{21603,678763},{450526,731148},{239862,974936},{10253,255308},
                {213914,908486},{455324,816438},{62108,964099},{167976,798660},{219825,315546},{764076,948535},
                {51130,226137},{172611,389151},{118319,658061},{402935,823442},{593991,783234},{426150,943246},
                {289753,692787},{447005,816658},{327385,440307},{249162,321630},{429499,595607},{381038,475281},
                {583186,989552},{655808,986935},{144494,825667},{24238,483480},{122773,632790},{715548,934283},
                {41838,477020},{691714,983762},{132740,404906},{471526,819622},{34304,215501}, {623145,768663},
                {373850,673373},{560514,869162},{736155,882633},{491072,985459},{238611,953699}, {164538,615999},
                {252995,535799},{475528,482423},{4941,673059},{196736,421327},{681519,849447},{81674,95942},
                {741860,904793},{504991,649586},{344002,772544},{87001,853983},{231865,812943},{198253,713577},
                {181318,481445},{677759,884948},{844883,903007},{8059,248529},{843579,921791},{94492,853040},
                {419339,421774},{316916,905120},{297521,309109},{583854,600414},{377707,608513},{406966,485538},
                {294892,792676},{580154,723401},{225277,534109},{417813,959630},{182133,292049},{64994,842555},
                {51116,314039},{509615,872446},{115887,510640},{256739,523185},{445024,672722},{274078,898657},
                {591988,707638},{891114,908492},{493026,914060},{312207,475083},{556210,841875},{264146,622094},
                {82996,521419},{492091,699531},{87732,986277},{89747,721583},{90224,915337},{634391,941405},{428041,460798}};
        MeetingRoomsII solution = new MeetingRoomsII();
        long start = System.currentTimeMillis();
        System.out.println(solution.minMeetingRoomsBrute(intervals_2));
        long end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start));
        start = System.currentTimeMillis();
        System.out.println(solution.minMeetingRooms(intervals));
        end = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (end - start));
    }
}
