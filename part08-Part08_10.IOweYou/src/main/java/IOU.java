import java.util.HashMap;

public class IOU {

    private HashMap<String, Double> iou;

    public IOU() {

        this.iou = new HashMap<>();

    }

    public void setSum(String toWhom, double amount){


        double totalDebt = iou.getOrDefault(toWhom, 0.0);
        totalDebt += amount;
        this.iou.put(toWhom, totalDebt);

    }

    public double howMuchDoIOweTo(String toWhom){

        return this.iou.getOrDefault(toWhom, 0.0);
    }
}
