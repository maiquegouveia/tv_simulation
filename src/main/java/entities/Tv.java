/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.util.Scanner;
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
    
    Scanner scan = new Scanner(System.in);
    
    public void TurnOnAndOffTv(){
        if(isOn == true){
            isOn = false;
            System.out.println("\nThe TV is off");
        } else {
            isOn = true;
            System.out.println("\nThe TV is on");
        }
    }

    public void TurnUpTvVolume(){
        if(isOn == true){
            if(volume < 100){
                volume++;
                System.out.println("\nThe TV volume is at " + volume);
            } else {
                System.out.println("\nThe TV volume is at " + volume);
                System.out.println("Maximum volume");
            }            
        } else {
            System.out.println("\nTurn on the TV first");
        }
    }
    
    public void TurnDownTvVolume(){
        if(isOn == true){
            if(volume > 0){
                volume--;
                System.out.println("\n The TV volume is at " + volume);
            } else {
                System.out.println("\nThe TV volume is at " + volume);
                System.out.println("Minumum volume");
            }
        } else {
            System.out.println("\nTurn on the TV first");
        }
    }

    public String StatusTV(){
        if(isOn == true){
            return "On";
        } else {
            return "Off";
        }
    }

    public Boolean CheckChannel(int selectedChannel){
        return channels.contains(selectedChannel);
    }
    
    public void ChangeChannel(){
        if(isOn == true){
            System.out.print("\nAvailable Channels " + channels.toString() + ": ");
            int choseChannel = scan.nextInt();
            if(CheckChannel(choseChannel)){
                selectedChannel = choseChannel;
                System.out.println("\nChanged to channel " + choseChannel);
            } else {
                System.out.println("\nChannel not available");
            }            
        } else {
            System.out.println("\nTurn on the TV first");
        }
    }
}
