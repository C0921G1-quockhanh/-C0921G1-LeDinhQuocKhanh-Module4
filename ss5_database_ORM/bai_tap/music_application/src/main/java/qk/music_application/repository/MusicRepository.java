package qk.music_application.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import qk.music_application.model.Music;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class MusicRepository implements IMusicRepository {

    @Override
    public List<Music> findAll() {
        String queryStr = "select M from Music as M";
        TypedQuery<Music> query = ConnectionUtil.entityManager.createQuery(queryStr,Music.class);

        return query.getResultList();
    }

    @Override
    public void save(Music music) {

        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.saveOrUpdate(music);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public Music findByID(int id) {
        String queryStr = "select M from Music as M where M.id = :id";
        TypedQuery<Music> query = ConnectionUtil.entityManager.createQuery(queryStr,Music.class);
        query.setParameter("id",id);

        return query.getSingleResult();
    }

    @Override
    public void update(int id, Music music) {

        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Music origin = this.findByID(id);
            origin.setName(music.getName());
            origin.setArtist(music.getArtist());
            origin.setTypeOfMusic(music.getTypeOfMusic());

            session.saveOrUpdate(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

            if (transaction != null)
                transaction.rollback();
        }
    }

    @Override
    public void remove(int id) {

        Transaction transaction = null;

        try (Session session = ConnectionUtil.sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Music origin = this.findByID(id);
            session.remove(origin);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();

            if (transaction != null)
                transaction.rollback();
        }
    }
}
