package com.algo.graph.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShortestPathRequestBean {
	@JsonProperty("inputMatrix")
	private int[][] inputMatrix;
	@JsonProperty("rows")
	private int rows;
	@JsonProperty("cols")
	private int cols;
	@JsonProperty("source")
	private int[] source;
	@JsonProperty("dest")
	private int[] dest;

	public ShortestPathRequestBean() {
	}

	public int[][] getInputMatrix() {
		return inputMatrix;
	}

	public void setInputMatrix(int[][] inputMatrix) {
		this.inputMatrix = inputMatrix;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int[] getSource() {
		return source;
	}

	public void setSource(int[] source) {
		this.source = source;
	}

	public int[] getDest() {
		return dest;
	}

	public void setDest(int[] dest) {
		this.dest = dest;
	}

	public ShortestPathRequestBean(int[][] inputMatrix, int rows, int cols, int[] source, int[] dest) {
		super();
		this.inputMatrix = inputMatrix;
		this.rows = rows;
		this.cols = cols;
		this.source = source;
		this.dest = dest;
	}

}
