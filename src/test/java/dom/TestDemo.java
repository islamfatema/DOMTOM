package dom;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestDemo {
	List<String> myArrayList = new ArrayList<String>();
	 
	@Test
	public void setup() {
		myArrayList.add("Chrome");
		myArrayList.add("FireFox");
		myArrayList.add("IE");
		myArrayList.add("Safari");
		myArrayList.add("Chrome");
		System.out.println(myArrayList.size());
		for(String myList:myArrayList){
			System.out.print("All values are " +myList);
			System.out.println(myArrayList.indexOf(2));
		}
		if(myArrayList.contains("IE")){
			System.out.println(myArrayList.get(2));
		}
		if(!myArrayList.contains("Opera")){
			System.out.println("Opera not found");
		}
	}
	@Test
	public void funWithArrayLists() {
		setup();
	}	 
	@Test
	public void funWithJavaStrings() {		
		
		String companyName = "Dom & Tom Inc.";
		Assert.assertTrue(companyName.contains("Dom"));
		// Assert that the word 'Dom' is present in companyName string
	
		String name1 = "Netflix";
		String name2 = "NETFLIX";
		// Assert that name1 equals name2 regardless of case and leading/trailing spaces
		Assert.assertTrue(!name1.contentEquals(name2));
		
		String intValue1 = "100";
		String intValue2 = "20";
		// Convert the above 2 strings to integer values and display the sum
		int num1=Integer.parseInt(intValue1);
		int num2=Integer.parseInt(intValue2);
		System.out.println(num1+num2);
	}
 @Test
		public  void funWithHashMaps(){
		HashMap<Integer, String> myHashMap = new HashMap<Integer, String>();
		myHashMap.put(1, "XP");
		myHashMap.put(2, "XINZ7");
		myHashMap.put(3, "WIN8");
		System.out.println(myHashMap.get(1));
		System.out.println(myHashMap.size());
		System.out.println(myHashMap.remove(2));
		
	
		}	
 @Test
	public void funWithHashSets() {

		// *  Create a HashSet of String objects called myHashSet
		Set<String> myHashSet = new HashSet<String>();
		myHashSet.add("XP");
		myHashSet.add("WIN7");
		myHashSet.add("WIN8");
		myHashSet.add("Safari");
		myHashSet.add("XP");

		Iterator it=myHashSet.iterator();
		 
		 while(it.hasNext()){
		 String set=(String) it.next();
		     System.out.println(set);
		 }
	myHashSet.remove("XP");
	 System.out.println(myHashSet);
		
	
	}	
		
 public void main (String []args){
	 TestDemo hM=new TestDemo();
	 hM.setup();
 }
}
