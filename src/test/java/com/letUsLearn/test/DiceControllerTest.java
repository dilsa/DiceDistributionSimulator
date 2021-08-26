package com.letUsLearn.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MvcResult;

import com.letUsLearn.vo.DDSVo;

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
}
