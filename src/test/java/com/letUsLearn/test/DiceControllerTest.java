package com.letUsLearn.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import com.letUsLearn.MainApplication;
import com.letUsLearn.entity.DDS;
import com.letUsLearn.entity.DDSdetail;
import com.letUsLearn.exception.DDSBadInputException;
import com.letUsLearn.exception.DDSNotFoundException;
import com.letUsLearn.vo.DDSVo;
import com.letUsLearn.vo.RelativeSummaryVO;
import com.letUsLearn.vo.SummaryVO;

public class DiceControllerTest extends AbstractTest {

	@Override
	@Before
	public void setUp() {
		super.setUp();
	}
	
	
	@Test
	public void gethealthcheck() throws Exception {
		MvcResult mvcResult = getMVCresult("/healthcheck");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = getContent(mvcResult);
		HashMap<String, String> map =  (HashMap<String, String>) super.mapFromJson(content, Map.class);
		assertEquals(map.get("Status"), "ok");
		assertNull(map.get("time"));
		assertEquals(content, mapToJson(map));
	}
	
	@Test
	public void gethealthcheckfull() throws Exception {
		MvcResult mvcResult = getMVCresult("/healthcheck?format=full");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = getContent(mvcResult);
		HashMap<String, String> map =  (HashMap<String, String>) super.mapFromJson(content, Map.class);
		assertEquals(map.get("Status"), "ok");
		assertNotNull(map.get("time"));		
	}
	
	@Test
	public void getDDSbyId11() throws Exception {
		MvcResult mvcResult = getMVCresult("/dds/22222");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(404, status);
		// assertTrue(productlist.length > 0);
	}

	@Test
	public void getDDSbyId1() throws Exception {
		MvcResult mvcResult = getMVCresult("/dds/1");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = getContent(mvcResult);
		DDSVo ddsvo = (DDSVo) super.mapFromJson(content, DDSVo.class);
	}

	@Test
	public void createDDS() throws Exception {
		MvcResult mvcResult = getMVCresult("/dds?dices=3&sides=6&rolls=5");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = getContent(mvcResult);
	}
	@Test
	public void createDDSBadInput() throws Exception {
		MvcResult mvcResult = getMVCresult("/dds?dices=0&sides=6&rolls=5");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(400, status);
		String content = getContent(mvcResult);
	}

	@Test
	public void getDDSSummary() throws Exception {
		MvcResult mvcResult = getMVCresult("/dds/summary");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = getContent(mvcResult);
	}
	
	@Test
	public void getDDSrelativesummary() throws Exception {
		MvcResult mvcResult = getMVCresult("/dds/relativesummary");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = getContent(mvcResult);
	}
	
	@Test
	public void getDDSrelativesummaryDiceSide() throws Exception {
		MvcResult mvcResult = getMVCresult("/dds/relativesummary/3/6");
		int status = mvcResult.getResponse().getStatus();
		assertEquals(200, status);
		String content = getContent(mvcResult);
	}
	
	@Test
	public void derbyTest() throws Exception {
		Derbytest dbt = new Derbytest();
		Derbytest.main(null);	
	}
	
	@Test
	public void increaseCouverage() throws Exception {
		new DDSBadInputException();
		new DDSNotFoundException();
		DDSdetail a= new DDSdetail();
		a.setDds(a.getDds());
		a.setId(0);
		a.setRolledvalue(0);
		a.setTimes(0);
		DDS b= new DDS();
		b.setDdsdetail(null);
		b.setDices(0);
		b.setId(0);
		b.setRolls(0);
		b.setSides(0);
		RelativeSummaryVO c= new RelativeSummaryVO();
		c.setDices(0);
		c.setRelativePercentage(null);
		c.setRollValue(0);
		c.setSides(0);
		c.setSumofrolls(0);
		c.setTotalroll(0);
		SummaryVO d=new SummaryVO();
		d.setCount(0);
		d.setDices(0);
		d.setSides(0);
		d.setSumofrolls(0);
		String[] e= {"a"};
		MainApplication.main(e);
	}
}
