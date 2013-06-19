---------------------------------
Readme - The Psychic Poker Player
---------------------------------
    
    This application was based in the following requirement described in the 
"problem.txt" file.

    A solution to solve this problem could be developed in several different 
ways, from a simple one method to a OOP design application. The implemented 
solution had the main objective to develop the best software possible within the 
available time (7 days). Thus, was taken in consideration that it was a test, 
giving some space to show design and programming knowledge.

    In conclusion, the development followed the principles:
    
    - Provides the Necessary Functionality to the requirement;
    - Object-oriented programming principles;
    - Extensibility;
    - Reusability;
    - Minimize complexity;
    - Ease Of Maintenance;
    - Well Documented;
    - Well Tested;

------------
Packing List
------------

    The sample includes the following files and directories:

    . [docs]: A directory containing the documentation files.
    . [src]: A directory containing the source code.
    . [test]: A directory containing the test code.
    . [readme.txt]: This file.
    . [games.txt]: Demo input file.
    . [problem.txt]: Enunciation of this solution.
    . [PsychicPoker.java]: Represents the Psychic Poker game.
    . [InputParser.java]: Responsible to deal with an input and coverts into a valid list of cards.
    . [Card.java]: Represents a Poker card. 
    . [HandType.java]: Represents the list all possible valid hands.
    . [PsychicPlayer.java]: Represents the poker player that is psychic.
    . [HandTypeEvaluator.java]: Represents a Utility class to verifies all the hand types.
    . [TestSuit.java: Responsible to run all unity tests for the PsychicPoker.
    . [TestUtil.java: Represents a Utility class to creates all valid cards.
    . [HandTypeTest.java]: Unity test for the HandType class.
    . [PsychicPlayerTest.java]: Unity test for the PsychicPlayer class.
    . [HandTypeEvaluatorTest.java]: Unity test for the HandTypeEvaluator class.    
    . [InputParserTest.java]: Unity test for the InputParser class.    
    . [tests.lauch]: Run file responsible to build and run all unity tests.
    . [poker.lauch]: Run file responsible to build and run the application.
    
-------------------------
Importing the Application
-------------------------

    The application was developed with the following technologies:
    
    . Eclipse Juno with the SDK 4.2.0;
    . JavaSE-1.6 (jre7);
    . JUnit v.4;

    To import the project into Eclipse project from the zipped archive file, 
follow these steps:

    1. In the Eclipse, go to the menu File, the click in the Import option;
    2. In the following dialog select the option General / Existing Projects into Workspace;
    3. Click the radio button next to Select archive file and click the Browse button;
    4. Find the hyves_techtest.zip file on your hard disk. Click Open to select it;
    5. The calculator project name will appear in the box 'Projects', already checked;
    6. Click Finish to perform the import;
    7. The project should now appear in the Project Explorer view;

    
-----------------------
Running the Application
-----------------------

    After importing the application, the files "tests.lauch" and "poker.lauch"
are responsible to Run to build and run all unity tests and the Psychic Poker
demo respectively.
    The Psychic Poker applications requires as a first argument the filename of 
the games input file.

    Usage: java PsychicPoker <filename>

    To run each application, simply click with the right mouse button in each 
file and select the option 'Run as' followed the application name.
    
