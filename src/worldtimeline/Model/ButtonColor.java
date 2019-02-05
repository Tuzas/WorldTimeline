/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldtimeline.Model;

/**
 *
 * @author Alex
 */
public enum ButtonColor { 
    
    CORSAIRS("#00FF00"),CHINESE_PIRATES("#FF0000"),PIRATE_RADIO("#0000FF"), WRECKING_LAW("#FF00FF")
    ,WESTERN_PIRATES("#FF8000"),SOMALI_PIRATE("#8A3DBD"),BODY_SNATCHING("#000000"),HIGHWAY_MEN("#336600");

    private final String color; 
  
    public String getColor() 
    { 
        return this.color; 
    } 
  
    private ButtonColor(String color) 
    { 
        this.color = color; 
    }
}

