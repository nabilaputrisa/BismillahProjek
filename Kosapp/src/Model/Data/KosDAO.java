
package Model.Data;
import java.sql.*;
import java.util.*;

public class KosDAO {
    public void insert(ModelData data) {
       try {
            String query = "INSERT INTO data(namaAnak, noAnak, angkatan, noKamar, namaOrtu, noOrtu, asal) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, data.getNamaAnak());
            statement.setString(2, data.getNoAnak());
            statement.setInt(3, data.getAngkatan());
            statement.setInt(4, data.getNoKamar());
            statement.setString(5, data.getNamaOrtu());
            statement.setString(6, data.getNoOrtu());
            statement.setString(7, data.getAsal());
            statement.executeUpdate();
            statement.close();
            
        } catch (SQLException e) {
            System.out.println("Input Failed: " + e.getLocalizedMessage());
        } 
    }

    public void update(ModelData data) {
        try {
            String query = "UPDATE data SET  namaAnak =?, noAnak =? , angkatan = ?, noKamar = ?, namaOrtu = ?, noOrtu =?, asal =? WHERE IdData=?;";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, data.getNamaAnak());
            statement.setString(2, data.getNoAnak());
            statement.setInt(3, data.getAngkatan());
            statement.setInt(4, data.getNoKamar());
            statement.setString(5, data.getNamaOrtu());
            statement.setString(6, data.getNoOrtu());
            statement.setString(7, data.getAsal());
            statement.executeUpdate();
            statement.close();
            
        } catch (SQLException e) {
            System.out.println("update Failed! (" + e.getMessage() + ")");
        }
    }

    public void delete(int IdData) {
        try {
            String query = "DELETE FROM data WHERE IdData=?;";
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, IdData);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage()); 
        }
    }

    public List<ModelData> getAll() {
         List<ModelData> listData = null;

        try {
            listData = new ArrayList<>();
            Statement statement = Connector.Connect().createStatement();
            
            String query = "SELECT * FROM data";
            
            ResultSet resultSet = statement.executeQuery(query);
            
            while (resultSet.next()) {
              
                ModelData dt = new ModelData();
                dt.setId(resultSet.getInt("IdData"));
                dt.setNamaAnak(resultSet.getString("namaAnak"));
                dt.setNoAnak(resultSet.getString("noAnak"));
                dt.setAngkatan(resultSet.getInt("angkatan"));
                dt.setNoKamar(resultSet.getInt("noKamar"));
                dt.setNamaOrtu(resultSet.getString("namaOrtu"));
                dt.setNoOrtu(resultSet.getString("noOrtu"));
                dt.setAsal(resultSet.getString("asal"));
                
                listData.add(dt);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listData;
    }
}

