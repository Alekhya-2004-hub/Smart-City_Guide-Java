import javax.swing.*;
import java.awt.*;
import java.util.*;

public class SmartCityGUI2 {

    static HashMap<String, ArrayList<String>> placesMap = new HashMap<>();
    static HashMap<String, ArrayList<String>> hospitalsMap = new HashMap<>();
    static HashMap<String, ArrayList<String>> restaurantsMap = new HashMap<>();

    static JTextArea outputArea;

    //  DATA (5 cities, 5 entries each)
    static {
        // Hyderabad
        placesMap.put("hyderabad", new ArrayList<>(Arrays.asList(
            "Charminar", "Golconda Fort", "Hussain Sagar", "Ramoji Film City", "Birla Mandir")));
        hospitalsMap.put("hyderabad", new ArrayList<>(Arrays.asList(
            "Apollo Hospital", "Yashoda Hospital", "Care Hospital", "KIMS Hospital", "Rainbow Hospital")));
        restaurantsMap.put("hyderabad", new ArrayList<>(Arrays.asList(
            "Paradise Biryani", "Bawarchi", "Shah Ghouse", "Cafe Bahar", "Chutneys")));

        // Vijayawada
        placesMap.put("vijayawada", new ArrayList<>(Arrays.asList(
            "Kanaka Durga Temple", "Prakasam Barrage", "Bhavani Island", "Undavalli Caves", "Rajiv Gandhi Park")));
        hospitalsMap.put("vijayawada", new ArrayList<>(Arrays.asList(
            "Ramesh Hospital", "Andhra Hospital", "Sentini Hospital", "Aayush Hospital", "Capital Hospital")));
        restaurantsMap.put("vijayawada", new ArrayList<>(Arrays.asList(
            "RR Durbar", "Sweet Magic", "Southern Spice", "Minerva Coffee Shop", "Food Republic")));

        // Bangalore
        placesMap.put("bangalore", new ArrayList<>(Arrays.asList(
            "Lalbagh", "Cubbon Park", "Bangalore Palace", "Bannerghatta Zoo", "ISKCON Temple")));
        hospitalsMap.put("bangalore", new ArrayList<>(Arrays.asList(
            "Manipal Hospital", "Fortis Hospital", "Narayana Health", "Columbia Asia", "Sakra Hospital")));
        restaurantsMap.put("bangalore", new ArrayList<>(Arrays.asList(
            "Empire Restaurant", "Meghana Foods", "Truffles", "Vidyarthi Bhavan", "Toit")));

        // Chennai
        placesMap.put("chennai", new ArrayList<>(Arrays.asList(
            "Marina Beach", "Kapaleeshwarar Temple", "Guindy Park", "Elliot's Beach", "Fort St. George")));
        hospitalsMap.put("chennai", new ArrayList<>(Arrays.asList(
            "Apollo Hospital", "MIOT Hospital", "Global Hospital", "Fortis Malar", "Sri Ramachandra Hospital")));
        restaurantsMap.put("chennai", new ArrayList<>(Arrays.asList(
            "Saravana Bhavan", "Anjappar", "Murugan Idli Shop", "Barbeque Nation", "Ponnusamy Hotel")));

        // Delhi
        placesMap.put("delhi", new ArrayList<>(Arrays.asList(
            "India Gate", "Red Fort", "Qutub Minar", "Lotus Temple", "Akshardham Temple")));
        hospitalsMap.put("delhi", new ArrayList<>(Arrays.asList(
            "AIIMS", "Fortis Hospital", "Max Hospital", "BLK Hospital", "Apollo Hospital")));
        restaurantsMap.put("delhi", new ArrayList<>(Arrays.asList(
            "Karim's", "Bukhara", "Saravana Bhavan", "Indian Accent", "Haldiram's")));
    }

    //  Show Category
    public static void showCategory(ArrayList<String> list, String name) {
        outputArea.setText(name + ":\n");

        if (list == null) {
            outputArea.append("No data available for this city.");
            return;
        }

        for (String item : list) {
            outputArea.append("- " + item + "\n");
        }
    }

    //  Search Function
    public static void search(String city, String keyword) {
        outputArea.setText("Search Results:\n");
        boolean found = false;

        ArrayList<String> pList = placesMap.get(city);
        ArrayList<String> hList = hospitalsMap.get(city);
        ArrayList<String> rList = restaurantsMap.get(city);

        if (pList != null) {
            for (String p : pList) {
                if (p.toLowerCase().contains(keyword.toLowerCase())) {
                    outputArea.append("Place: " + p + "\n");
                    found = true;
                }
            }
        }

        if (hList != null) {
            for (String h : hList) {
                if (h.toLowerCase().contains(keyword.toLowerCase())) {
                    outputArea.append("Hospital: " + h + "\n");
                    found = true;
                }
            }
        }

        if (rList != null) {
            for (String r : rList) {
                if (r.toLowerCase().contains(keyword.toLowerCase())) {
                    outputArea.append("Restaurant: " + r + "\n");
                    found = true;
                }
            }
        }

        if (!found) {
            outputArea.append("No results found.");
        }
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Smart City Guide");
        frame.setSize(600, 420);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        //  City Input
        JTextField cityField = new JTextField(10);
        panel.add(new JLabel("Enter City:"));
        panel.add(cityField);

        //  Buttons
        JButton placesBtn = new JButton("Places");
        JButton hospitalsBtn = new JButton("Hospitals");
        JButton restaurantsBtn = new JButton("Restaurants");

        panel.add(placesBtn);
        panel.add(hospitalsBtn);
        panel.add(restaurantsBtn);

                //  Output Area
        outputArea = new JTextArea(15, 50);
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);

        //  Button Actions
       placesBtn.addActionListener(e -> {
           String city = cityField.getText().toLowerCase();
            showCategory(placesMap.get(city), "Places");
       });

        hospitalsBtn.addActionListener(e -> {
            String city = cityField.getText().toLowerCase();
            showCategory(hospitalsMap.get(city), "Hospitals");
        });

        restaurantsBtn.addActionListener(e -> {
            String city = cityField.getText().toLowerCase();
            showCategory(restaurantsMap.get(city), "Restaurants");
        });
        frame.add(panel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}