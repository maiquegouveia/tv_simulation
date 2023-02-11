/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import entities.Tv;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Tv[] tvList;
        int tvIndex;
        int tvOption;
        int menuTvOption;
        
        System.out.print("\nHow many TVs do you want to create? ");
        int tvAmount = scan.nextInt();
        
        tvList = new Tv[tvAmount];
        
        for(int i=0; i<tvAmount; i++){
            System.out.print("\nEnter the TV " + (i+1) + " name: ");
            String tvName = scan.next();
            
            tvList[i] = new Tv(tvName);
        }
        
        do{
            System.out.println("\nSelect the TV\n");
            for(int i=0; i<tvList.length; i++){
                System.out.println((i+1) + " - " + tvList[i].tvName + " - Status: " + tvList[i].StatusTV() + " - Volume: " + tvList[i].volume + " - Channel: " + tvList[i].selectedChannel);
            }
            System.out.println("0 - End");
            System.out.println("\nChoose an option ->");
            tvOption = scan.nextInt();
            tvIndex = tvOption - 1;
            if(tvOption == 0){
                System.out.println("\nProgram ended");
            } else if((tvOption > 0) && (tvOption <= tvList.length)){
                do{
                    System.out.println("\nTV " + tvList[tvIndex].tvName + " - Remote Control");
                    System.out.println("Status: " + tvList[tvIndex].StatusTV() + " - Volume: " + tvList[tvIndex].volume + " - Channel: " + tvList[tvIndex].selectedChannel);
                    System.out.println("\n1 - Turn on/off the TV");
                    System.out.println("2 - Turn up TV volume");
                    System.out.println("3 - Turn down TV volume");
                    System.out.println("4 - Change Channel");
                    System.out.println("5 - Change TV");
                    System.out.println("\nChoose an option ->");
                    menuTvOption = scan.nextInt();

                    switch(menuTvOption){
                        case 1 -> tvList[tvIndex].TurnOnAndOffTv();
                        case 2 -> tvList[tvIndex].TurnUpTvVolume();
                        case 3 -> tvList[tvIndex].TurnDownTvVolume();
                        case 4 -> tvList[tvIndex].ChangeChannel();
                        case 5 -> {}
                        default -> System.out.println("\nInvalid option");
                    }
                } while(menuTvOption != 5);            
            } else {
                System.out.println("\nInvalid option");
            }
        } while(tvOption != 0);
    }
}