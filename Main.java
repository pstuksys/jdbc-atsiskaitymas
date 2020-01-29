package com.company;

import com.company.bazinis.Balsuotojai;
import com.company.bazinis.BalsuotojaiDAO;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Balsuotojai balsuotojai = new Balsuotojai("Petras","Petraitis","1985","Kauno","Lietuvis");
        Balsuotojai balsuotojai2 = new Balsuotojai(13,"Petras","Petraitis","1985","Kauno","Lietuvis");
        BalsuotojaiDAO.add(balsuotojai);
        BalsuotojaiDAO.searchByApygarda("%Kau%");
        BalsuotojaiDAO.deleteById(13);
        BalsuotojaiDAO.editById(balsuotojai2);
        BalsuotojaiDAO.balsuotojuGimimoMetai("1980");

    }
}
