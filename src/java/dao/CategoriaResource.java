/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.Gson;
import entidades.Categoria;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Erick
 */
@Path("categoria")
public class CategoriaResource {

    @Context
    private UriInfo context;

    public CategoriaResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getCategoria() {
        Gson gson = new Gson();
        return gson.toJson(DaoCategoria.getAll());
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public String putCategoria(String content) {
        return "Categoria alterada com sucesso!";
    }
    
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public boolean inserirCategoria(String content) {
        Gson gson = new Gson();
        Categoria ct = (Categoria) gson.fromJson(content, Categoria.class);
        return DaoCategoria.persist(ct);
    }
}
