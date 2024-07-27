package org.airtribe.com.service;

import org.airtribe.com.entities.Patron;

import java.util.ArrayList;
import java.util.List;

public class ManagePatron {
    static List<Patron> patrons;

    public ManagePatron(){
        patrons = new ArrayList<>();
    }

    public Patron addPatron(Patron patron){
        patrons.add(patron);
        return patron;
    }

    public Patron removePatron(Patron patron){
        patrons.remove(patron);
        return patron;
    }
}
