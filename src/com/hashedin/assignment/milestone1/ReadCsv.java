package com.hashedin.assignment.milestone1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsv {

	public List<Titles> readFile() {
		List<Titles> netfixTitlesList = new ArrayList<Titles>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(
					new FileReader("C:\\Users\\hp\\workspace-hashedin\\Assign-1\\resources\\netfilx_titles.csv"));
			String line = "";
			final String splitByRegex = ",(?=([^\"]*\"[^\"]*\")*[^\"]*$)";
			while ((line = br.readLine()) != null) {
				String[] data = line.split(splitByRegex);
				Titles title = new Titles(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(),
						data[4].trim(), data[5].trim(), data[6].trim(), data[7].trim(), data[8].trim(), data[9].trim(),
						data[10].trim(), data[11].trim());
				netfixTitlesList.add(title);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return netfixTitlesList;
	}
}
