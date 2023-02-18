/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;

/**
 *
 * @author Maique
 */
public class SmartTv extends Tv {
    private int username = 123456;
    private int password = 987654;
    private int mode = 1;
    private boolean connection = false;
    
    public SmartTv(String tvName) {
        super(tvName);
    }
    
    public void ConnectDisconnectSmart(int username, int password){
        if(isOn == true && mode == 1 && connection == false){
            if(this.username == username && this.password == password){
                connection =  true; 
            }
        } else if(isOn == true && connection == true){
            connection = false;
            mode = 1;
        }
    }
    
    public void ChangeModeToTv(){
        if(isOn == true){
            mode = 1;
        }
    }
    
    public void ChangeModeToStreaming(){
        if(isOn == true){
            if(connection == true){
                mode = 2;
            }
        }
    }
    
    public void ChangeSmartLoginUsername(int username){
        if(isOn == true && connection == true){
            this.username = username;
        }
    }
    
    public void ChangeSmartLoginPassword(int password){
        if(isOn == true && connection == true){
            this.password = password;
        }
    }
    
    public Boolean CheckConnection(){
        return connection;
    }
    
    public Integer CheckMode(){
        return mode;
    }
    
    /**
     *
     */
    @Override
    public void TurnOnAndOffTv(){
        if(isOn == true){
            isOn = false;
            connection = false;
            mode = 1;
        } else {
            isOn = true;
        }
    }

    @Override
    public Boolean ChangeChannel(int choseChannel){
        if(isOn == true && mode == 1){
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
