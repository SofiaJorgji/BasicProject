package com.sqa.sj;

public class Bug {

	private int bugId;

	private String reporterName;

	private String bugName;

	private char bugCategory;

	private String operatingSystem;

	private String date;

	private String bugDetails;

	private double frequency;

	private boolean isActive;

	public Bug() {
		this.bugId = 1;
		this.bugName = "Cannot load Firefox";
		this.isActive = false;
		this.reporterName = "Sofia";
		this.bugCategory = 'I';
		this.date = "12/20/2016";
		this.frequency = 3;
		this.bugDetails = "Occurs on Windows too";
		this.operatingSystem = "MacOS";
	}

	public Bug(int bugId, String bugName) {
		this();
		this.bugId = bugId;
		this.bugName = bugName;
	}

	public Bug(int bugId, String bugName, boolean isActive, String reporterName) {
		this(bugId, bugName);
		this.isActive = isActive;
		this.reporterName = reporterName;
	}

	public Bug(int bugId, String bugName, boolean isActive, String reporterName, char bugCategory, String date,
			double frequency, String bugDetails, String operatingSystem) {
		this.bugId = bugId;
		this.bugName = bugName;
		this.isActive = isActive;
		this.reporterName = reporterName;
		this.bugCategory = bugCategory;
		this.date = date;
		this.frequency = frequency;
		this.bugDetails = bugDetails;
		this.operatingSystem = operatingSystem;
	}

	public void applyBugFix() {
		System.out.println("Applied bug.");
	}

	public void findSimilarBugs() {
		// TODO Auto-generated method stub
		System.out.println("Did not find similar bugs");
	}

	public char getBugCategory() {
		return this.bugCategory;
	}

	public String getBugDetails() {
		return this.bugDetails;
	}

	public int getBugId() {
		return this.bugId;
	}

	public String getBugName() {
		return this.bugName;
	}

	public String getDate() {
		return this.date;
	}

	public double getFrequency() {
		return this.frequency;
	}

	public String getOperatingSystem() {
		return this.operatingSystem;
	}

	public String getReporterName() {
		return this.reporterName;
	}

	public boolean isActive() {
		return this.isActive;
	}

	public void recreateBugActivity() {
		System.out.println("Recreated bug.");
		// TODO Auto-generated method stub
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setBugCategory(char bugCategory) {
		this.bugCategory = bugCategory;
	}

	public void setBugDetails(String bugDetails) {
		this.bugDetails = bugDetails;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public void setBugName(String bugName) {
		this.bugName = bugName;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setFrequency(double frequency) {
		this.frequency = frequency;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public void setReporterName(String reporterName) {
		this.reporterName = reporterName;
	}

	@Override
	public String toString() {
		return "BugTest [bugId=" + this.bugId + ", bugName=" + this.bugName + ", isActive=" + this.isActive
				+ ", reporterName=" + this.reporterName + ", bugCategory=" + this.bugCategory + ", date=" + this.date
				+ ", frequency=" + this.frequency + ", bugDetails=" + this.bugDetails + ", operatingSystem="
				+ this.operatingSystem + "]";
	}
}
