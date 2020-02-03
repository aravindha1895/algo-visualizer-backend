package com.algo.graph.service;

import java.util.LinkedList;
import java.util.Queue;

import org.springframework.stereotype.Service;

import com.algo.graph.bean.ShortestPathBean;
import com.algo.graph.bean.ShortestPathResponseBean;

@Service
public class ShortestPathService {

	/**
	 * Function checks boundary conditions
	 * 
	 * @param inputMatrix
	 * @param r
	 * @param c
	 * @return
	 */
	private boolean isSafe(int[][] inputMatrix, int r, int c) {
		if (r >= 0 && r < inputMatrix.length && c >= 0 && c < inputMatrix[0].length && inputMatrix[r][c] == 1)
			return true;
		return false;
	}

	/**
	 * Function that finds shortest path. i,j is source and x,y is destination.
	 * Returns shortest distance, all nodes visited and nodes as a part of shortest
	 * distance
	 * 
	 * @param inputMatrix
	 * @param i
	 * @param j
	 * @param x
	 * @param y
	 * @return
	 */
	public ShortestPathResponseBean getShortestDistanceAnimations(int[][] inputMatrix, int i, int j, int x, int y) {
		boolean[][] visited = new boolean[inputMatrix.length][inputMatrix[0].length];
		int[] rows = { 0, 0, 1, -1 };
		int[] cols = { -1, 1, 0, 0 };
		LinkedList<LinkedList<Integer>> allNodesVisited = new LinkedList<LinkedList<Integer>>();
		Queue<ShortestPathBean> queue = new LinkedList<ShortestPathBean>();
		ShortestPathBean sourceNode = new ShortestPathBean(i, j, 0, new LinkedList<LinkedList<Integer>>());
		sourceNode.appendPathToTrace(i, j);
		queue.add(sourceNode);
		visited[i][j] = true;
		while (!queue.isEmpty()) {
			ShortestPathBean curr = queue.remove();
			addToAllNodes(allNodesVisited, curr.getI(), curr.getJ()); // Keeps track of all nodes visited
			if (curr.getI() == x && curr.getJ() == y) { // Reached destination
				ShortestPathResponseBean shortestPathResponseBean = new ShortestPathResponseBean();
				shortestPathResponseBean.setDistance(curr.getDistance());
				shortestPathResponseBean.setPathTrace(allNodesVisited);
				shortestPathResponseBean.setShortestPathTrace(curr.getPathTrace());
				return shortestPathResponseBean;
			}
			// move in left, right, forward and backward direction except diagonally.
			for (int k = 0; k < 4; k++) {
				int newRow = curr.getI() + rows[k];
				int newCol = curr.getJ() + cols[k];
				if (isSafe(inputMatrix, newRow, newCol) && visited[newRow][newCol] == false) {
					queue.add(new ShortestPathBean(newRow, newCol, curr.getDistance() + 1, curr.getPathTrace())
							.appendPathToTrace(newRow, newCol));
					visited[newRow][newCol] = true;
				}
			}
		}
		return new ShortestPathResponseBean().distance(-1); // -1 signifies no path is found
	}

	/**
	 * Function that adds nodes visited to allNodesVisited list
	 * 
	 * @param allNodesVisited
	 * @param i
	 * @param j
	 */
	private void addToAllNodes(LinkedList<LinkedList<Integer>> allNodesVisited, int i, int j) {
		LinkedList<Integer> listToAdd = new LinkedList<Integer>();
		listToAdd.add(i);
		listToAdd.add(j);
		allNodesVisited.add(listToAdd);
	}
}
