import databaseops.*;
import utilities.GUI;

public class Main {
    public static void main(String[] args){
        try {
            GUI.CreateGUI();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
