package com.hashedin.assignment.milestone1.queries;

import java.util.Scanner;

public abstract class Query {

	public Scanner scanner;
	
	public Query() {
		this.scanner = new Scanner(System.in);
	}
	
	public abstract void execute();

}
