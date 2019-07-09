package CricketData;
import CricketData.Observer;
import CricketData.CricketData;
class AverageScoreDisplay implements Observer 
{ 
    private float runRate; 
    private int predictedScore; 
  
    public void update(int runs, int wickets, 
                       float overs) 
    { 
        this.runRate =(float)runs/overs; 
        this.predictedScore = (int)(this.runRate * 50); 
        display(); 
    } 
  
    public void display() 
    { 
        System.out.println("\nAverage Score Display: \n"+"Run Rate: " + runRate +"\nPredictedScore: " +predictedScore); 
    } 
} 
  
class CurrentScoreDisplay implements Observer 
{ 
    private int runs, wickets; 
    private float overs; 
  
    public void update(int runs, int wickets, 
                       float overs) 
    { 
        this.runs = runs; 
        this.wickets = wickets; 
        this.overs = overs; 
        display(); 
    } 
  
    public void display() 
    { 
        System.out.println("\nCurrent Score Display:\n"
                           + "Runs: " + runs + 
                           "\nWickets:" + wickets + 
                           "\nOvers: " + overs ); 
    } 
} 
  

class TestObserver 
{ 
    public static void main(String args[]) 
    { 
        AverageScoreDisplay averageScoreDisplay = 
                          new AverageScoreDisplay(); 
        CurrentScoreDisplay currentScoreDisplay = 
                          new CurrentScoreDisplay(); 
  
        CricketData cricketData = new CricketData(); 
  
        cricketData.registerObserver(averageScoreDisplay); 
        cricketData.registerObserver(currentScoreDisplay); 
  
        cricketData.dataChanged(); 
  
        cricketData.unregisterObserver(averageScoreDisplay); 
  
        cricketData.dataChanged(); 
    } 
} 