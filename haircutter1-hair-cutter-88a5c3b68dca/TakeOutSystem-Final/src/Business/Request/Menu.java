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
public class Menu {
    private List<Dish> menuList;
    public Menu(){
        menuList = new ArrayList<Dish>();
    }

    public List<Dish> getMenuList() {
        return menuList;
    }

    public void setMenu(List<Dish> menu) {
        this.menuList = menu;
    }
    public Dish updateMenu(){
        Dish dish = new Dish();
        menuList.add(dish);
        return dish;
    }
    public void deleteDish(Dish dish)
    {
        menuList.remove(dish);
    }
}
