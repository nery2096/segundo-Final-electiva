/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemapuntos.segundofinal.rest;


import com.sistemapuntos.segundofinal.DAO.FacturaDAO;
import com.sistemapuntos.segundofinal.modelo.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Adrián
 */
@Stateless
@Path("com.sistemapuntos.segundofinal.modelo.factura")
public class FacturaFacadeREST extends FacturaDAO<Factura> {

    @PersistenceContext(unitName = "com.sistemapuntos_segundoFinal_war_v1PU")
    private EntityManager em;

    public FacturaFacadeREST() {
        super(Factura.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(Factura entity) {
        super.create(entity);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(Factura entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces( MediaType.APPLICATION_JSON)
    public Factura find(@PathParam("id") Integer id) {
        return super.find(id);
    }
    @GET
    @Path("/persona/{id}")
    @Produces( MediaType.APPLICATION_JSON)
    @Override
    public List<Factura> find_facturas_persona(@PathParam("id") Integer id) {
        return super.find_facturas_persona(id);
    }
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<Factura> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Factura> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
