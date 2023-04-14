# آزمایش سوم آزمایشگاه مهندسی نرم‌افزار

## توضیحات آزمایش
در این آزمایش  هدف ما این است که با افزودن بخش‌هایی به کد تست، اعداد پوشش آزمون را مورد تمامی کلاس‌های موجود در برنامه (تمام کلاس‌ها شامل کلاس‌های پوشه پارسر) بهبود دهیم.(درصد افزایش اعداد پوشش آزمون مهم نیست)  
## مراحل انجام آزمایش
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

