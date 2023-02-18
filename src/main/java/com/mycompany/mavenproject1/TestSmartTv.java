/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import entities.SmartTv;
import entities.Tv;
import entities.RemoteControl;
import java.util.Scanner;
/**
 *
 * @author Maique
 */
public class TestSmartTv {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        RemoteControl control = new RemoteControl();
        
        Tv[] normalTvList;
        SmartTv[] smartTvList;
        
        int tvAmount, menuOption;
        int tvOption;
        String tvName;

        System.out.print("\nHow many normal TVs would you like? ");
        tvAmount = scan.nextInt();
        
        normalTvList = new Tv[tvAmount];
        
        for(int i=0; i<tvAmount; i++){
            System.out.print("\nEnter the normal TV " + (i+1) + " name: ");
            tvName = scan.next();
            normalTvList[i] = new Tv(tvName);
        }

        System.out.print("\nHow many SmartTVs would you like? ");
        tvAmount = scan.nextInt();
        
        smartTvList = new SmartTv[tvAmount];
        
        for(int i=0; i<tvAmount; i++){
            System.out.print("\nEnter the SmartTV " + (i+1) + " name: ");
            tvName = scan.next();
            smartTvList[i] = new SmartTv(tvName);
        }
        
        do{
            System.out.println("\nMenu Tv Options");
            System.out.println("\n1 - TV");
            System.out.println("2 - SmartTV");
            System.out.println("3 - End");
            System.out.println("\nChoose an option ->");
            menuOption = scan.nextInt();
            
            switch (menuOption) {
                case 1 -> {
                    if(normalTvList.length > 0){
                        do{
                            System.out.println("\nSelect the TV\n");
                            for(int i=0; i<normalTvList.length; i++){
                                System.out.println((i+1) + " - " + normalTvList[i].tvName + " - Status: " + control.StatusTv(normalTvList[i].isOn) + " - Volume: " + normalTvList[i].volume + " - Channel: " + normalTvList[i].selectedChannel);
                            }
                            System.out.println("0 - End");
                            System.out.println("\nChoose an option ->");
                            tvOption = scan.nextInt();
                            
                            try{
                                control.Control1(normalTvList[tvOption-1]);
                            } catch (ArrayIndexOutOfBoundsException ignored){
                                if(tvOption !=0 ){
                                    System.out.println("\nInvalid option");    
                                }
                            }

                        } while(tvOption != 0);    
                    } else {
                        System.out.println("\nNo normal Tvs initialized");
                    }
                }
                case 2 -> {
                    if(smartTvList.length > 0){
                        do{
                            System.out.println("\nSelect the TV\n");
                            for(int i=0; i<smartTvList.length; i++){
                                System.out.println((i+1) + " - " + smartTvList[i].tvName + " - Status: " + control.StatusTv(smartTvList[i].isOn) + " - Volume: " + smartTvList[i].volume + " - Channel: " + smartTvList[i].selectedChannel + " - Connection: " + smartTvList[i].CheckConnection() + " - Mode: " + control.GetMode(smartTvList[i].CheckMode()));
                            }
                            System.out.println("0 - End");
                            System.out.println("\nChoose an option ->");
                            tvOption = scan.nextInt();

                            try{
                                control.Control2(smartTvList[tvOption-1]);  
                            } catch(ArrayIndexOutOfBoundsException ignored){
                                if(tvOption != 0){
                                    System.out.println("\nInvalid option");
                                }
                            }
                            
                        } while(tvOption != 0);
                    } else {
                        System.out.println("\nNo SmartTvs initialized");
                    }
                }
                case 3 -> System.out.println("\nProgram ended");
                default -> System.out.println("\nInvalid option");
            }
 
        } while(menuOption != 3);      
    } 
}
