package utilities;
import databaseops.*;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class GUI {
    public static void CreateGUI()
    {
        /* Connect to Database */
        try {
            PostgreSQL_JDBC.ConnectDatabase();
        }
        catch(ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
        }

        /* Create JFrame can disconnect database */
        JFrame main_frame = new JFrame("Pets Shop");
        // Add window closing event
        main_frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    PostgreSQL_JDBC.ExitDatabase();
                    System.exit(0);
                }
                catch(SQLException exception)
                {
                    exception.printStackTrace();
                }
            }
        });
        main_frame.setSize(400, 400);


        main_frame.setVisible(true);
    }
}
