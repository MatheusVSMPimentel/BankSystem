/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.util.Date;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class

public class Print {
    /*
    A classe print realiza todos os prints da tela tornado uma interface amigavel
    ao usuario, e economizando linhas de codigos void
    */
    
    public void menu(){
        System.out.println(" ------------------------------------------------------------------------");
        System.out.println("|  _____      _         _                            _           _       |\n" +
"| / ____|    (_)       | |                          (_)         | |      |\n" +
"|| (___   ___ _  __ _  | |__   ___ _ __ ___   __   ___ _ __   __| | ___  |\n" +
"| \\___ \\ / _ \\ |/ _` | | '_ \\ / _ \\ '_ ` _ \\  \\ \\ / / | '_ \\ / _` |/ _ \\ |\n" +
"| ____) |  __/ | (_| | | |_) |  __/ | | | | |  \\ V /| | | | | (_| | (_) ||\n" +
"||_____/ \\___| |\\__,_| |_.__/ \\___|_| |_| |_|   \\_/ |_|_| |_|\\__,_|\\___/ |\n" +
"|           _/ |                                                         |\n" +
"|          |__/                                                          |");
        
        
        System.out.println("| ____          _   _  _____ ____     _____ ______ _   _          _____  |\n" +
"||  _ \\   /\\   | \\ | |/ ____/ __ \\   / ____|  ____| \\ | |   /\\   |_   _| |\n" +
"|| |_) | /  \\  |  \\| | |   | |  | | | (___ | |__  |  \\| |  /  \\    | |   |\n" +
"||  _ < / /\\ \\ | . ` | |   | |  | |  \\___ \\|  __| | . ` | / /\\ \\   | |   |\n" +
"|| |_) / ____ \\| |\\  | |___| |__| |  ____) | |____| |\\  |/ ____ \\ _| |_  |\n" +
"||____/_/    \\_\\_| \\_|\\_____\\____/  |_____/|______|_| \\_/_/    \\_\\_____| |\n" +
"|                                                                        |\n" +
"|                                                                        |");
        System.out.println("|------------------------------------------------------------------------|");
        System.out.println("|                                 Digite                                 |\n" +
                           "|          1 operação                                2 operação          |\n" +
                           "|             com                                        sem             |\n" +
                           "|            cartão                                     cartão           |\n" +
                           "|                                                                        |\n" +                
                           " ------------------------------------------------------------------------ ");
    
    }
public void comcartao(){
        System.out.println("|------------------------------------------------------------------------|");
        System.out.println("|                                 Selecione                              |\n" +
                           "|                                                                        |\n" +
                           "|      1 Saque                     2 Saldo             3 Transferencia   |\n" +
                           "|                                                                        |\n" +
                           "|                                                                        |\n" +                
                           " ------------------------------------------------------------------------ ");
}    
public void semcartao(){
        System.out.println(" ------------------------------------------------------------------------");
        System.out.println("|                                                                        |\n" +
                           "|                                 Depositos                               |\n" +
                           "|                                                                        |\n" +
                           " ------------------------------------------------------------------------ ");
}
public void saldo(){
        System.out.println(" ------------------------------------------------------------------------");
        System.out.println("|                                                                        |\n" +
                           "|                                   Saldo                                |\n" +
                           "|                                                                        |\n" +
                           " ------------------------------------------------------------------------ ");
}

public void saque(){
        System.out.println(" ------------------------------------------------------------------------");
        System.out.println("|                                                                        |\n" +
                           "|                                   Saque                                |\n" +
                           "|                                                                        |\n" +
                           " ------------------------------------------------------------------------ ");
}

public void deposito(){
        System.out.println(" ------------------------------------------------------------------------");
        System.out.println("|                                 Selecione                              |\n" +
                           "|                                                                        |\n" +
                           "|        1 Deposito                                     2 Voltar         |\n" +
                           "|                                                                        |\n" +
                           "|                                                                        |\n" +                
                           " ------------------------------------------------------------------------ ");} 

public void transferencia(){
        System.out.println(" ------------------------------------------------------------------------");
        System.out.println("|                                 Selecione                              |\n" +
                           "|                                                                        |\n" +
                           "|        1 Tranferencia                                 2 Voltar         |\n" +
                           "|                                                                        |\n" +
                           "|                                                                        |\n" +                
                           " ------------------------------------------------------------------------ ");} 


public void bemvindo(String nome,String sobrenome){
        System.out.println("Seja bem vindo "+ nome +" "+ sobrenome + ai()); 
        }

public String ai(){
    /*
    A função ai() estabelece a data do sistema e faz uma verificação inteligente
    do horario para fornecer uma saudação habitual de horario, relativo ao hora-
    rio atual.
    */
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter horas = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter ai = DateTimeFormatter.ofPattern("HH");
    String aie = myDateObj.format(ai);
    String formattedDate = myDateObj.format(horas);
    int test = Integer.valueOf(aie);
    if (test >= 0 && test <= 4){
       
        return " e Boa noite são:  " + formattedDate;
    }
    else if (test >= 5 && test < 14){
       
        return " e Bom dia são:  " + formattedDate;
    }
    else if (test >= 14 && test < 18){
       
        return " e Boa tarde são:  " + formattedDate;
    }
    else if (test >= 18 && test < 24){
       
        return " e Boa noite são:  " + formattedDate;
    }
    
    return formattedDate;
}


}
    
    
    
    

