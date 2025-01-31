package repository;

import model.Phone;

import java.util.ArrayList;

public class PhoneRepository {
    private ArrayList<Phone> phoneList;
    private static PhoneRepository instance;

    private PhoneRepository() {
        phoneList = new ArrayList<>();

        phoneList.add(new Phone("Samsung Galaxy S24 Ultra", 19_999_000, 10, "Samsung"));
        phoneList.add(new Phone("Xiaomi 13 Pro", 14_999_000, 5, "Xiaomi"));
        phoneList.add(new Phone("Google Pixel 8 Pro", 14_999_000, 7, "Google"));
        phoneList.add(new Phone("OnePlus 11 5G", 10_999_000, 3, "OnePlus"));
    }

    public static PhoneRepository getInstance() {
        if (instance == null) {
            instance = new PhoneRepository();
        }
        return new PhoneRepository();
    }

    public void addPhone(Phone phone) {
        phoneList.add(phone);
    }

    public void removePhoneByIndex(int index) {
        phoneList.remove(index);
    }

    public Phone getPhoneByIndex(int index) {
        return phoneList.get(index);
    }

    public ArrayList<Phone> getPhoneList() {
        return phoneList;
    }
}
