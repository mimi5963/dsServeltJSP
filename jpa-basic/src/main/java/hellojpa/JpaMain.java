package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        //정석대로 사용하는 방법 -> jpa 순수
        tx.begin();
        try{

            List<Member> findMembers = em.createQuery("select m from Member", Member.class).getResultList();

            tx.commit();
        }catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        }finally {
            //code작성
            em.close();

        }
        //다 끝나면 닫아주기
        emf.close();


    }


}
