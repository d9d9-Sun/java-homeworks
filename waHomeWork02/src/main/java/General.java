import myjdbc.ConnectorDB;

import java.util.ArrayList;
import java.util.List;

public class General {
    public static void main(String[] args) {
        ConnectorDB.createFitnessDB();
        ConnectorDB.createFitnessDBTables();
        ConnectorDB.findInstructorOver30();
        ConnectorDB.addNewTrainer();
        ConnectorDB.findInstructor();
    }
}
