package jainish;

import java.util.*;
import java.io.*;
import java.lang.*;

public class CityFinals
{
public static ArrayList<String> competitor;
public static ArrayList<Double> BreastSroke;
public static ArrayList<Double> FrontCrawl;
public static ArrayList<Double> BackCrawl;
public static ArrayList<Double> ElementaryBackStroke;

public class CityFinals() //
competitor = new ArrayList<Integer>();
Parents = new ArrayList<String>();
SwimKidsLevel = new ArrayList<Integer>();
BreastSroke = new ArrayList<Double>();
FrontCrawl = new ArrayList<Double>();
BackCrawl = new ArrayList<Double>();
ElementaryBackStroke = new ArrayList<Integer>();


    public ArrayList inputcompetitor()
    {
         System.out.println();    
         System.out.println("Enter competitor ID: "); //Make sure this is consistent throughout the program
         Scanner in = new Scanner(System.in);
String name = in.next();
         competitor.add(name);
   System.out.println();
 return competitors; 
        } 
    public void inputSwimKidsLevel() {
        System.out.println("Enter the swim kids level of the competitor: ");
        int swimkidslevel = in.nextInt()
         SwimKidsLevel.add(swimkidslevel)
        
    public void inputParents() {
        System.out.println("Enter the parent name of the competitor: ");
        int parents = in.nextInt()
        parents.add(parents)
        
  public void inputBreastStroke() {
  System.out.println("Enter the time for competitor to finish breast stroke (in seconds): ");
   Scanner in = new Scanner(System.in);
  int breast = in.nextInt()
    BreastStroke.add(breaststroke)
 
public void inputFrontCrawl() {
System.out.print ("Enter the time for competitor to finish front crawl (in seconds): ");
Scanner in = new Scanner(System.in);
        int front = in.nextInt();
  } 
  public void inputBackCrawl() {
System.out.print ("Enter the time for competitor to finish back crawl (in seconds): ");
Scanner in = new Scanner(System.in);
        int  back= in.nextInt();
  } 
  public void inputElementaryBackStroke() {
System.out.print ("Enter the time for competitor to finish the elementary back crawl (in seconds): ");
Scanner in = new Scanner(System.in);
        int  back= in.nextInt();
        
 if (competitor.size() >= 2)
        {
          for (int i = 0; i < competitor.size(); i++)
          
       {
            try
                {
                    File f = new File (competitor.get(i) + ".txt");
                    
      if (!f.exists())

{
                        f.createNewFile();
                        BufferedWriter bw = new BufferedWriter(new FileWriter(f, true)); 
                        bw.write(String.valueOf(BreastStroke.get(i)));
                        bw.newLine();
                        bw.write(String.valueOf(FrontCrawl.get(i)));
                        bw.newLine();
                        bw.write(String.valueOf(BackCrawl.get(i)));
                        bw.newLine();
                        bw.write(String.valueOf(ElementaryBackStroke.get(i)));
                        bw.close();

        }
                catch (Exception e) 
                
              System.out.println("You have an error.");
                  e.printStackTrace();
                 } 
          }                  
           try
           {
               for (int i = 0; i < driver.size(); i++)
               {
        BufferedReader reader1 = new BufferedReader(new FileReader(driver.get(i) + ".txt"));
                    double bs = Double.parseDouble(reader1.readLine());     //the bs stands for breast stroke           
                    double fc = Double.parseDouble(reader1.readLine());     // the fc stands for front crawl
                    double bc = Double.parseDouble(reader1.readLine());     //the bc stands for back crawl
                    double ebs = Double.parseDouble(reader1.readLine())     //the ebs stands for elementary back stroke
                    
                    
            double average = ((bs) + (ebs) + (fc) + (bc))/4
              averagetime.add(linTotalTime);
               }
           }
           catch (Exception e)
           {
               System.out.println("You have an error. ");
               e.printStackTrace();              
           }
          finally
          {   
              
              ArrayList<String> competitor2 = new ArrayList<Integer>();
              ArrayList<Double> totaltimeaverage = new ArrayList<Double>();           
              competitor2.addAll(competitor);
              totaltimeaverage.addAll(totaltimeaverage);
         {
              if (totaltimeaverage.get(i) > max)
              
              max = totaltimeaverage.get(i);
              index = i;
              comepetitorName = driver2.get(i);
              
         }
                  
                  competitor.add(competitiorName);
                  totaltimeaverage.remove(index);
                  competitor2.remove(index);
              }
        System.out.println();
              System.out.println("With the times for the comepetitor, this is the given, this is the average time the competitor took for their 4 swim strokes:");
              
              System.out.println("Competitor:    Parents :             Swim Kids Level:       BreastStroke:    FrontCrawl:         BackCrawl:     ElementaryBackStroke: Average Total Time: ");
              
        }
              
                for (int i = 0; i < competitor.size(); i++)
                
                {
                    File file = new File (driver.get(i) + ".txt");
            
                    if (file.exists()) 
                    {
                        file.delete();
                    }                        
                }
          }
        }
        else 
        {
            if (competitor.size() == 0)
            {
                System.out.println("There is no competitor competiting as of right now.");   
            }
            else
            {
                System.out.println("There is only one competitor: " + competitor.get(0) + ". They win!"); 
            }         
        }
    }
    
    public void tryingtoOrderTheCompetitors
    
    
    List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);
    
    
    public void removeacompetitor()
    {
        Scanner in = new Scanner (System.in);
        System.out.print("What is the ID of the competitor you wish to remove? ");
        String name = in.nextLine();
{
            if (competitor.get(i).equals(name))
            {
                index = i;
                break;  
                
            }
        }
        
        if (index < 0)
        {
            System.out.println("That competitor is no longer in the race. ");
        }
        else
        {
            competitor.remove(index);
            Parent.remove(index);
            SwimKidsLevel.remove (index)
            BreastSroke.remove(index);
            FrontCrawl.remove(index);
            BackCrawl.remove(index);
            ElementaryBackStroke.remove(index);
            
            System.out.println("This competitor has been removed.");
        }
    }
    public void modifyCompetitorInformation()
    {
        Scanner in = new Scanner (System.in);
        int index = -1;
        
        System.out.print("What is the ID of the competitor that you would like to modify information for? ")
            
             String name = in.nextLine();
        System.out.println();  //You can check if the driver exists using follow: if (driver.get(i).equals(name))
        // {
       // index = i;
    // break;
    // }
    //   }
    // if (index < 0)
        }
        else
        {
            System.out.println("To change information of the competitor's parents, press A ");
            System.out.println("To change information of the competitor's swim kids level, press B");
            System.out.println("To change information of the competitor's breast stroke time, press C");
            System.out.println("To change information of the competitor's front crawl time, press D");
            System.out.println("To change information of the competitor's back crawl time, press E");
            System.out.println("To change information of the competitor's elementary back stroke time, press F");
            System.out.println();
            System.out.print("What is your choice? ");
            
            string choice = in.nextString();
            in.nextLine();
            
            if (choice == A)
             System.out.print("What is the updated parent information of the competitor? ");
                String brand = in.nextLine();
                Parents.set(index, parents); 
                
        }
            else if (choice == B)
            {
                System.out.print("What is the updated swim kids level of the competitor? ");
                integer skl = in.nextDouble();
                in.nextLine();
                swimkidslevel.set(index, skl);
                
            }
            else if (choice == C)
            {
                System.out.print("What is the updated breast stroke time of the competitor (in seconds)? ");
                double bs= in.nextDouble();
                in.nextLine();
                breaststroke.set(index, bs);
                
            }
            else if (choice == D)
            {
                System.out.print("What is the updated front crawl time of the competitor (in seconds)? ");
                double fc = in.nextDouble();
                in.nextLine();
                frontcrawl.set(index, fc);
                
            }
            else if (choice == E)
            {
                System.out.print("What is the updated back crawl time of the competitor (in seconds)? ");
                double  bc = in.nextDouble();
                in.nextLine();
                backcrawl.set(index, bc);                
            }
            else if (choice == F)
                System.out.print("What is the updated elementary back stroke time of the competitor (in seconds)? ");
                double  ebs = in.nextDouble();
                in.nextLine();
                elementarybackstroke.set(index, ebs); 
                
                System.out.println("Thank you, the competitor's information has been updated. ");
                
              
