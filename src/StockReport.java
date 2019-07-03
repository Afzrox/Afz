import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

class StockPortFolio{
    void CalculateStock(){
        long TotalStock=0,EachStockPrice=0;
        JSONParser Parser=new JSONParser();
        try{
            JSONObject Data=(JSONObject)Parser.parse(new FileReader("StockReport.json"));
            JSONArray Stock=(JSONArray)Data.get("Stock");
            for(int i=0;i<Stock.size();i++){
                JSONObject EachStock=(JSONObject)Stock.get(i);
                EachStockPrice=((long)EachStock.get("NumOfShare"))+((long)EachStock.get("SharePrice"));
                System.out.println("Share Name :"+EachStock.get("ShareName")+" Total Share Price is"+EachStockPrice);
                TotalStock=TotalStock+EachStockPrice;
            }
            System.out.println("Total Stock Price is :"+TotalStock);
        }
        catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }
}

public class StockReport extends StockPortFolio{
    public static void main(String[] args) throws Exception{
        StockReport stock=new StockReport();
        stock.getStockData();
        //Thread.sleep(1000);
        StockPortFolio stPortFolio=new StockPortFolio();
        stPortFolio.CalculateStock();
    }
    @SuppressWarnings("unchecked")
	void getStockData(){
        JSONObject stock=new JSONObject(); 
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter Number of Stocks");
        int NumOfStock=scanner.nextInt();
        for(int i=0;i<NumOfStock;i++){
            System.out.println("Enter ShareName");
            stock.put("ShareName",scanner.next());
            System.out.println("Enter Number of Share");
            stock.put("NumOfShare",scanner.nextInt());
            System.out.println("Enter Share Price");
            stock.put("SharePrice",scanner.nextInt());
            writeStockDetails(stock);
        }
        scanner.close();
    }
    @SuppressWarnings("unchecked")
	void writeStockDetails(JSONObject stock){
        JSONParser Parser=new JSONParser();
        JSONObject NewData=new JSONObject();
        try{
            JSONObject Data=(JSONObject)Parser.parse(new FileReader("StockReport.json"));
            JSONArray OldStock=(JSONArray)Data.get("Stock");
            OldStock.add(stock);
            NewData.put("Stock",OldStock);
            PrintWriter printWriter = null; // print writer to write to the file
            File file = new File("StockReport.json");
            printWriter = new PrintWriter(file);
            printWriter.write(NewData.toJSONString()); //writes data to the file
		    printWriter.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}