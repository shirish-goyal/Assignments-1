package com.hashedin.assignment.milestone1.queries;

import java.util.List;
import java.util.stream.Collectors;

import com.hashedin.assignment.milestone1.Titles;

public class Query3 extends Query {

	private List<Titles> netfixTitlesList;

	public Query3(List<Titles> netfixTitlesList) {
		super();
		this.netfixTitlesList = netfixTitlesList;
	}

	public void execute() {
		System.out.println("Query3: List the first n type:  where country: ​?");
		System.out.print("Enter type : ");
		String type = scanner.nextLine();
		System.out.print("Enter country : ");
		String country = scanner.nextLine();
		System.out.print("Enter n : ");
		int n = scanner.nextInt();

		long startTime = System.nanoTime();
		List<Titles> reqestedDataList = netfixTitlesList.stream().filter(
				title -> (title.getType().equalsIgnoreCase(type) && title.getCountry().equalsIgnoreCase(country)))
				.limit(n).collect(Collectors.toList());

		reqestedDataList.forEach(System.out::println);
		System.out.println("Execution time in millis : " + (System.nanoTime() - startTime)/1000000);

	}

}