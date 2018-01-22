package com.jparrack.storedata;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by jeremiahparrack on 1/14/18.
 */

public class SharedRef {
    SharedPreferences SharedRef;

    public SharedRef(Context context){
        SharedRef = context.getSharedPreferences("myRef", Context.MODE_PRIVATE);

    }
    public void SaveData(String UserName, String Password){
        SharedPreferences.Editor editor = SharedRef.edit();
        editor.putString("UserName", UserName);
        editor.putString("Password", Password);
        editor.commit();
    }

    public String LoadData(){
        String FileContent = "UserName: " + SharedRef.getString("UserName", "No Name");
        FileContent += "Password: " + SharedRef.getString("Password", "No Password");
        return  FileContent;
    }
}