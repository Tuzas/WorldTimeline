/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldtimeline.Model;

import javafx.scene.control.Button;

/**
 *
 * @author Alex
 */
public class HistoryButton extends Button{
    private int dateFrom, dateTo;
    private boolean clicked;
    private final String hex;
    public HistoryButton(int dateFrom, int dateTo, int xCoordinate, int yCoordinate, ButtonColor color) {
        hex = color.getColor();
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.setTranslateX(xCoordinate);
        this.setTranslateY(yCoordinate);
    }

    /**
     * @return the dateFrom
     */
    public int getDateFrom() {
        return dateFrom;
    }

    /**
     * @param dateFrom the dateFrom to set
     */
    public void setDateFrom(int dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * @return the dateTo
     */
    public int getDateTo() {
        return dateTo;
    }

    /**
     * @param dateTo the dateTo to set
     */
    public void setDateTo(int dateTo) {
        this.dateTo = dateTo;
    } 

    /**
     * @return the clicked
     */
    public boolean isClicked() {
        return clicked;
    }

    /**
     * @param clicked the clicked to set
     */
    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public String buttonNotClicked() {
        return "-fx-background-radius: 5em;  \n"
                + "-fx-min-width: 10px;  \n"
                + "-fx-min-height: 10px;  \n"
                + "-fx-max-width: 10px;  \n"
                + "-fx-max-height: 10px;"
                + "-fx-background-color: "+hex+";";
    }

    public String buttonClicked() {
        return "-fx-min-width: 10px;  \n"
                + "-fx-min-height: 10px;  \n"
                + "-fx-max-width: 10px;  \n"
                + "-fx-max-height: 10px;\n"
                + "-fx-background-color: "+hex+";"
                + "-fx-border-color: black;";
    }
}
