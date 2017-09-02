package com.InterviewCake;

import com.beust.jcommander.internal.Lists;
import org.checkerframework.checker.nullness.qual.NonNull;

import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: pgajjar
 * @since: 9/2/17
 */
public class Sol4_MergingRanges {
    public static class Meeting implements Comparable<Meeting> {

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

        @Override public int compareTo(@NotNull Meeting other) {
            return this.getStartTime() - other.getStartTime();
        }

        @Override public String toString() {
            return "[" + startTime + ", " + endTime + "]";
        }
    }

    public static List<Meeting> mergeRanges(final List<Meeting> meetings) {
        Collections.sort(meetings);

        final List<Meeting> merged = Lists.newArrayList();

        int i = 0;
        while (i < meetings.size() - 1) {
            Meeting head = meetings.get(i);
            Meeting next = meetings.get(i + 1);
            while (head.overlaps(next) && i < meetings.size() - 1) {
                head = new Meeting(head.getStartTime(), Math.max(head.getEndTime(), next.getEndTime()));
                i++;
                if (i < meetings.size() - 1) {
                    next = meetings.get(i + 1);
                }
            }
            merged.add(head);
            i++;
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
    }
}
