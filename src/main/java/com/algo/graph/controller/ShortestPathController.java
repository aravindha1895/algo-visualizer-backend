package com.algo.graph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.algo.graph.bean.ShortestPathRequestBean;
import com.algo.graph.bean.ShortestPathResponseBean;
import com.algo.graph.service.ShortestPathService;

@RestController
public class ShortestPathController {

	@Autowired
	private ShortestPathService shortestPathService;

	@RequestMapping(method = RequestMethod.POST, path = "/getShortestPath", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ShortestPathResponseBean> getShortestPath(
			@RequestBody ShortestPathRequestBean shortestPathRequestBean) {

		Long start = System.currentTimeMillis();
		ShortestPathResponseBean response = shortestPathService.getShortestDistanceAnimations(
				shortestPathRequestBean.getInputMatrix(), shortestPathRequestBean.getSource()[0],
				shortestPathRequestBean.getSource()[1], shortestPathRequestBean.getDest()[0],
				shortestPathRequestBean.getDest()[1]);
		Long end = System.currentTimeMillis();
		System.out.println("Algorithm completed in " + (end - start) + " milliseconds");
		return new ResponseEntity<ShortestPathResponseBean>(response, HttpStatus.OK);
	}

}
