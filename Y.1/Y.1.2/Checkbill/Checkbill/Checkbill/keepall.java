package Checkbill;
import java.awt.Font;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class keepall {
    static private double totalmoney ;
    static HashMap <String, Integer> hashMap = new HashMap<>();

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
}


    
    
