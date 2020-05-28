package br.com.review.jpa.test.manager;

import br.com.jpa.review.model.Produto;
import org.junit.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerGeneric {
    protected static EntityManagerFactory entityManagerFactory;

    protected EntityManager entityManager;


    @BeforeClass
    public static void setUpBeforeClass() {
        entityManagerFactory = Persistence.createEntityManagerFactory("JpaReview-PU");

    }

    @AfterClass
    public static void tearDownAfterClass() {
        entityManagerFactory.close();

    }

    @Before
    public void setup() {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    @After
    public void down() {
        entityManager.getTransaction().commit();
        entityManager.close();
    }


}
