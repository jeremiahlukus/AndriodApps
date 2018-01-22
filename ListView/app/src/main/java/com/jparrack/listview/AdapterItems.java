package com.jparrack.listview;

/**
 * Created by jeremiahparrack on 1/14/18.
 */

public class AdapterItems {
    public String JobTitle;
    public String Description;
    public int ID;

    AdapterItems(int ID, String JobTitle, String Description) {
        this.ID = ID;
        this.JobTitle = JobTitle;
        this.Description = Description;

    }
 }
