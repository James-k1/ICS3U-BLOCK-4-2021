package week9;

public class StepTracker {
    private int activeDays;
    private int numDays;
    private int totalSteps;
    private int stepsForActive;
    public StepTracker(int steps){
        stepsForActive = steps;
        
    }
    public int activeDays(){
        return activeDays;
    }
    public void addDailySteps(int steps){
        totalSteps+=steps;
        numDays++;
        if(steps>=stepsForActive)
        activeDays++;
        
    }
    

    public double averageSteps(int steps){
        return (double) totalSteps/numDays;

    }

    
}
