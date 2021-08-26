package com.letUsLearn.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letUsLearn.entity.DDS;
import com.letUsLearn.entity.DDSdetail;
import com.letUsLearn.exception.DDSBadInputException;
import com.letUsLearn.exception.DDSNotFoundException;
import com.letUsLearn.repository.DDSDetailRepository;
import com.letUsLearn.repository.DDSRepository;
import com.letUsLearn.vo.DDSVo;
import com.letUsLearn.vo.RelativeSummaryVO;
import com.letUsLearn.vo.SummaryVO;

@Service
public class DDSService {

	@Autowired
	DDSRepository repository1;

	@Autowired
	DDSDetailRepository repository2;

	public DDSVo diceRoll(int sides, int dices, int rolls) throws Exception {
		if (sides < 4 || dices < 1 || rolls < 1) {
			throw new DDSBadInputException("BadInput:required -->sides>=4 && dices>=1 && rolls>=1");
		}
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		Random ranNum = new Random();
		int randomNumber = 0;
		for (int j = 0; j < rolls; j++) {
			int key = 0;
			for (int i = 0; i < dices; i++) {
				randomNumber = ranNum.nextInt(sides) + 1;
				key = key + randomNumber;
			}
			Integer value = map.get(key);
			if (value == null)
				value = 0;
			value = value + 1;
			map.put(key, value);
		}
		DDS dds = new DDS(rolls, sides, dices);
		dds = repository1.save(dds);
		Iterator<Integer> iterate = map.keySet().iterator();
		while (iterate.hasNext()) {
			Integer key = iterate.next();
			Integer times = map.get(key);
			DDSdetail ddSdetail = new DDSdetail(key, times, dds);
			repository2.save(ddSdetail);
		}
		DDSVo ddsVo = new DDSVo(dds.getId(), dds.getRolls(), dds.getSides(), dds.getDices(), map);
		return ddsVo;
	}

	public DDSVo findbyid(Long id) throws DDSNotFoundException {
		if (repository1.findById(id).isEmpty())	throw new DDSNotFoundException("No item found for {id}=" + id);
		DDS dds = repository1.findById(id).get();
		Iterator<DDSdetail> itr = dds.getDdsdetail().iterator();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (itr.hasNext()) {
			DDSdetail ddSdetail = itr.next();
			map.put(ddSdetail.getRolledvalue(), ddSdetail.getTimes());
		}
		DDSVo ddsVo = new DDSVo(dds.getId(), dds.getRolls(), dds.getSides(), dds.getDices(), map);
		return ddsVo;
	}

	public List<SummaryVO> summary() {
		List<Integer[]> list = repository1.diceSummary();
		List<SummaryVO> summaryVolist = new ArrayList<SummaryVO>();
		for (Integer[] integers : list) {
			SummaryVO svo = new SummaryVO(integers);
			summaryVolist.add(svo);
		}
		return summaryVolist;
	}

	public List<RelativeSummaryVO> relativeSummary() {
		List<Integer[]> list = repository1.diceRelativeSummary();
		List<RelativeSummaryVO> summaryVolist = new ArrayList<RelativeSummaryVO>();
		for (Integer[] integers : list) {
			RelativeSummaryVO rvo = new RelativeSummaryVO(integers);
			summaryVolist.add(rvo);
		}
		return summaryVolist;
	}

	public List<RelativeSummaryVO> relativeSummary(int dices, int sides) {
		List<Integer[]> list = repository1.diceRelativeSummaryltd(dices, sides);
		List<RelativeSummaryVO> summaryVolist = new ArrayList<RelativeSummaryVO>();
		for (Integer[] integers : list) {
			RelativeSummaryVO rvo = new RelativeSummaryVO(integers);
			summaryVolist.add(rvo);
		}
		return summaryVolist;

	}
}
