package factory;

import pojo.UsuarioPojo;

public class UsuarioDataFactory {
    public static UsuarioPojo criarUsuario(){
        UsuarioPojo usuario = new UsuarioPojo();

        usuario.setName("Fernanda");
        usuario.setJob("Analista de Testes (QA) Sênior - Datum-GetNet");

        return usuario;
    }
}
