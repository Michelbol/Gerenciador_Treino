
package Aplicações;

import java.util.Calendar;
import static java.util.Calendar.DAY_OF_WEEK;


public class Teste {
    public static void main(String[] args) {
        
        Calendar c = Calendar.getInstance();
	System.out.println("Data/Hora atual: "+c.getTime());
		System.out.println("Ano: "+c.get(Calendar.YEAR));
		System.out.println("Mês: "+c.get(Calendar.MONTH));
		System.out.println("Dia do Mês: "+c.get(Calendar.DAY_OF_MONTH));
                System.out.println("Dia da Semana: " + c.get(Calendar.DAY_OF_WEEK));
                //teste git hub
    }
    
 }
