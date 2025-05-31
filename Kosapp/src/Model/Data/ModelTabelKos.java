package Model.Data;
import java.util.*;
import javax.swing.table.*;

public class ModelTabelKos extends AbstractTableModel {
    List<ModelData> daftarData;
    String kolom[] = {"ID", "Nama Anak", "No Anak", "Angkatan", "No Kamar","Nama Ortu", "No Ortu", "Asal"};

    public ModelTabelKos (List<ModelData> daftarData) {
        this.daftarData = daftarData;
    }

    @Override
    public int getRowCount() {
        return daftarData.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0 :
                return daftarData.get(rowIndex).getId();
            case 1:
                return daftarData.get(rowIndex).getNamaAnak();
            case 2:
                return daftarData.get(rowIndex).getNoAnak();
            case 3:
                return daftarData.get(rowIndex).getAngkatan();
            case 4:
                return daftarData.get(rowIndex).getNoKamar();
            case 5:
                return daftarData.get(rowIndex).getNamaOrtu();
            case 6:
                return daftarData.get(rowIndex).getNoOrtu();
            case 7:
                return daftarData.get(rowIndex).getAsal();
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}