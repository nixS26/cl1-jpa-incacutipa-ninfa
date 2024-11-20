package pe.edu.i202220224.crud;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202220224.entity.Country;

public class JPARemove {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager en = emf.createEntityManager();

        /**
         * IGULA PARA ESTE CASO TAMBIEN DEBEMOS CONTROLAR LA EJECUCIÓN, YO ESTOY OPTANDO POR UN TRY CATCH
         */

        try{
            //TRANASACCION
            en.getTransaction().begin();
            Country country = en.find(Country.class, "PNM");
            if(country != null){
                en.remove(country);
            }else{
                System.out.println("Country not found");
            }
            //CONFIRMAMOS
            en.getTransaction().commit();

        }catch (Exception e){
            if (en.getTransaction().isActive()) {
                en.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {
            en.close();
        }

    }
}
