package jainish;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class jainish {

	static Scanner input = new Scanner(System.in);
	static int choice;
	static ArrayList<Swimmer> SwimmerList = new ArrayList<Swimmer>();

	public static void main(String args[]) throws IOException {
		System.out.println("Welcome to Jainish's Swimming Program");

		do {
			System.out.println("Please enter the choice number to execute, type -1 for menu, or 0 to exit");
			choice = input.nextInt();

			if (choice == 1) {
				enterSwimmer();
			} else if (choice == 2) {
				editSwimmer();
			} else if (choice == 3) {
				deleteSwimmer();
			} else if (choice == 4) {
				sort();
				writeToFile();
			} else if (choice == -1) {
				printMenu(); // choice -1 will display the menu
			} else if (choice == 0) {
				break; // choice 0 will exit the menu loop and program
			} else {
				System.out.println("Please enter a valid choice number, accepted values are 1-4, 0, and -1");
			} // a choice not defined will prompt the user to enter again

		} while (true); // infinite loop until user breaks with option 0
		System.out.println("Thanks for using the program. Bye!");
	}

	public static void printMenu() {
		System.out.println("Here are your options: ");
		System.out.println("1  - Enter a Swimmer's scores");
		System.out.println("2  - Edit a Swimmer's scores");
		System.out.println("3  - Delete a Swimmer");
		System.out.println("4  - Sort and write the swimmer's rankings to file");
	}

	public static void enterSwimmer() {

		System.out.println("Please enter the swimmer's competitor ID: ");
		int ID = input.nextInt();
		System.out.println("Please enter the swimmer's level: ");
		int level = input.nextInt();
		System.out.println("Please enter the swimmer's parent's name: ");
		input.nextLine();
		String parentName = input.nextLine();
		System.out.println("Please enter the swimmer's breast stroke time: ");
		double breastStroke = input.nextDouble();
		System.out.println("Please enter the swimmer's front crawl time: ");
		double frontCrawl = input.nextDouble();
		System.out.println("Please enter the swimmer's back crawl time: ");
		double backCrawl = input.nextDouble();
		System.out.println("Please enter the swimmer's elementart back crawl time: ");
		double elementaryBackCrawl = input.nextDouble();

		SwimmerList.add(new Swimmer(ID, level, parentName, breastStroke, frontCrawl, backCrawl, elementaryBackCrawl));
	}

	public static void editSwimmer() {
		System.out.println("Please enter the swimmer's competitor ID you want to edit: ");
		int searchID = input.nextInt();
		for (int i = 0; i < SwimmerList.size(); i++) {
			if (SwimmerList.get(i).getCompetitorID() == searchID) {
				do {
					System.out.println("Please enter the choice number to edit, type -1 for menu, or 0 to exit");
					choice = input.nextInt();

					if (choice == 1) {
						System.out.println("Editing swimmer level - enter a new level");
						SwimmerList.get(i).setSwimKidsLevel(input.nextInt());
					} else if (choice == 2) {
						System.out.println("Editing parent name - enter a new name");
						input.nextLine();
						SwimmerList.get(i).setParentName(input.nextLine());
					} else if (choice == 3) {
						System.out.println("Editing breast stroke time - enter a new time");
						SwimmerList.get(i).setBreastStroke(input.nextDouble());

					} else if (choice == 4) {
						System.out.println("Editing front crawl time - enter a new time");
						SwimmerList.get(i).setFrontCrawl(input.nextDouble());

					} else if (choice == 5) {
						System.out.println("Editing back crawl time - enter a new time");
						SwimmerList.get(i).setBackCrawl(input.nextDouble());

					} else if (choice == 6) {
						System.out.println("Editing elementary back crawl time - enter a new time");
						SwimmerList.get(i).setElementaryBackCrawl(input.nextDouble());

					} else if (choice == -1) {
						System.out.println("Here are your options: ");
						System.out.println("1  - Edit swimmer level");
						System.out.println("2  - Edit the parent's name");
						System.out.println("3  - Edit the swimmer's breast stroke time");
						System.out.println("4  - Edit the swimmer's front crawl time");
						System.out.println("5  - Edit the swimmer's back crawl time");
						System.out.println("6  - Edit the swimmer's elementary back crawl time");

					} else if (choice == 0) {
						break;
					} else {
						System.out.println("Please enter a valid choice number, accepted values are 1-4, 0, and -1");
					}
				} while (true);
				break;
			} else if (i == SwimmerList.size() - 1) {
				System.out.println("Sorry that ID does not exist");
			}
		}

	}

	public static void deleteSwimmer() {
		System.out.println("Please enter the swimmer's competitor ID you want to delete: ");
		int searchID = input.nextInt();
		for (int i = 0; i < SwimmerList.size(); i++) {
			if (SwimmerList.get(i).getCompetitorID() == searchID) {
				SwimmerList.remove(i);
				System.out.println("Swimmer with ID " + searchID + " Deleted");
			} else if (i == SwimmerList.size() - 1) {
				System.out.println("Sorry that ID does not exist");
			}

		}
	}

	public static void sort() {
		Swimmer temp;
		boolean swap;
		int counter = 0;
		do {
			swap = false;
			for (int i = 1; i < (SwimmerList.size() - counter); i++) {
				if (SwimmerList.get(i - 1).getAverage() > SwimmerList.get(i).getAverage()) {
					temp = SwimmerList.get(i - 1);
					SwimmerList.set(i - 1, SwimmerList.get(i));
					SwimmerList.set(i, temp);
					swap = true;
				}
			}
			counter++;
		} while (swap);
	}

	public static void writeToFile() throws IOException {
		BufferedWriter output = null;
		output = new BufferedWriter(new FileWriter("SwimmerRankings.txt"));

		for (int i = 0; i < SwimmerList.size(); i++) {
			output.write("Place: " + (i + 1) + " ID: " + SwimmerList.get(i).getCompetitorID() + " Average Time: "
					+ SwimmerList.get(i).getAverage());
			output.newLine();
		}
		output.flush();
		output.close();
	}
}
