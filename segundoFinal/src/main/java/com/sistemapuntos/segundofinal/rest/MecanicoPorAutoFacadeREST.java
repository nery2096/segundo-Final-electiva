/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemapuntos.segundofinal.rest;

import com.sistemapuntos.segundofinal.DAO.MecanicoPorAutoDAO;
import com.sistemapuntos.segundofinal.modelo.MecanicoPorAuto;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
@Path("com.sistemapuntos.segundofinal.modelo.mecanicoporauto")
public class MecanicoPorAutoFacadeREST extends MecanicoPorAutoDAO<MecanicoPorAuto> {

    @PersistenceContext(unitName = "com.sistemapuntos_segundoFinal_war_v1PU")
    private EntityManager em;

    public MecanicoPorAutoFacadeREST() {
        super(MecanicoPorAuto.class);
    }

    @POST
    @Override
    @Consumes(MediaType.APPLICATION_JSON)
    public void create(MecanicoPorAuto entity) {
        Query q = getEntityManager().createQuery("select m.status from MecanicoStatus m where m.idMecanico=:id");
        q.setParameter("id",entity.getIdMecanico().getIdUsuario());
        String resultado = q.getSingleResult().toString();
        if ("L".equals(resultado) && entity.getIdMecanico().getIdPermisoUsuario().getTipoPermiso()==2){
            super.create(entity);
            System.out.println("Se anhadio correctamente el mecanico para analizar el auto");
        }else{
            System.out.println("Tiene que elegir un Mecanico Libre");
        }   
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void edit(MecanicoPorAuto entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public MecanicoPorAuto find(@PathParam("id") int id) {
        return super.find(id);
    }
    @GET
    @Path("/auto/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MecanicoPorAuto> find_mecanicos_auto(@PathParam("id") Integer id) {
        return super.find_mecanicos_auto(id);
    }
    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public List<MecanicoPorAuto> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<MecanicoPorAuto> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
