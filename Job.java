/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package printjob;

/**
 *
 * @author sanja
 */
public class Job {
    public String title;
    public int NoOfPages;
    public Job(String title, int NoOfPages){
        this.title=title;
        this.NoOfPages=NoOfPages;
    }

    public String getTitle() {
        return title;
    }

    public int getNoOfPages() {
        return NoOfPages;
    }
    
    
}
