package org.acme.restclients;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import org.acme.models.Person;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person> {

  // put your custom logic here as instance methods

  public Uni<Person> findByName(String name){
    return find("name", name).firstResult();
  }

  public Uni<Long> deleteStefs(){
    return delete("name", "Stef");
  }
}
