package Lesson_13.Lesson_13_TelephoneDirectory;

import java.util.HashMap;

public class TelephoneDirectory {
    HashMap<String, String> telephoneDirectory;

    public TelephoneDirectory() {
        this.telephoneDirectory = new HashMap<>();
    }

    public void add(String second_name, String phone_number) {
        if (telephoneDirectory.containsKey(second_name)) {
            if (!telephoneDirectory.get(second_name).contains(phone_number)) {
                telephoneDirectory.put(second_name, telephoneDirectory.get(second_name) + ", " + phone_number);
            }
        } else {
            telephoneDirectory.put(second_name, phone_number);
        }
    }

    public void get(String second_name) {
        if (telephoneDirectory.containsKey(second_name)) {
            System.out.println(telephoneDirectory.get(second_name));
        } else {
            System.out.println("No such second name in the directory");
        }
    }
}
