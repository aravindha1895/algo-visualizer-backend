package com.algo.graph.bean;

import java.util.LinkedList;

public class ShortestPathResponseBean {
	private int distance;
	private LinkedList<LinkedList<Integer>> pathTrace;
	private LinkedList<LinkedList<Integer>> shortestPathTrace;

	public ShortestPathResponseBean() {
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public LinkedList<LinkedList<Integer>> getPathTrace() {
		return pathTrace;
	}

	public void setPathTrace(LinkedList<LinkedList<Integer>> pathTrace) {
		this.pathTrace = new LinkedList<LinkedList<Integer>>(pathTrace);
	}

	public LinkedList<LinkedList<Integer>> getShortestPathTrace() {
		return shortestPathTrace;
	}

	public void setShortestPathTrace(LinkedList<LinkedList<Integer>> shortestPathTrace) {
		this.shortestPathTrace = new LinkedList<LinkedList<Integer>>(shortestPathTrace);
	}

	public ShortestPathResponseBean(int distance, LinkedList<LinkedList<Integer>> pathTrace,
			LinkedList<LinkedList<Integer>> shortestPathTrace) {
		super();
		this.distance = distance;
		this.pathTrace = pathTrace;
		this.shortestPathTrace = shortestPathTrace;
	}

	public ShortestPathResponseBean distance(int d) {
		this.distance = d;
		return this;
	}

}
