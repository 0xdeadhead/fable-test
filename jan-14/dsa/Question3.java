package com.deadhead.otp_rate_limit_prototype.controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question3 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfIntervals = Integer.parseInt(sc.nextLine());
            int currInterval = 0;
            List<List<Integer>> intervals = new ArrayList<List<Integer>>();
            while (currInterval < numOfIntervals) {
                String[] lineSplit = sc.nextLine().split(" ");
                List<Integer> interval = new ArrayList<Integer>();
                interval.add(Integer.parseInt(lineSplit[0]));
                interval.add(Integer.parseInt(lineSplit[1]));
                intervals.add(interval);
                currInterval++;
            }
            Collections.sort(intervals, (a, b) -> a.get(0) - b.get(0));
            Deque<List<Integer>> intervalsDeque = new LinkedList<List<Integer>>();
            for (List<Integer> interval : intervals) {
                if (intervalsDeque.size() == 0)
                    intervalsDeque.addLast(interval);
                else {
                    List<Integer> prevInterval = intervalsDeque.pollLast();
                    if (prevInterval.get(1) < interval.get(0)) {
                        intervalsDeque.addLast(prevInterval);
                        intervalsDeque.addLast(interval);
                    } else {
                        prevInterval.set(1, Math.max(interval.get(1), prevInterval.get(1)));
                        intervalsDeque.addLast(prevInterval);
                    }
                }
            }
            System.out.println(intervalsDeque);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
