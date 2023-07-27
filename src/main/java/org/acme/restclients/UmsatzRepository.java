package org.acme.restclients;

import io.quarkus.hibernate.reactive.panache.PanacheQuery;
import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import org.acme.models.Umsatz;

@ApplicationScoped
public class UmsatzRepository implements PanacheRepository<Umsatz> {

  // put your custom logic here as instance methods
  public Uni<Umsatz> findByName(String anbieter){
    return find("anbieter", anbieter).firstResult();
  }


  private static final String MODELL_ID = "modelId";

  public Uni<List<Umsatz>> listAll(
      final int pageIndex, final int pageSize, final String refQuery, final String ref) {
    final Page page = Page.of(pageIndex, pageSize);
    final Sort sort = Sort.by(MODELL_ID);
    final PanacheQuery<Umsatz> query =
        ref == null || ref.isBlank()
            ? findAll(sort).page(page)
            : find(refQuery, sort, ref).page(page);

    return query.list();
  }


}
