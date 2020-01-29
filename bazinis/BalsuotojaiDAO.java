package com.company.bazinis;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.*;
import java.util.ArrayList;

public class BalsuotojaiDAO {
    final static String URL = "jdbc:mysql://localhost/rinkimai?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    public static void add(Balsuotojai balsuotojai) {
        String query = "insert into balsuotojai (vardas, pavarde, gimimo_metai,apygarda,tautybe)" + "values(?,?,?,?,?)";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, balsuotojai.getVardas());
            preparedStatement.setString(2, balsuotojai.getPavarde());
            preparedStatement.setString(3, balsuotojai.getGimimo_metai());
            preparedStatement.setString(4,balsuotojai.getApygarda());
            preparedStatement.setString(5,balsuotojai.getTautybe());
            preparedStatement.executeUpdate();

            System.out.println("Pavyko iterpti nauja balsuotoja");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida kuriant nauja balsuotoja");
            e.printStackTrace();
        }
    }
    public static ArrayList<Balsuotojai> searchByApygarda(String apygarda) {
        String query2 = "select * from balsuotojai WHERE  apygarda LIKE '%Kaun%'";
        ArrayList<Balsuotojai> balsuotojai = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query2);
            ResultSet resultSet = preparedStatement.executeQuery(query2);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String vardas2 = resultSet.getString("vardas");
                String pavarde = resultSet.getString("pavarde");
                String gimimo_metai = resultSet.getString("gimimo_metai");
                String apygarde = resultSet.getString("apygarda");
                String tautybe = resultSet.getString("tautybe");
                balsuotojai.add(new Balsuotojai(id, vardas2, pavarde, gimimo_metai,apygarda,tautybe));
            }
            preparedStatement.close();
            connection.close();
            System.out.println("Pavyko atlikti paieska");
            System.out.println(balsuotojai);
        } catch (SQLException e) {
            System.out.println("Ivyko klaida atliekant paieska");
            e.printStackTrace();
        }
        return balsuotojai;
    }

    public static void editById(Balsuotojai balsuotojai) {
        String query = "update balsuotojai set vardas=?, pavarde=?, gimimo_metai=?,apygarda=?,tautybe=?"+
                "WHERE id=?";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, balsuotojai.getVardas());
            preparedStatement.setString(2, balsuotojai.getPavarde());
            preparedStatement.setString(3, balsuotojai.getGimimo_metai());
            preparedStatement.setString(4, balsuotojai.getApygarda());
            preparedStatement.setString(5,balsuotojai.getTautybe());
            preparedStatement.setInt(6,balsuotojai.getId());
            preparedStatement.executeUpdate();

            System.out.println("Pavyko redaguoti balsuotoja");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida redaguojant balsuotoja");
            e.printStackTrace();
        }
    }
    public static void deleteById(int id ) {
        String query = "delete FROM balsuotojai Where id=? ";

        try {
            Connection connection = DriverManager.getConnection(URL, "root", "");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            System.out.println("Pavyko istrinti balsuotoja");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida istrinant balsuotoja");
            e.printStackTrace();
        }
    }
    public static void balsuotojuGimimoMetai(String gimimo_metai){
        String query = "select COUNT(*) FROM `balsuotojai` WHERE gimimo_metai=? ";
        try{
            Connection connection = DriverManager.getConnection(URL,"root","");
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,gimimo_metai);
            preparedStatement.executeQuery();
            System.out.println("Balsuotojai gime n Metais:");
            System.out.println();


        }catch(SQLException e){
            System.out.println("Ivyko klaida skaiciuojant kiek balsuotoju yra gime N metais");
            e.printStackTrace();
        }
    }
}
