package pe.edu.i202220224.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220224.entity.City;
import pe.edu.i202220224.entity.Country;
import pe.edu.i202220224.entity.CountryLanguage;

import java.util.Arrays;

public class JPAPersist {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager en = emf.createEntityManager();


        /**
         * YO TENDRE EN CONSIDERACIÓN UN TRY CATCH, PORQUE EN LA SESIÓN 4,
         * DIJOQ UE ESTAS OPERACIONES NO SE PUEDEN ELABORAR SIN SER DE ALGUNA FORMA CONTROLADAS
         */

        //TRANASACCION
        en.getTransaction().begin();

        try{
        //CREAR PAIS



            Country country = new Country("PNM", "Panem", "North America", "The Capitol",
                    1200.0, 0, 5000000, 75.5, 85.7, 258.0,
                    "Panem", "Totalitarian", "Presidente Snow", 1, "PN",null,null);

            //CREAR CIUDADES
            City city1 = new City(null, "Capitol", "Capital City", 1000000, country);
            City city2 = new City(null, "District 12", "Mining District", 50000, country);
            City city3 = new City(null, "District 1", "Luxury District", 100000, country);

            country.setCities(Arrays.asList(city1, city2, city3));

          // Crear lenguajes
            CountryLanguage language1 = new CountryLanguage("PNM", "Panemian", "T", 100.0, country);
            CountryLanguage language2 = new CountryLanguage("PNM", "District 12 Dialect", "T", 50.0, country);
            // Agregar los lenguajes al país
            country.setLanguages(Arrays.asList(language1, language2));

            en.persist(country);
            en.getTransaction().commit();

            //MENSAJE PARA CONFIRMAR
            System.out.println("País y sus entidades han sido persistidos exitosamente.");


        }catch (Exception e){
            // SI OCURRE UN EROR PARA PODER CONTROLARLO
            if (en.getTransaction().isActive()) {
                en.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            // CERRAMOS
            en.close();
            emf.close();
        }


    }
}
