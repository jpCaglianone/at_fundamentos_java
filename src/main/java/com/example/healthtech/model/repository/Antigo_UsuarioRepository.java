package com.example.healthtech.model.repository;

import com.example.healthtech.model.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class Antigo_UsuarioRepository {
    private static Map<Integer, Usuario> usuarios = new HashMap<Integer, Usuario>();
    private static Integer chavePrimaria = 1;

    public static boolean incluirUsuario (Usuario usuario) {
        usuario.setId(chavePrimaria);
        try{
            usuarios.put(chavePrimaria, usuario);
            chavePrimaria ++;
            return true;
        }catch (Exception e) {
            return false;
        }
    }
    public static void excluirUsuario (Integer id){
        usuarios.remove(id);
    }
    public static Collection<Usuario> listaUsuarios(){

        return usuarios.values();
    }

    public static boolean existeUsuario() {
        if (usuarios.size()==0){
            return false;
        }
        else{
            return true;
        }
    }
    public static Usuario validacao (String email, String senha){
        for(int i = 1; i <= usuarios.size(); i++){
            String auxEmail = usuarios.get(i).getEmail();
           if(auxEmail.equals(email)){
              String auxSenha = usuarios.get(i).getSenha();
              if(auxSenha.equals(senha)){
                  return usuarios.get(i);
              }
            }
        }
        return null;
    }

    public static Collection<Usuario> obterLista(){

        return usuarios.values();
    }

    public static Integer getChavePrimaria() {
        return chavePrimaria;
    }
}
