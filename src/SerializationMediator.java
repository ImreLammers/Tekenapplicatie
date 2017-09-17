import java.io.*;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Imre on 7-9-2017.
 */
public class SerializationMediator implements PersistencyMediator {
    Properties properties;

    public SerializationMediator() throws IOException {}

    @Override
    public Drawing load(String nameDrawing) throws IOException, ClassNotFoundException, SQLException {
        FileInputStream input = new FileInputStream("/Users/imrel/Documents/JCCTekeningen/" + nameDrawing);
        ObjectInputStream inputStream = new ObjectInputStream(input);
        return (Drawing) inputStream.readObject();
    }

    @Override
    public boolean save(Drawing drawing) throws IOException, SQLException {
        FileOutputStream output = new FileOutputStream("/Users/imrel/Documents/JCCTekeningen/test.ser");
        ObjectOutputStream outputStream = new ObjectOutputStream(output);
        outputStream.writeObject(drawing);
        return true;
    }

    @Override
    public boolean init(Properties properties) throws SQLException, IOException {
        return false;
    }
}