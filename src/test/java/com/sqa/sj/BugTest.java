package com.sqa.sj;

import org.testng.annotations.*;

public class BugTest {

	@Test
	public void BugTest() {
		Bug[] bugs = new Bug[4];
		bugs[0] = new Bug();
		bugs[1] = new Bug(2, "CSS issue");
		bugs[2] = new Bug(3, "Header disappears upon loading of page", true, "Sofia");
		bugs[3] = new Bug(4, "Database request fails", true, "Sofia", 'U', "12/12/2016", 2.2, "Same issue in FF",
				"MacOS");
		for (int i = 0; i < bugs.length; i++) {
			System.out.println("Person Details: " + (i + 1) + ": " + bugs[i]);
			bugs[i].recreateBugActivity();
			bugs[i].applyBugFix();
			bugs[i].findSimilarBugs();
		}
	}
}
