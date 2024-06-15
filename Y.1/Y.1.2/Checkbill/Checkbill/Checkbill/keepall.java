package Checkbill;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class keepall {
    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        keepall.address = address;
    }

    public static String getName() {
       return name;
    }

    public static void setName(String name) {
        keepall.name = name;
    }

    public static String getTel() {
        return tel;
    }

    public static void setTel(String tel) {
        keepall.tel = tel;
    }
    static private double totalmoney ;
    static HashMap <String, Integer> hashMap = new HashMap<>();
    static private String address ;
    static private String name;
    static private String tel;

    public  HashMap<String, Integer> getHashMap() {
        return hashMap;
    }

    // public void setHashMap(HashMap<String, Integer> hashMap) {
    //     this.hashMap = hashMap;
    // }
    public void setHashMap(String product, int price) {
		hashMap.put(product, price);

	}

    public double getMoney() {
        return totalmoney;
    }

    public void setMoney(double money) {
        totalmoney = money;
        // System.out.println(money);
        // printNames();
        
    }

    public void printNames() {
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " : " + value);
        }  

}
public void printNamesOnGUI(JFrame frame) {
    int yPosition = 140; 
    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
        String key = entry.getKey();
        Integer value = entry.getValue();
        JLabel productLabel = new JLabel(key + " : " + value);
        productLabel.setFont(new Font("TH Krub", Font.BOLD, 20));
        productLabel.setBounds(10, yPosition, 200, 21);
        frame.getContentPane().add(productLabel);
        yPosition += 30; 
    }
}
public void printdataperson(JFrame frame){
    
    JLabel productname = new JLabel(name);
    JLabel productaddress = new JLabel(address);
    JLabel producttel = new JLabel(tel);
    productname.setFont(new Font("TH Krub", Font.BOLD, 20));
    productname.setBounds(10, 20, 200, 21);
    productaddress.setFont(new Font("TH Krub", Font.BOLD, 20));
    productaddress.setBounds(10, 40, 200, 21);
    producttel.setFont(new Font("TH Krub", Font.BOLD, 20));
    producttel.setBounds(10, 50, 200, 21);
        frame.getContentPane().add(productname);
        frame.getContentPane().add(productaddress);
        frame.getContentPane().add(producttel);
       
}
}


    
    
