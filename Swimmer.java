package jainish;

public class Swimmer {

	private int competitor_ID;
	private int swimKidsLevel;
	private String parentName;
	private double breastStroke;
	private double frontCrawl;
	private double backCrawl;
	private double elementaryBackCrawl;

	public Swimmer(int competitor_ID, int swimKidsLevel, String parentName, double breastStroke, double frontCrawl,
			double backCrawl, double elementaryBackCrawl) {
		this.competitor_ID = competitor_ID;
		this.swimKidsLevel = swimKidsLevel;
		this.parentName = parentName;
		this.breastStroke = breastStroke;
		this.frontCrawl = frontCrawl;
		this.backCrawl = backCrawl;
		this.elementaryBackCrawl = elementaryBackCrawl;
	}

	public int getCompetitorID() {
		return competitor_ID;
	}

	public int getSwimKidsLevel() {
		return swimKidsLevel;
	}

	public String getParentName() {
		return parentName;
	}

	public double getBreastStroke() {
		return breastStroke;
	}

	public double getFrontCrawl() {
		return frontCrawl;
	}

	public double getBackCrawl() {
		return backCrawl;
	}

	public double getElementaryBackCrawl() {
		return elementaryBackCrawl;
	}

	public void setCompetitorID(int competitor_ID) {
		this.competitor_ID = competitor_ID;
	}

	public void setSwimKidsLevel(int swimKidsLevel) {
		this.swimKidsLevel = swimKidsLevel;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public void setBreastStroke(double breastStroke) {
		this.breastStroke = breastStroke;
	}

	public void setFrontCrawl(double frontCrawl) {
		this.frontCrawl = frontCrawl;
	}

	public void setBackCrawl(double backCrawl) {
		this.backCrawl = backCrawl;
	}

	public void setElementaryBackCrawl(double elementaryBackCrawl) {
		this.elementaryBackCrawl = elementaryBackCrawl;
	}

	public double getAverage() {
		return ((breastStroke + frontCrawl + backCrawl + elementaryBackCrawl) / 4);

	}
}
