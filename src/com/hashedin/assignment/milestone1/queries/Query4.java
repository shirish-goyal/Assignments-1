package com.hashedin.assignment.milestone1.queries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.hashedin.assignment.milestone1.Titles;

public class Query4 extends Query {

	private List<Titles> netfixTitlesList;

	public Query4(List<Titles> netfixTitlesList) {
		super();
		this.netfixTitlesList = netfixTitlesList;
	}

	public void execute() {
		System.out.println(
				"Query4: For each of the above, give an option to give a start date and end date. Take the input of date range and aggregate data based on field date_added​?");
		System.out.print("Enter type : ");
		String type = scanner.nextLine();
		System.out.print("Enter listed_in : ");
		String listedIn = scanner.nextLine();
		System.out.print("Enter country : ");
		String country = scanner.nextLine();
		System.out.print("Enter n : ");
		int n = scanner.nextInt();
		String fromDate = "";
		while (fromDate.isEmpty()) {
			System.out.print("Enter from Date(dd/MM/yyyy) : ");
			fromDate = scanner.nextLine();
		}
		String toDate = "";
		while (toDate.isEmpty()) {
			System.out.print("Enter to Date(dd/MM/yyyy) : ");
			toDate = scanner.nextLine();
		}

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date from = format.parse(fromDate);
			Date to = format.parse(toDate);

			System.out.println("\nList the first " + n + " records where type : " + type);
			long startTime = System.nanoTime();
			netfixTitlesList.stream()
					.filter(title -> (title.getType().equalsIgnoreCase(type)
							&& title.getDateAdded().compareTo(from) >= 0 && title.getDateAdded().compareTo(to) <= 0))
					.limit(n).collect(Collectors.toList()).forEach(System.out::println);
			System.out.println("Execution time in millis : " + (System.nanoTime() - startTime) / 1000000);

			System.out.println("\nList the first " + n + " records where listed_in : " + listedIn);
			startTime = System.nanoTime();
			netfixTitlesList.stream()
					.filter(title -> (title.getListedIn().toLowerCase().contains(listedIn.toLowerCase())
							&& title.getDateAdded().compareTo(from) >= 0 && title.getDateAdded().compareTo(to) <= 0))
					.limit(n).collect(Collectors.toList()).forEach(System.out::println);
			System.out.println("Execution time in millis : " + (System.nanoTime() - startTime) / 1000000);

			System.out.println("\nList the first " + n + " type: " + type + " where country : ​" + country);
			startTime = System.nanoTime();
			netfixTitlesList.stream()
					.filter(title -> (title.getType().equalsIgnoreCase(type)
							&& title.getCountry().equalsIgnoreCase(country) && title.getDateAdded().compareTo(from) >= 0
							&& title.getDateAdded().compareTo(to) <= 0))
					.limit(n).collect(Collectors.toList()).forEach(System.out::println);
			System.out.println("Execution time in millis : " + (System.nanoTime() - startTime) / 1000000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}