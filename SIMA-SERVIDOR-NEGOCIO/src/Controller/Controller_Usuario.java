package Controller;

import DAO.DAO_Usuario;
import Logic.Usuario;
import Model.Model_Usuario;
import java.util.List;

public class Controller_Usuario {

    private final Model_Usuario model = new Model_Usuario();
    DAO_Usuario dao = DAO_Usuario.getDAO();

    public void procedure(String opcion, String[] parameters) throws Exception {
        switch (opcion) {
            case "insert": {
                dao.insert(
                        model.verify_without_id(parameters)
                );
            }
            break;
            case "update": {
                dao.update(
                        model.verify_with_id(parameters)
                );
            }
            break;
            case "delete": {
                dao.delete(
                        model.verify_id(parameters)
                );
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
    }

    public Usuario function(String opcion, String[] parameters) throws Exception {
        Usuario object = null;
        switch (opcion) {
            case "query": {
                object = dao.query(
                        model.verify_id(parameters)
                );
            }
            break;
            case "login": {
                object = dao.login(
                        model.verify_login(parameters)
                );
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
        return object;
    }

    public List<Usuario> function(String opcion) throws Exception {
        List<Usuario> list = null;
        switch (opcion) {
            case "list": {
                list = dao.list();
            }
            break;
            default: {
                throw new Exception("Opción desconocida");
            }
        }
        return list;
    }
}