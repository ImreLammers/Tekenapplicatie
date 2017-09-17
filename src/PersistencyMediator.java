import java.io.IOException;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by Imre on 7-9-2017.
 */
public interface PersistencyMediator {
    Drawing load(String nameDrawing) throws IOException, ClassNotFoundException, SQLException;
    boolean save(Drawing drawing) throws IOException, SQLException;
    boolean init(Properties props) throws SQLException, IOException;
}