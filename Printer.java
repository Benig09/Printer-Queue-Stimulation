package printjob;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Printer {
    Queue<Job> q = new LinkedList<>();
    int TotalPages=0;
    int NoOfJobs=0;
    float Totaltime;
        
    public static void main(String args[]) throws IOException{
        Printer print=new Printer();
        print.ReadFromFile();
        print.printJob();
    }
    
    // Method of Reading the files and take title and Pages from each line then call the add job method
    public void ReadFromFile() throws FileNotFoundException, IOException{
        Random rand=new Random();       //Get the random decimal number for time
         File F=new File("C:\\Users\\sanja\\OneDrive\\Desktop\\PrinterTask.txt");   //get the file address
        FileReader fr=new FileReader(F);
        BufferedReader br=new BufferedReader(fr);       // for read the file
        String line=br.readLine();                      // get each line in file
        while(line!=null){                              // loop each line or each task until all line finish in file
            String title="";
            int NoOfPages=0;
            String[] wordsinLine=line.split(" ");       // put each word in wordsinLine Array, from current line
            if(wordsinLine[0].equals("Add")){           // if first word is Add in current line
              for(int i=1;i<wordsinLine.length-1;i++){  // get all words from current line except last word(pages) and first word(Add)
                  title+=wordsinLine[i]+" ";            // put those all words in title
              }
              NoOfPages=Integer.parseInt(wordsinLine[wordsinLine.length-1]);    // get last word only from current line
              this.addJobs(title, NoOfPages);           // call the addJob method with title and No of pages of current line
              NoOfJobs++;                               // increase the number of job until the line finish in file - line mean task
              TotalPages+=NoOfPages;                    // increase the number of pages ...
              Totaltime+=rand.nextFloat()*(2-1)+1;      // put each random time of current task or current line on totaltime
            }                                           // finishing loop
            line=br.readLine();
        }
    }    
    
    //method of call the job class object and add the each job in queue linkedlist
    public void addJobs(String title, int NoOfPages){
        Job job=new Job(title,NoOfPages);           //call the object of Job class
        q.add(job);                                 // add each job in queue linkedlist
    }
    
    // method of printing the every job from queue linkedlist and total time, total jobs
    public void printJob(){
        for(Job job:q){                             // print all job from queue linkedlist 
            System.out.println("Printing: "+job.title);
            System.out.println("Number Of Pages: "+job.NoOfPages);
            System.out.println();
        }
        System.out.println("Print Summary");
        System.out.print(NoOfJobs+" Jobs and "+TotalPages+" pages printed in ");
        System.out.printf("%.2f%s",Totaltime," minutes.");
     }
    

}
