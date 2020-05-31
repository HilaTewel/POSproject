package model;

public class Manager extends Worker{

    public Manager(final String name, final int ID, final int password) {
        super(name, ID);
        this.password = password;
    }

    private int password;

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }

    /*public void view_daily_report ()
    {

    }*/
}
