package javaStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CountFilter {

	@Test
	//public static void main(String[] args) 
	public void regular()
	{
	
		ArrayList<String> values=new ArrayList<String>();
		values.add("Yamini");
		values.add("Yash");
		values.add("Gangadhar");
		values.add("Yuva");
		
		int count=0;
		for(int i=0; i<values.size(); i++)
		{
			String actual=values.get(i);
			if(actual.startsWith("Y"))
			{
				count++;
			}
		}
		System.out.println(count);

	} 

	@Test
	public void StreamFilter()


	{
		ArrayList<String> values=new ArrayList<String>();
		values.add("Yamini");
		values.add("Yash");
		values.add("Gangadhar");
		values.add("Yuva");
		
		Long c=values.stream().filter(s->s.startsWith("Y")).count();
		System.out.println("count"+c);
		
		Long d= Stream.of("Yamini","Yash","Gangadhar","Yuva").filter(s->
		
		{
			s.startsWith("A");
			return true;
		}
				).count();
		System.out.println(d);
		
		//Print all the name in arraylist
		//values.stream().filter(s->s.length()>3).forEach(s->System.out.println(s));
		values.stream().filter(s->s.length()>3).limit(1).forEach(s->System.out.println(s));
	}
	
	@Test
	public void  streamMap()
	{
		ArrayList<String> values=new ArrayList<String>();
		values.add("Janu");
		values.add("Mli");
		values.add("Saji");
		values.add("Ano");
		
		//Print which names last letter as a with uppercase
		Stream.of("Yamina","Yash","Gangadhar","Yuva").filter(s->s.endsWith("a")).map(s->s.toUpperCase()).forEach(s->System.out.println(s));

		//Print which names start letter as a with uppercase as sorted
		List<String>names=Arrays.asList("Yamina","Yash","Gangadhar","Yuva");
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s->System.out.println(s));
		
		
		//Merging 2 different List
		Stream<String> union=Stream.concat(values.stream(), names.stream());
		//union.sorted().forEach(s->System.out.println(s));
		boolean flag=union.anyMatch(s->s.equalsIgnoreCase("Yuva"));
		System.out.println(flag);
		Assert.assertTrue(flag);
	}
	
	@Test
	public void streamCollect()
	{
		//Using collectors get list 
		List<String> li=Stream.of("Yamina","Yash","Gangadhar","Yuva").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
          .collect(Collectors.toList());
		System.out.println(li.get(1));
		
		
		//Print Unique value in given list
		List<Integer> numbers=Arrays.asList(4,2,2,9,1,3);
		numbers.stream().distinct().forEach(s->System.out.println(s));
		//Sort the array and print 3 value
		List<Integer> ln=numbers.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(ln.get(3));
		
	}

	
	
}
