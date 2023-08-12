package com.example.javaeeproject;

import java.sql.Connection;
import java.util.List;
public class DatabaseConnectionTest {

    public static void main(String[] args) {
//        try {
//            Connection connection = UserConnection.getConnection();
//            System.out.println("Database Connection Successful!");
//        } catch (Exception e) {
//            System.out.println("Database Connection Failed: " + e.getMessage());
//        }
        userImpl metier= new userImpl();
        //test de la fonction  adduser
        user prod= metier.adduser(new user("ali","asma123@","ali123@gmail.com",126456));
        System.out.println(prod);
        //test de la fonction  getuserParMotsCle
        List<user> prods = metier.getuserParMotCle("ali");
        for (user p : prods)
            System.out.println(p);
        //test de la fonction selectALLUsers
        List<user> prodss = metier.selectALLUsers();

        System.out.println(prodss);
        user prode= metier.getuser("ali123@gmail.com","asma123@");
        System.out.println(prode);

    }

}


