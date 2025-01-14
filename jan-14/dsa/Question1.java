package com.deadhead.otp_rate_limit_prototype.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

public class Question1 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int numOfNodes = Integer.parseInt(sc.nextLine());
            int edges = Integer.parseInt(sc.nextLine());
            int edgeNum = 0;
            Graph dag = new Graph();
            while (edgeNum < edges) {
                String[] nodes = sc.nextLine().split(" ");
                dag.addEdge(Integer.parseInt(nodes[0]), Integer.parseInt(nodes[1]));
                edgeNum++;
            }
            Stack<Integer> dependencyOrder = new Stack<>();
            boolean containsCycle = dfs(dag, new HashSet<>(), new HashSet<>(), 1, dependencyOrder);
            if (!containsCycle) {
                List<String> dependencyList = dependencyOrder.stream().map(String::valueOf)
                        .collect(Collectors.toList());
                Collections.reverse(dependencyList);
                System.out.println(dependencyList);

            } else
                System.out.println("Impossible to complete all tasks");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static boolean dfs(Graph dag, Set<Integer> visited, Set<Integer> pathStack, Integer node,
            Stack<Integer> dependencyOrder) {
        visited.add(node);
        pathStack.add(node);
        boolean containsCycle = false;
        for (Integer neighbour : dag.getEdges().get(node)) {
            if (pathStack.contains(neighbour))
                return true;
            if (!visited.contains(neighbour)) {
                containsCycle = (containsCycle || dfs(dag, visited, pathStack, neighbour, dependencyOrder));
            }
        }
        pathStack.remove(node);
        dependencyOrder.push(node);
        return containsCycle;
    }

}

class Graph {
    private Map<Integer, Set<Integer>> edges;

    public Graph() {
        this.edges = new HashMap<Integer, Set<Integer>>();
    }

    public void addEdge(int source, int destination) {
        this.edges.putIfAbsent(source, new HashSet<>());
        this.edges.putIfAbsent(destination, new HashSet<>());
        Set<Integer> connectedNodes = this.edges.get(source);
        connectedNodes.add(destination);
    }

    @Override
    public String toString() {
        return "Graph [edges=" + edges + "]";
    }

    public Map<Integer, Set<Integer>> getEdges() {
        return edges;
    }

    public void setEdges(Map<Integer, Set<Integer>> edges) {
        this.edges = edges;
    }
}
