package ru.r5am.classes;

import oracle.help.Help;
import oracle.help.library.helpset.HelpSet;
import oracle.help.library.helpset.HelpSetParseException;
import ru.r5am.controllers.MainController;

/**
 * Created by Aleksandr Jashhuk (R5AM) on 21.06.2015.
 */

public class OHJHelp {

    public void showHelp() throws HelpSetParseException {

        String helpsetFileName = "../../../../../resources/main/help/cwmacrocom.hs"; // HelpSet file
        String firstHelpTopic = "topic1";   		  // Topic for first showing

        Help myHelp = new Help();

        try {
            // Possible variant N1
             HelpSet myHelpSet = new HelpSet(MainController.class, helpsetFileName);

            // Possible variant N2
           // HelpSet myHelpSet = new HelpSet(getClass().getResource(helpsetFileName));

            myHelp.addBook(myHelpSet);
            myHelp.showNavigatorWindow();
            myHelp.showTopic(myHelpSet, firstHelpTopic);
        } catch (Exception ex) {
            System.out.println("Exception in showHelp (OHJ).");
            ex.printStackTrace();
        }
    }
}
