/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizardswindow;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author zhuan
 */
public class WizardsWindow {

    static Scanner sc=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i=0;i<10;i++) {
            processOneTower();
        }
        
    }

    private static void processOneTower() {
        HashMap<String,Character> rule=new HashMap();
        int width=sc.nextInt();
        int height=sc.nextInt();
        sc.nextLine();
        for (int i=0;i<4;i++) {
            String line=sc.nextLine();
            String[] sRule=line.split(" ");
            rule.put(sRule[0],sRule[1].charAt(0));
        }
        char[] bottomPattern=sc.nextLine().toCharArray();
        sc.nextLine();
        
        char[] pattern=new char[width];
        
        for (int i=0;i<height-1;i++) {
            for (int j=0;j<width;j++) {
                Character left=bottomPattern[(j+width-1)%width];
                Character right=bottomPattern[(j+1)%width];
                String key=left.toString()+right.toString();
                pattern[j]=rule.get(key);
            }
            for (int k=0;k<width;k++) {
                bottomPattern[k]=pattern[k];
            }
        }
        
        for (int i=0;i<width;i++) {
            System.out.print(pattern[i]);
        }
        System.out.println();
    }
    
}
