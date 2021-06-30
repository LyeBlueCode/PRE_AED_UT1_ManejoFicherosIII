package pre_aed_ut1_manejoficherosiii;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author Leslie J. HL
 */
public class LogicCalendarCompact {
    public static void main(String[] args) {
       
    }

    String[] year = {"", "31", "28", "31", "30", "31", "30", "31", "31", "30", "31", "30", "31"};
    String[] week = {"L", "M", "X", "J", "V", "S", "D"};
    String[] nameMonth = {"\n_______ E N E R O _______\n",
        "\n_______ F E B R E R O _____\n",
        "\n_______ M A R Z O _______\n",
        "\n_______ A B R I L _______\n",
        "\n_______ M A Y O _______\n",
        "\n_______ J U N I O ______\n",
        "\n_______ J U L I O ______\n",
        "\n_______ A G O S T O ______\n",
        "\n_____ S E P T I E M B R E ____\n",
        "\n_____ O C T U B R E ____\n",
        "\n_____ N O V I E M B R E ____\n",
        "\n______ D I C I E M B R E ______\n"};

    public String posYear(String nuMonthYear) {
        String numString = "";

        for (int i = 0; i < year.length; i++) {
            if (nuMonthYear.equals(String.valueOf(i))) {
                numString = year[i];
            }
        }
        return numString;
    }

    public int posWeek(String letterWeek) {
        int letterPos = 0;

        for (int i = 0; i < week.length; i++) {
            if (letterWeek.equals(week[i])) {
                letterPos = i;
            }
        }
        return letterPos;
    }

    public String newCalendarExtended(String nuMonthYear, String letter) {
        int numDaysInMonth = Integer.parseInt(posYear(nuMonthYear));
        int posWeekk = posWeek(letter);
        String calend = nameMonth[Integer.parseInt(nuMonthYear) - 1];
        int j = posWeekk;
        for (int i = 1; i <= numDaysInMonth; i++) {
            if (j % 7 == 0) {
                j = 0;
            }
            calend += String.valueOf(i).concat(week[j]).concat(" ");
            j++;
        }
        return calend;

    }

    public void overwritedFilex(String nuMonthYear, String letter, File file) {
        // true to append  // false to overwrite. 
        String calend = newCalendarExtended(nuMonthYear, letter);
        try {
            FileWriter fW = new FileWriter(file,false);
            BufferedWriter bW = new BufferedWriter(fW);
            
            bW.write(calend + "\n --- Se ha sobreescrito ---\n");
            bW.close();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public void appendFilex(String nuMonthYear, String letter, File file) {
        // true to append  // false to overwrite. 
        String calend = newCalendarExtended(nuMonthYear, letter);
        try {
            FileWriter fW = new FileWriter(file,true);
            BufferedWriter bW = new BufferedWriter(fW);
            
            bW.write("\n --- Se anadido nuevo contenido ---\n"+ calend);
            bW.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    

    public void writeFilex(String nuMonthYear, String letter, File file) {
        
        String calend = newCalendarExtended(nuMonthYear, letter);

        try {
            FileWriter fW = new FileWriter(file);
            BufferedWriter bW = new BufferedWriter(fW);

            bW.write(calend);
            bW.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
