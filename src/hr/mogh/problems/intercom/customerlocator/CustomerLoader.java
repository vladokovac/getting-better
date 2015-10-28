package hr.mogh.problems.intercom.customerlocator;

import com.sun.media.sound.InvalidDataException;
import hr.mogh.datastructures.linkedlist.DoublyLinkedList;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;

/**
 * Loads customer location data from file.
 * Created by vlado on 22.10.2015.
 */
public class CustomerLoader {

    public static List<Customer> loadCustomersFromFile(String fileName) throws Exception {
        List<Customer> loadedCustomers = new ArrayList<>();
        BufferedReader bufferedReader;

        try {
            URL url = CustomerLoader.class.getResource(fileName);
            FileInputStream fileInputStream = new FileInputStream(url.getPath());
            bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
        } catch (FileNotFoundException fnfe) {
            throw new FileNotFoundException("Error while opening customer data.");
        }
        String customerData;
        try {
            while ((customerData = bufferedReader.readLine()) != null) {
                String[] splitDataArray = customerData.substring(1, customerData.length() - 1).split(",");
                Customer customer = new Customer();
                for (String data : splitDataArray) {
                    String[] splitData = data.split(":");
                    if (splitData.length == 2) {
                        String trimmedKey = splitData[0].toLowerCase().trim();
                        String dataKey = trimmedKey.substring(1, trimmedKey.length() - 1);
                        if (dataKey.equals("longitude")) {
                            String trimmedValue = splitData[1].trim();
                            String dataValue = trimmedValue.substring(1, trimmedValue.length() - 1);
                            double longitude = Double.valueOf(dataValue);
                            customer.setLongitude(longitude);
                        } else if (dataKey.equals("latitude")) {
                            String trimmedValue = splitData[1].trim();
                            String dataValue = trimmedValue.substring(1, trimmedValue.length() - 1);
                            double latitude = Double.valueOf(dataValue);
                            customer.setLatitude(latitude);
                        } else if (dataKey.equals("user_id")) {
                            String dataValue = splitData[1].trim();
                            int userId = Integer.valueOf(dataValue);
                            customer.setId(userId);
                        } else if (dataKey.equals("name")) {
                            String trimmedValue = splitData[1].trim();
                            String dataValue = trimmedValue.substring(1, trimmedValue.length() - 1);
                            customer.setName(dataValue);
                        }
                    } else {
                        throw new InvalidDataException();
                    }
                }
                loadedCustomers.add(customer);
            }
        }catch (InvalidDataException ife) {
            throw new InvalidDataException("Error while parsing customer data.");
        } catch (IOException ioe) {
            throw new IOException("Error while reading customer data.");
        } catch (ClassCastException cce) {
            throw new ClassCastException("Error while parsing customer data.");
        } catch (Exception exc) {
            throw new Exception("Error while loading customer data.");
        }
        return loadedCustomers;
    }
}
