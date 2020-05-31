package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Shift {
    private List<POS> activePOS;
    private List<Worker> workers;
    private List<Worker> shift_workers;
    private Manager manager;
    private List<Deal> deals;
    private float totalIncome;
    private Date date;

    static Shift shift;

    private Shift()
    {
        super();
    }

    public static Shift getShift(){
        if(shift==null)
            shift=new Shift();
        return shift;
    }


    public void add_new_worker(Worker new_worker)
    {
        workers.add(new_worker);
    }

    public void add_shift_worker (long id)
    {
        for(Worker w:workers)
        {
            if(w.getID()==id)
            {
                shift_workers.add(w);
            }
            /* else
            {
                print message to screen
            }*/
        }
    }

    public void remove_shift_worker(long id)
    {
        for(Worker w:shift_workers)
        {
            if(w.getID()==id)
            {
                shift_workers.remove(w);
            }
           /* else
            {
                print message to screen
            }*/
        }
    }

    public void add_deal (Deal new_deal)
    {
        deals.add(new_deal);
    }

    public void cancle_deal (Deal deal)
    {
        deals.remove(deal);
    }

    public void add_pos (POS new_pos)
    {
        activePOS.add(new_pos);
    }



}


