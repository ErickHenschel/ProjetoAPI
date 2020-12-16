/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.google.gson.Gson;
import entidades.Produto;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Erick
 */
@Path("produto")
public class ProdutoResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ProdutoResource
     */
    public ProdutoResource() {
    }

    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getProduto() {
        Gson gson = new Gson();
        return gson.toJson(DaoProduto.getAll());
    }
    
    @GET
    @Path("{categoria}")
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String getProdCat(@PathParam("categoria") String categoria_id) {
        Gson gson = new Gson();
        Produto pr = new Produto();
        pr = DaoProduto.getOne(Long.parseLong(categoria_id));
        return gson.toJson(pr);
    }


    @PUT
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public String putProduto(String content) {
        return "Produto alterado com sucesso!";
    }
    
    @POST
    @Consumes(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public boolean inserirProduto(String content) {
        Gson gson = new Gson();
        Produto pr = (Produto) gson.fromJson(content, Produto.class);
        return DaoProduto.persist(pr);
    }
}
