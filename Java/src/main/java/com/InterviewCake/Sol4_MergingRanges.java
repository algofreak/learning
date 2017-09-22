package com.InterviewCake;

import com.beust.jcommander.internal.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: pgajjar
 * @since: 9/2/17
 */
public class Sol4_MergingRanges {
    public static class Meeting /*implements Comparable<Meeting>*/ {

        private int startTime;
        private int endTime;

        public Meeting(int startTime, int endTime) {
            // number of 30 min blocks past 9:00 am
            this.startTime = startTime;
            this.endTime   = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public void setStartTime(int startTime) {
            this.startTime = startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public boolean overlaps(@NonNull Meeting other) {
            return getEndTime() >= other.getStartTime();
        }

        // @Override public int compareTo(@NotNull Meeting other) { return this.getStartTime() - other.getStartTime(); }

        @Override public String toString() {
            return "[" + startTime + ", " + endTime + "]";
        }
    }

    public static List<Meeting> mergeRanges1(final List<Meeting> meetings) {
        Collections.sort(meetings, (a, b) -> a.getStartTime() - b.getStartTime());

        final List<Meeting> merged = Lists.newArrayList();

        int i = 0;
        while (i < meetings.size()) {
            Meeting current = meetings.get(i);
            while (i < meetings.size() - 1 && current.overlaps(meetings.get(i + 1))) {
                current = new Meeting(current.getStartTime(), Math.max(current.getEndTime(), meetings.get(i + 1).getEndTime()));
                i++;
            }
            merged.add(current);
            i++;
        }

        return merged;
    }

    public static List<Meeting> mergeRanges(final List<Meeting> meetings) {
        Collections.sort(meetings, (a, b) -> a.getStartTime() - b.getStartTime());
        final List<Meeting> merged = Lists.newArrayList();

        if (CollectionUtils.isEmpty(meetings)) {
            return merged;
        }

        merged.add(meetings.get(0));
        for (Meeting current : meetings) {
            Meeting m = merged.get(merged.size() - 1);

            if (m.overlaps(current)) {
                m.setStartTime(Math.min(m.getStartTime(), current.getStartTime()));
                m.setEndTime(Math.max(m.getEndTime(), current.getEndTime()));
            } else {
                merged.add(current);
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        List<Meeting> meetings = Arrays.asList(
                new Meeting(10, 12),
                new Meeting(0, 1),
                new Meeting(3, 5),
                new Meeting(4, 8),
                new Meeting(9, 10)
        );

        System.out.println(meetings);
        System.out.println(mergeRanges(meetings));

        meetings = Arrays.asList(
                new Meeting(11, 12),
                new Meeting(0, 1),
                new Meeting(3, 5),
                new Meeting(6, 8),
                new Meeting(9, 10)
        );

        System.out.println(meetings);
        System.out.println(mergeRanges(meetings));

        meetings = Arrays.asList(
                new Meeting(11, 14),
                new Meeting(0, 4),
                new Meeting(3, 7),
                new Meeting(6, 15),
                new Meeting(9, 12)
        );

        System.out.println(meetings);
        System.out.println(mergeRanges(meetings));

        meetings = Arrays.asList(
                new Meeting(1, 5),
                new Meeting(2, 3)
        );

        System.out.println(meetings);
        System.out.println(mergeRanges(meetings));

        meetings = Arrays.asList(
                new Meeting(1, 10),
                new Meeting(2, 6),
                new Meeting(3, 5),
                new Meeting(7, 9)
        );

        System.out.println(meetings);
        System.out.println(mergeRanges(meetings));

        meetings = Arrays.asList(
                new Meeting(-1, 3),
                new Meeting(2, 4),
                new Meeting(4, 7)
        );

        System.out.println(meetings);
        System.out.println(mergeRanges(meetings));
    }
}
