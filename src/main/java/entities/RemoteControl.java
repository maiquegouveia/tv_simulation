/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.util.Scanner;
/**
 *
 * @author Maique
 */
public class RemoteControl {
    int menuTvOption, choseChannel;
    int username, password;
    int mode;
    
    Scanner scan = new Scanner(System.in);
    
    public void Control1(Tv tv){
        do{
            System.out.println("\nTV " + tv.tvName + " - Remote Control");
            System.out.println("Status: " + StatusTv(tv.isOn) + " - Volume: " + tv.volume + " - Channel: " + tv.selectedChannel);
            System.out.println("\n1 - Turn on/off the TV");
            System.out.println("2 - Turn up TV volume");
            System.out.println("3 - Turn down TV volume");
            System.out.println("4 - Change Channel");
            System.out.println("5 - Change TV");
            System.out.println("\nChoose an option ->");
            menuTvOption = scan.nextInt();

            switch(menuTvOption){
                case 1 -> {
                    tv.TurnOnAndOffTv();
                    if(tv.isOn == true){
                        System.out.println("\nThe TV is on");
                    } else {
                        System.out.println("\nThe TV is off");
                    }
                }
                case 2 -> {
                    tv.TurnUpTvVolume();
                    if(tv.isOn == true){
                        System.out.println("\nThe volume is at " + tv.volume);
                    } else {
                        System.out.println("\nTurn on the TV first");
                    }
                }
                case 3 -> {
                    tv.TurnDownTvVolume();
                    if(tv.isOn == true){
                        System.out.println("\nThe volume is at " + tv.volume);
                    } else {
                        System.out.println("\nTurn on the TV first");
                    }
                }
                case 4 -> {
                    if(tv.isOn == true){
                        System.out.print("\nAvailable Channels " + tv.channels.toString() + ": ");
                        choseChannel = scan.nextInt();
                        if(tv.ChangeChannel(choseChannel)){
                            System.out.println("\nChanged to channel " + choseChannel);
                        } else {
                            System.out.println("\nChannel not available");
                        }
                    } else {
                        System.out.println("\nTurn on the TV first");
                    }
                }
                case 5 -> {}
                default -> System.out.println("\nInvalid option");
            }
        } while(menuTvOption != 5);
    }
    
    public void Control2(SmartTv tv){
        do{
            System.out.println("\nTV " + tv.tvName + " - Remote Control");
            System.out.println("Status: " + StatusTv(tv.isOn) + " - Volume: " + tv.volume + " - Channel: " + tv.selectedChannel + " - Connection: " + tv.CheckConnection() + " - Mode: " + GetMode(tv.CheckMode()));
            System.out.println("\n1 - Turn on/off the TV");
            System.out.println("2 - Turn up TV volume");
            System.out.println("3 - Turn down TV volume");
            System.out.println("4 - Change Channel");
            System.out.println("5 - Connect/Disconnect");
            System.out.println("6 - Select Mode");
            System.out.println("7 - Change Tv");
            System.out.println("\nChoose an option ->");
            menuTvOption = scan.nextInt();

            switch(menuTvOption){
                case 1 -> {
                    tv.TurnOnAndOffTv();
                    if(tv.isOn == true){
                        System.out.println("\nThe TV is on");
                    } else {
                        System.out.println("\nThe TV is off");
                    }
                }
                case 2 -> {
                    tv.TurnUpTvVolume();
                    if(tv.isOn == true){
                        System.out.println("\nThe volume is at " + tv.volume);
                    } else {
                        System.out.println("\nTurn on the TV first");
                    }
                }
                case 3 -> {
                    tv.TurnDownTvVolume();
                    if(tv.isOn == true){
                        System.out.println("\nThe volume is at " + tv.volume);
                    } else {
                        System.out.println("\nTurn on the TV first");
                    }
                }
                case 4 -> {
                    if(tv.isOn == true){
                        if(tv.CheckMode() == 1){
                            System.out.print("\nAvailable Channels " + tv.channels.toString() + ": ");
                            choseChannel = scan.nextInt();
                            if(tv.ChangeChannel(choseChannel)){
                                System.out.println("\nChanged to channel " + choseChannel);
                            } else {
                                System.out.println("\nChannel not available");
                            }    
                        } else {
                            System.out.println("\nChange to Tv mode first");
                        }
                        
                    } else {
                        System.out.println("\nTurn on the TV first");
                    }
                }
                case 5 -> {
                    if(tv.isOn == true){
                        if(tv.CheckConnection() == false){
                            System.out.println("\nLogin Panel\n");
                            System.out.print("Username: ");
                            username = scan.nextInt();
                            System.out.print("Password: ");
                            password = scan.nextInt();

                            tv.ConnectDisconnectSmart(username, password);
                            if(tv.CheckConnection() == true){
                                System.out.println("\nConnection made");
                            } else {
                                System.out.println("\nFailed to connect");
                            }
                        } else {
                            tv.ConnectDisconnectSmart(0, 0);
                        }    
                    } else {
                        System.out.println("\nTurn on the TV first");
                    }
                    
                }
                case 6 -> {
                    if(tv.isOn == true){
                        do{
                            System.out.println("\nMode\n");
                            System.out.println("1 - TV");
                            System.out.println("2 - Streaming");
                            System.out.println("\n Choose an option ->");
                            mode = scan.nextInt();    
                            switch (mode) {
                                case 1 -> tv.ChangeModeToTv();
                                case 2 -> {
                                    if(tv.CheckConnection()){
                                        tv.ChangeModeToStreaming();
                                    } else {
                                        System.out.println("\nNo connection");
                                    }
                                }
                                default -> System.out.println("\nInvalid option");
                            }
                        } while (mode != 1 && mode != 2);
                    } else {
                        System.out.println("\nTurn on the TV first");
                    }
                    
                    
                }
                case 7 -> {}
                default -> System.out.println("\nInvalid option");
            }
        } while(menuTvOption != 7);
    }

    public String StatusTv(Boolean isOn){
        if(isOn == true){
            return "On";
        } else {
            return "Off";
        }
    }
    
    public String GetMode(int mode){
        if(mode == 1){
            return "Tv";
        } else{
            return "Streaming";
        }
    }

}
