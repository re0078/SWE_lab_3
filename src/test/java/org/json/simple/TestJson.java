/*
 * $Id: Test.java,v 1.1 2006/04/15 14:40:06 platform Exp $
 * Created on 2006-4-15
 */
package org.json.simple;

import static org.junit.Assert.assertEquals;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestJson {

	@Test
	public void testDecodeArray() throws Exception{
		System.out.println("=======decode array=======");

		String s="[0,10]";
		Object obj=JSONValue.parse(s);
		JSONArray array=(JSONArray)obj;
		System.out.println("======the 2nd element of array======");
		System.out.println(array.get(1));
		System.out.println();
		assertEquals("10",array.get(1).toString());
	}

	@Test
	public void testJSONArrayCollection() {
		final ArrayList<String> testList = new ArrayList<String>();
		testList.add("First item");
		testList.add("Second item");
		final JSONArray jsonArray = new JSONArray(testList);

		assertEquals("[\"First item\",\"Second item\"]", jsonArray.toJSONString());
	}

	@Test
	public void testEscape(){
		JSONObject jsonObject = new JSONObject();
		String text = "Text with special character /\"\'\b\f\t\r\n.";
		System.out.println(text.length());
		System.out.println("Apply escaping.");
		text = jsonObject.escape(text);
		assertEquals(text.length(), 44);
		System.out.println(text.length());
	}

	@Test
	public void testEncodeMapToString(){
		System.out.println("=======encode hashmap=======");
		Map<Integer, Double> hm = new HashMap<>();
		hm.put(1, (double)1);
		JSONObject obj = new JSONObject(hm);
		String str = obj.toString();
		assertEquals(str, "{\"1\":1.0}");
	}

	@Test
	public void testEncodeArrayOfObjectsToString(){
		System.out.println("=======encode array of objects=======");
		Object[] arr = {1.0, 2, null, 4.0, 5};
		String str = JSONArray.toJSONString(arr).toString();
		System.out.println(str);
		assertEquals(str, "[1.0,2,null,4.0,5]");
	}

	@Test
	public void testEncodeArrayOfBooleansToString(){
		System.out.println("=======encode array of objects=======");
		boolean[] arr = {true, false, true};
		String str = JSONArray.toJSONString(arr).toString();
		System.out.println(str);
		assertEquals(str, "[true,false,true]");
	}

	@Test
	public void testJSONValueEncode(){
		System.out.println("=======encode array of objects=======");
		Object obj = new int[] {1, 2, 3, 4, 5};
		String str = JSONValue.toJSONString(obj);
		System.out.println(str);
		assertEquals(str, "[1,2,3,4,5]");
	}
}
