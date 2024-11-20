package pe.edu.i202220224.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220224.entity.Country;
import pe.edu.i202220224.entity.City;

import java.util.List;

public class JPAFind {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        try {

            Country country = em.find(Country.class, "PER");

            if (country != null) {
                // OBTENEMOS LAS CIUDADES
                List<City> cities = country.getCities();

                /**
                 * FILTRAMOS LAS CIUDADES SIGUIENDO LA CONDICION DE MAYORA 700K
                 * USAMOS LAMBDA
                 */
                cities.stream()
                        .filter(city -> city.getPopulation() > 700000)
                        .forEach(city -> System.out.println(city.getName()));
            } else {
                System.out.println("Country not found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
