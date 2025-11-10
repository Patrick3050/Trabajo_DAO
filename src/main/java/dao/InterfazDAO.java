package dao;
import java.util.List;

public interface InterfazDAO {
    void addRegistro(Object obj) throws Exception;
    List<Object> getAllRegistros() throws Exception;
    Object getRegistroById(int id) throws Exception;
    void updateRegistro(Object obj) throws Exception;
    void deleteRegistro(int id) throws Exception;
}
