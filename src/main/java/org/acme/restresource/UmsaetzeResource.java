package org.acme.restresource;


import io.quarkus.hibernate.reactive.panache.common.WithSession;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import org.acme.models.Umsatz;
import org.acme.restclients.UmsatzRepository;
import org.jboss.resteasy.reactive.RestPath;

@Path("/umsaetze")
@ApplicationScoped
public class UmsaetzeResource {


  @Inject
  UmsatzRepository umsatzRepository;

  @GET
  @ApplicationScoped
 // @Path("")
  @WithSession
  public Uni<List<Umsatz>> listAll() {
    return  umsatzRepository.listAll();

  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Uni<Umsatz> findById(@RestPath Long id) {
    return umsatzRepository.findById(id);

  }

//  @GET
//  @Path("/count")
//  @Produces(MediaType.APPLICATION_JSON)
//  @Consumes(MediaType.APPLICATION_JSON)
//  public Uni<Long> count() {
//    return umsatzRepository.count();
//
//  }
//
//
//  @DELETE
//  @Path("/all")
////  @Produces(MediaType.APPLICATION_JSON)
////  @Consumes(MediaType.APPLICATION_JSON)
//  public Uni<Long> deleteAll() {
//      return umsatzRepository.deleteAll();
//
//    }
//
//  @DELETE
//  @Path("/{id}")
////  @Produces(MediaType.APPLICATION_JSON)
////  @Consumes(MediaType.APPLICATION_JSON)
//  public Uni<Boolean> delete(Long id) {
//      return umsatzRepository.deleteById(id);
//    }


}
