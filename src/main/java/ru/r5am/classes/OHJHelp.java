package ru.r5am.classes;

import oracle.help.Help;
import oracle.help.library.helpset.HelpSet;
import oracle.help.library.helpset.HelpSetParseException;

/**
 * @author  Created by Aleksandr Jashhuk (R5AM) on 21.06.2015.
 */

public class OHJHelp {

    Help myHelp = new Help();

    /**
     *
     * @throws HelpSetParseException
     *
     */
    public void showHelp() throws HelpSetParseException {

        String helpSetFileName = "/help/cwmacrocom.hs"; // HelpSet file
        String firstHelpTopic = "topic1";   		    // Topic for first showing

        Help.setHelpEncoding("UTF-8");
        try {

            HelpSet myHelpSet = new HelpSet(getClass().getResource(helpSetFileName));

            myHelp.addBook(myHelpSet);
            myHelp.showNavigatorWindow();
            myHelp.showTopic(myHelpSet, firstHelpTopic);
        } catch (Exception ex) {
            System.out.println("Exception in showHelp (OHJ).");
            ex.printStackTrace();
        }
    }


    public void disposeHelp() {
        myHelp.dispose();
    }
}
