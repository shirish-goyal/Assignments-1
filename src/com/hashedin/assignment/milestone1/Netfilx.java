package com.hashedin.assignment.milestone1;

import java.util.ArrayList;
import java.util.List;

import com.hashedin.assignment.milestone1.queries.Query;
import com.hashedin.assignment.milestone1.queries.Query1;
import com.hashedin.assignment.milestone1.queries.Query2;
import com.hashedin.assignment.milestone1.queries.Query3;
import com.hashedin.assignment.milestone1.queries.Query4;

public class Netfilx {

	public static void main(String[] args) {
		List<Titles> netfixTitlesList = new ArrayList<Titles>();
		try {
			ReadCsv readObj = new ReadCsv();
			netfixTitlesList = readObj.readFile();

			Query q1 = new Query1(netfixTitlesList);
			q1.execute();
			Query q2 = new Query2(netfixTitlesList);
			q2.execute();
			Query q3 = new Query3(netfixTitlesList);
			q3.execute();
			Query q4 = new Query4(netfixTitlesList);
			q4.execute();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
