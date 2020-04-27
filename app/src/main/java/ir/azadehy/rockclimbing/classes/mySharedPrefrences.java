package ir.azadehy.rockclimbing.classes;

import android.content.Context;
import android.content.SharedPreferences;

public class mySharedPrefrences {

    private  static mySharedPrefrences instance;
    private SharedPreferences sp;

    public static mySharedPrefrences getInstance(Context context)
    {
        if(instance==null)
            instance=new mySharedPrefrences(context);
        return instance;
    }

    private mySharedPrefrences(Context context)
    {
        sp=context.getSharedPreferences("myApp",0);
    }

    public void setLogin()
    {
        sp.edit().putBoolean("Login", true).apply();
    }

    public boolean getLogin()
    {
        return  sp.getBoolean("Login", false);
    }

    public void setname(String name)
    {
        sp.edit().putString("name",name).apply();
    }

    public String getname()
    {
        return sp.getString("name","");
    }

    public void setuser(String user)
    {
        sp.edit().putString("user",user).apply();
    }

    public String getuser()
    {
        return sp.getString("user","");
    }
}
