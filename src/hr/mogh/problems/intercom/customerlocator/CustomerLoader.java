package hr.mogh.problems.intercom.customerlocator;

import sun.misc.IOUtils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Loads customer location data from file.
 * Created by vlado on 22.10.2015.
 */
public class CustomerLoader {

    public static List<Customer> loadCustomersFromFile(String fileName) throws FileNotFoundException, IOException {
        List<Customer> loadedCustomers = new ArrayList<>();

        Path p = Paths.get(fileName);
        InputStream inputStream = new FileInputStream(p.toString());
        String jsonTxt = IOUtils.readFully(inputStream, 0, true).toString();
        System.out.println(jsonTxt);
//         JSONObject json = new JSONObject(jsonTxt);
//        String a = json.getString("1000");
//        System.out.println(a);

        return loadedCustomers;
    }
}
