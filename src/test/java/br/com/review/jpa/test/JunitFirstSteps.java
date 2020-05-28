package br.com.review.jpa.test;


import org.junit.*;

public class JunitFirstSteps {

    @BeforeClass// tem que ser static
    public static void inicinadoTeste() {
        System.out.println("Roda 1 vez no inicio de todos testes");
    }

    @AfterClass// tem que ser static
    public static void fechandoTestes() {
        System.out.println("Roda 1 vez no final, após todos os testes sejam executados");
    }

    @Before
    public void inicinadoTesteUmPorUm() {
        System.out.println("Executado 1 vez antes de  cada @teste que foi criado");
    }

    @After
    public void fechandoTesteUmPorUm() {
        System.out.println("Executado 1 vez depois de  cada @teste que foi criado");
    }

    @Test
    public void testeUm() {
        System.out.println("1 teste");
    }


}
