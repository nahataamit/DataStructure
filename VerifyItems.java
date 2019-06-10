package otherProblems;

import java.util.HashMap;
import java.util.List;

public class VerifyItems {
    public static int verifyItems(List<String> origItems, List<Float> origPrices, List<String> items, List<Float> prices) {
        // Write your code here
        HashMap<String,Float> inventory = createInventory(origItems,origPrices);

        int mismatch = 0;
        for(int i=0;i<items.size();i++){
            String item = items.get(i);
            Float price = prices.get(i);
            if(!price.equals(inventory.get(item))){
                mismatch++;
            }
        }

        return mismatch;
    }

    public static HashMap<String,Float> createInventory(List<String> origItems, List<Float> origPrices){
        HashMap<String, Float> inventory = new HashMap();

        for(int i=0;i<origItems.size();i++){
            inventory.put(origItems.get(i), origPrices.get(i));
        }

        return inventory;

    }
}
