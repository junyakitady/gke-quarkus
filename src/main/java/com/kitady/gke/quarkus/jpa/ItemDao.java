package com.kitady.gke.quarkus.jpa;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

@RequestScoped
public class ItemDao {

  /** EntityManager */
  @PersistenceContext
  private EntityManager em;

  /**
   * Search ITEM DB
   * 
   * @param uuid search by key, search all if null
   * @return ITEM list
   */
  @Transactional
  public List<Item> getItemList(String uuid) {
    String sql =
        "SELECT UUID, NAME, NAMEJP, BREWERY, TYPE, DIV, ITEMNO, PRICE, EXPLANATION, REGDATE, TIMEZONE, TIMESTMP, VERSION FROM ITEM";
    if (uuid != null) {
      sql += " WHERE UUID=:uuid";
    }
    // Native Query
    Query query = em.createNativeQuery(sql, Item.class);
    // TypedQuery<Item> query = em.createQuery(sql, Item.class);
    if (uuid != null) {
      query.setParameter("uuid", uuid);
    }
    List<Item> entityList = query.getResultList();
    for (Item entity : entityList) {
      em.detach(entity);
    }
    return entityList;
  }
}
