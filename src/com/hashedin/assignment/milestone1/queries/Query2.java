package com.hashedin.assignment.milestone1.queries;

import java.util.List;
import java.util.stream.Collectors;

import com.hashedin.assignment.milestone1.Titles;

public class Query2 extends Query {

	private List<Titles> netfixTitlesList;

	public Query2(List<Titles> netfixTitlesList) {
		super();
		this.netfixTitlesList = netfixTitlesList;
	}

	public void execute() {
		System.out.println("Query2: List the first n records where listed_in?");
		System.out.print("Enter listed_in : ");
		String listedIn = scanner.nextLine();
		System.out.print("Enter n : ");
		int n = scanner.nextInt();

		long startTime = System.nanoTime();
		List<Titles> reqestedDataList = netfixTitlesList.stream()
				.filter(title -> title.getListedIn().toLowerCase().contains(listedIn.toLowerCase())).limit(n).collect(Collectors.toList());

		reqestedDataList.forEach(System.out::println);
		System.out.println("Execution time in millis : " + (System.nanoTime() - startTime)/1000000);

	}

}