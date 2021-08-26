package com.letUsLearn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.letUsLearn.service.DDSService;

@RestController
public class DiceController {
	@Autowired
	DDSService service;

	@RequestMapping(method = RequestMethod.GET, path = "/dds")
	public ResponseEntity<?> ddsimulator(@RequestParam("dices") int dices, @RequestParam("sides") int sides,
			@RequestParam("rolls") int rolls) throws Exception {
		return ResponseEntity.ok(service.diceRoll(sides, dices, rolls));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/dds/summary")
	public ResponseEntity<?> summary() throws Exception {
		return ResponseEntity.ok(service.summary());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/dds/{id}")
	public ResponseEntity<?> findbyid(@PathVariable(value = "id") Long id) throws Exception {
		return ResponseEntity.ok(service.findbyid(id));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/dds/relativesummary")
	public ResponseEntity<?> relativesummary() throws Exception {
		return ResponseEntity.ok(service.relativeSummary());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/dds/relativesummary/{dices}/{sides}")
	public ResponseEntity<?> relativesummary(@PathVariable(value = "dices") int dices,
			@PathVariable(value = "sides") int sides) throws Exception {
		return ResponseEntity.ok(service.relativeSummary(dices, sides));
	}
}