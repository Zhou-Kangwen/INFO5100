/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Request;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ZHOU
 */
public class ModifyDishesRequestDirectory {
    private List<ModifyDishesRequest> modifyMenuRequestList;

    public ModifyDishesRequestDirectory() {
        modifyMenuRequestList = new ArrayList<ModifyDishesRequest>();
    }

    public List<ModifyDishesRequest> getModifyMenuRequestList() {
        return modifyMenuRequestList;
    }

    public void setModifyMenuRequestList(List<ModifyDishesRequest> modifyMenuRequestList) {
        this.modifyMenuRequestList = modifyMenuRequestList;
    }
    
    public ModifyDishesRequest createModifyDishesRequest(Dish dish){
        ModifyDishesRequest modifyDishesRequest = new ModifyDishesRequest(dish);
        modifyMenuRequestList.add(modifyDishesRequest);
        return modifyDishesRequest;
    }
}
