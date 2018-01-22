package com.jparrack.storedata;

/**
 * Created by jeremiahparrack on 1/15/18.
 */

public class AdapterItems {
    public  int ID;
    public  String UserName;
    public  String PassWord;
    //for news details
    AdapterItems( int ID, String userName,String passWord) {
        this.ID = ID;
        this.UserName = userName;
        this.PassWord = passWord;
    }
}
