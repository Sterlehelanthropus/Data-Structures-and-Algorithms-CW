/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package COMP5017CW2;

/**
 *
 * @author Joel
 */
public class StationInfo implements IStationInfo{
    private final String stationName;
    private final int xPos, yPos;
    public double gVal;
    
    public StationInfo(String stationName, int xPos, int yPos){
        this.stationName = stationName;
        this.xPos = xPos;
        this.yPos = yPos;
        gVal = 0;
    }
    
        /**
     * @return the name of the station
     */
    @Override
    public String getName(){
    return stationName;}

    /**
     * @return x position -- 0 <= getxPos() < 256
     */
    @Override
    public int getxPos(){
    return xPos;
    }

    /**
     * @return y position -- 0 <= getyPos() < 256
     */
    @Override
    public int getyPos(){
    return yPos;
    }
    
    
    
}
