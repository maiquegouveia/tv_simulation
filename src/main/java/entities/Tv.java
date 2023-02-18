/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author User
 */
public class Tv {
    public String tvName;
    public boolean isOn = false;
    public int volume = 0;
    public List<Integer> channels = new ArrayList<>();
    public int selectedChannel = 1;
    
    public Tv(String tvName){
        this.tvName = tvName;
        channels.add(1);
        channels.add(3);
        channels.add(5);
        channels.add(7);
        channels.add(11);
    }
     
    public void TurnOnAndOffTv(){
        isOn = isOn != true;
    }

    public void TurnUpTvVolume(){
        if(isOn == true){
            if(volume < 100){
                volume++;
            }          
        }
    }
    
    public void TurnDownTvVolume(){
        if(isOn == true){
            if(volume > 0){
                volume--;
            }
        }
    }

    public Boolean ChangeChannel(int choseChannel){
        if(isOn == true){
            if(channels.contains(choseChannel)){
                selectedChannel = choseChannel;
                return true;
            } else {
                return false;
            } 
        }
        return false;
    }
}

