package com.deadhead.otp_rate_limit_prototype.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfIntervals = Integer.parseInt(sc.nextLine());
            int currInterval = 0;
            List<int[]> intervals = new ArrayList<>();
            while (currInterval < numOfIntervals) {
                String[] lineSplit = sc.nextLine().split(" ");
                int[] interval = new int[2];
                interval[0] = Integer.parseInt(lineSplit[0]);
                interval[1] = Integer.parseInt(lineSplit[1]);
                intervals.add(interval);
                currInterval++;
            }
            int[] startTimes = new int[intervals.size()];
            int[] endTimes = new int[intervals.size()];
            int i = 0;
            for (int[] interval : intervals) {
                startTimes[i] = interval[0];
                endTimes[i] = interval[1];
                i++;
            }
            Arrays.sort(startTimes);
            Arrays.sort(endTimes);
            int startInd = 0, endInd = 0;
            int roomsOccupied = 0, maxRoomsOccupied = 0;
            while (startInd < startTimes.length && endInd < endTimes.length) {
                if (startTimes[startInd] < endTimes[endInd]) {
                    roomsOccupied++;
                    startInd++;
                } else {
                    endInd++;
                    roomsOccupied--;
                }
                maxRoomsOccupied = Math.max(maxRoomsOccupied, roomsOccupied);
            }
            System.out.println(maxRoomsOccupied);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
