package A_PERSONAL_PROJECT.Atm_Management_System.ATP_Project;

import java.io.IOException;
import java.util.HashMap;

public class ATM {

    public static void main(String[] args) throws IOException {

        OptionMenu optionMenu = new OptionMenu();

        introduction();
        optionMenu.mainMenu();

    }

    public static void introduction() {
        System.out.println("WELCOME TO THE ATM PROJECT MANAGEMENT SYSTEM !!!");
    }
}
  /*
        HashMap<Integer, Account> data = new HashMap<Integer, Account>();
        data.put(952141, new Account(952141, 191904, 1000, 5000));
        data.put(123, new Account(123, 123, 20000, 50000));


        data.forEach((key, value) -> System.out.println(key + " " + value));


        for (Integer number: data.keySet()) {
            String key = number.toString();
            String value = data.get(number).toString();
            System.out.println(key + "  " + value);
        }
       */