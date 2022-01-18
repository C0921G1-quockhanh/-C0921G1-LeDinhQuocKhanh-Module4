package qk.blog_management.repository;

import qk.blog_management.model.Blog;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements IBlogRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        String queryStr = "select B from Blog as B";
        TypedQuery<Blog> query = entityManager.createQuery(queryStr,Blog.class);
        return query.getResultList();
    }

    @Override
    public Blog findByID(Integer id) {
        String queryStr = "select B from Blog as B where B.id = :id";
        TypedQuery<Blog> query = entityManager.createQuery(queryStr,Blog.class);
        query.setParameter("id",id);
        
        try {
            return query.getSingleResult();
        }
        catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != null)
            entityManager.merge(blog);
        else 
            entityManager.persist(blog);
    }

    @Override
    public void remove(Integer id) {
        Blog blog = this.findByID(id);
        if (blog != null)
            entityManager.remove(blog);
    }
}
