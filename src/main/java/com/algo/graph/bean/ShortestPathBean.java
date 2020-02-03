package com.algo.graph.bean;

import java.util.LinkedList;

public class ShortestPathBean {

	private int i;
	private int j;
	private int distance;
	private LinkedList<LinkedList<Integer>> pathTrace;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
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

	public ShortestPathBean(int i, int j, int distance, LinkedList<LinkedList<Integer>> pathTrace) {
		super();
		this.i = i;
		this.j = j;
		this.distance = distance;
		this.pathTrace = new LinkedList<LinkedList<Integer>>(pathTrace);
	}

	public ShortestPathBean appendPathToTrace(int i, int j) {
		LinkedList<Integer> listToAdd = new LinkedList<Integer>();
		listToAdd.add(i);
		listToAdd.add(j);
		this.pathTrace.add(listToAdd);
		return this;
	}
}
