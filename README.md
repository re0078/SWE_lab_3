# آزمایش سوم آزمایشگاه مهندسی نرم‌افزار

## توضیحات آزمایش
در این آزمایش  هدف ما این است که با افزودن بخش‌هایی به کد تست، اعداد پوشش آزمون را مورد تمامی کلاس‌های موجود در برنامه (تمام کلاس‌ها شامل کلاس‌های پوشه پارسر) بهبود دهیم.(درصد افزایش اعداد پوشش آزمون مهم نیست)  
## مراحل انجام آزمایش
ابتدا درصد پوشش قبل از اضافه کردن تست‌ها برای کلاس‌های جز پارسر را بررسی می‌کنیم که به صورت زیر است:
![](https://user-images.githubusercontent.com/59199865/232115088-d8f2715c-d6c3-4221-b258-3f43310efc41.png)
درصد پوشش قبل از اضافه کردن تست‌ها برای کلاس‌های پارسر به صورت زیر است:
![](https://user-images.githubusercontent.com/59199865/232116630-874a8be3-9245-4a3d-9839-076fb37d6d9a.png)

در ادامه به توضیحات بخش‌هایی که به عنوان تست اضافه کرده‌ایم می‌پردازیم.

۱. تابع escape در JSONObject (با استفاده از یک رشته نمونه)

```
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
```

۲. تابع toString در JSONObject (با تبدیل کردن هش‌مپ به رشته)

```
@Test
public void testEncodeMapToString(){
	System.out.println("=======encode hashmap=======");
	Map<Integer, Double> hm = new HashMap<>();
	hm.put(1, (double)1);
	JSONObject obj = new JSONObject(hm);
	String str = obj.toString();
	assertEquals(str, "{\"1\":1.0}");
}
```

۳. تابع toJSONString در JSONArray (با تبدیل یک آرایه از آبجکت‌ها به رشته)

```
@Test
public void testEncodeArrayOfObjectsToString(){
	System.out.println("=======encode array of objects=======");
	Object[] arr = {1.0, 2, null, 4.0, 5};
	String str = JSONArray.toJSONString(arr).toString();
	System.out.println(str);
	assertEquals(str, "[1.0,2,null,4.0,5]");
}
```

۴. تابع toJSONString در JSONArray (با تبدیل یک آرایه از بولین‌ها به رشته)

```
@Test
public void testEncodeArrayOfBooleansToString(){
	System.out.println("=======encode array of objects=======");
	boolean[] arr = {true, false, true};
	String str = JSONArray.toJSONString(arr).toString();
	System.out.println(str);
	assertEquals(str, "[true,false,true]");
}
```
۵. تابع toJSONString در JSONValue (با تبدیل یک آرایه از آبجکت‌ها به رشته)

```
@Test
public void testJSONValueEncode(){
	System.out.println("=======encode array of objects=======");
	Object obj = new int[] {1, 2, 3, 4, 5};
	String str = JSONValue.toJSONString(obj);
	System.out.println(str);
	assertEquals(str, "[1,2,3,4,5]");
}
```
۶. برای تست JSONParser
```
@Test
public void testJSONParsing() throws ParseException {
	String jsonString = "{\"name\":\"Re\", \"age\":23}";
	JSONParser parser = new JSONParser();
	JSONObject jsonObject = (JSONObject) parser.parse(jsonString);
	String name = (String) jsonObject.get("name");
	long age = (long) jsonObject.get("age");
	assertEquals("Re", name);
	assertEquals(23, age);
}
```
۷. برای تست Parse Exception
```
@Test(expected = ParseException.class)
public void testParseException() throws ParseException {
	String jsonString = "{\"name\":\"Re\", \"age\":23";

	JSONParser parser = new JSONParser();
	parser.parse(jsonString);
}
```
پس از اضافه کردن این تست‌ها درصد پوشش برای کلاس‌های جز پارسر به صورت زیر است:

![](https://user-images.githubusercontent.com/59199865/232120516-71273aa9-74fe-4393-89f1-4a312720c058.png)

درصد پوشش برای کلاس های پارسر به صورت زیر است:

![](https://user-images.githubusercontent.com/59199865/232121182-45d7d882-e37b-4c2a-9051-a2e47d953fca.png)

