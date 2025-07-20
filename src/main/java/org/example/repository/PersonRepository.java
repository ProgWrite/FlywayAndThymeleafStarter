package org.example.repository;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@Repository
@RequiredArgsConstructor
public class PersonRepository {

    private final SessionFactory sessionFactory;

    @PostConstruct
    private void init(){
        log.info("Init person repository");
    }


    public Long save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        log.info("Saving person {}", person);
        return (Long) session.save(person);
    }


    public List<Person> findAll() {
        log.info("Find all persons");
        return sessionFactory.getCurrentSession()
                .createQuery("FROM Person", Person.class)
                .getResultList();
    }

}

