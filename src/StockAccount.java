import org.json.simple.JSONObject;
import org.json.simple.JSONArray;

import java.util.Scanner;
class StockAccount{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Choice");
        System.out.println("1.Buy");
        System.out.println("2.Sell");
        int choice=scanner.nextInt();
        switch(choice){
            case 1:
            Buy();
            return;
            case 2:
            Sell();
        }
        scanner.close();
    }

    Buy(){
        int newBalanced;
        JSONParser Parser=new JSONParser();
        JSONObject FileData=(JSONObject)Parser.parse(new FileReader("CommercialDataProcessing.json"));
        JSONObject User=(JSONObject)FileData.get("User");
        JSONObject Company=(JSONObject)FileData.get("Company");
        System.out.println("Enter Company Name");
        String CompanyName;
        System.out.println("Enter Company Name");
        int NumberOfShare;
        if(CompanyName==Company.get("CompanyName" && User.get("Balance")>=NumberOfShare*Company.get("SharePrice"))){
            newBalanced=(double)User.get("Balance")-(double)NumberOfShare*(double)Company.get("SharePrice");
        }

    }
}