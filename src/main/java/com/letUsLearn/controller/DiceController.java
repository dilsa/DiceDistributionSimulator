package com.letUsLearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.letUsLearn.service.DDSService;
import com.letUsLearn.vo.DDSVo;
import com.letUsLearn.vo.RelativeSummaryVO;
import com.letUsLearn.vo.SummaryVO;

@RestController
public class DiceController {
	@Autowired
	DDSService service;

	@RequestMapping(method = RequestMethod.GET, path = "/dds")
	public DDSVo ddsimulator(@RequestParam("dices") int dices, @RequestParam("sides") int sides,
			@RequestParam("rolls") int rolls) {
		try {
			return service.diceRoll(sides, dices, rolls);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.OK, e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/dds/summary")
	public List<SummaryVO> summary() {
		try {
			return service.summary();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.OK, e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/dds/{id}")
	public DDSVo findbyid(@PathVariable(value = "id") Long id) {
		try {
			return service.findbyid(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.OK, e.getMessage(), e);
		}
	}

	@RequestMapping(method = RequestMethod.GET, path = "/dds/relativesummary")
	public List<RelativeSummaryVO> relativesummary() {
		try {
			return service.relativeSummary();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.OK, e.getMessage(), e);
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/dds/relativesummary/{dices}/{sides}")
	public List<RelativeSummaryVO> relativesummary(@PathVariable(value = "dices") int dices,
			@PathVariable(value = "sides") int sides) {
		try {
			return service.relativeSummary(dices, sides);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.OK, e.getMessage(), e);
		}
	}
}