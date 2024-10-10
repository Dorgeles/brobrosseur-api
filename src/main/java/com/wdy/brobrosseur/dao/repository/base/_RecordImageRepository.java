
package com.wdy.brobrosseur.dao.repository.base;

import com.wdy.brobrosseur.dao.entity.RecordImage;
import com.wdy.brobrosseur.utils.CriteriaUtils;
import com.wdy.brobrosseur.utils.Utilities;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.dto.RecordImageDto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.util.*;

/**
 * Repository customize : RecordImage.
 *
 * @author Geo
 *
 */
@Repository
public interface _RecordImageRepository {
	    /**
     * Finds RecordImage by using id as a search criteria.
     *
     * @param id
     * @return An Object RecordImage whose id is equals to the given id. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.id = :id and e.isDeleted = :isDeleted")
    RecordImage findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds RecordImage by using url as a search criteria.
     *
     * @param url
     * @return An Object RecordImage whose url is equals to the given url. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.url = :url and e.isDeleted = :isDeleted")
    List<RecordImage> findByUrl(@Param("url")String url, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds RecordImage by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object RecordImage whose statusId is equals to the given statusId. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<RecordImage> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds RecordImage by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object RecordImage whose updatedBy is equals to the given updatedBy. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<RecordImage> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds RecordImage by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object RecordImage whose isDeleted is equals to the given isDeleted. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.isDeleted = :isDeleted")
    List<RecordImage> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds RecordImage by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object RecordImage whose createdBy is equals to the given createdBy. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<RecordImage> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds RecordImage by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object RecordImage whose deletedAt is equals to the given deletedAt. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<RecordImage> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds RecordImage by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object RecordImage whose updatedAt is equals to the given updatedAt. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<RecordImage> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds RecordImage by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object RecordImage whose createdAt is equals to the given createdAt. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<RecordImage> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds RecordImage by using activiteId as a search criteria.
     *
     * @param activiteId
     * @return An Object RecordImage whose activiteId is equals to the given activiteId. If
     *         no RecordImage is found, this method returns null.
     */
    @Query("select e from RecordImage e where e.activite.id = :activiteId and e.isDeleted = :isDeleted")
    List<RecordImage> findByActiviteId(@Param("activiteId")Integer activiteId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one RecordImage by using activiteId as a search criteria.
   *
   * @param activiteId
   * @return An Object RecordImage whose activiteId is equals to the given activiteId. If
   *         no RecordImage is found, this method returns null.
   */
  @Query("select e from RecordImage e where e.activite.id = :activiteId and e.isDeleted = :isDeleted")
  RecordImage findRecordImageByActiviteId(@Param("activiteId")Integer activiteId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of RecordImage by using recordImageDto as a search criteria.
     *
     * @param request, em
     * @return A List of RecordImage
     * @throws DataAccessException,ParseException
     */
    public default List<RecordImage> getByCriteria(Request<RecordImageDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from RecordImage e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<RecordImage> query = em.createQuery(req, RecordImage.class);
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        if (request.getIndex() != null && request.getSize() != null) {
            query.setFirstResult(request.getIndex() * request.getSize());
            query.setMaxResults(request.getSize());
        }
        return query.getResultList();
    }

    /**
     * Finds count of RecordImage by using recordImageDto as a search criteria.
     *
     * @param request, em
     * @return Number of RecordImage
     *
     */
    public default Long count(Request<RecordImageDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from RecordImage e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                jakarta.persistence.Query query = em.createQuery(req);
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        Long count = (Long) query.getResultList().get(0);
        return count;
    }

    /**
     * get where expression
     * @param request
     * @param param
     * @param locale
     * @return
     * @throws Exception
     */
    default String getWhereExpression(Request<RecordImageDto> request, HashMap<String, Object> param, Locale locale) throws Exception {
        // main query
        RecordImageDto dto = request.getData() != null ? request.getData() : new RecordImageDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (RecordImageDto elt : request.getDatas()) {
                elt.setIsDeleted(false);
                String eltReq = generateCriteria(elt, param, index, locale);
                if (request.getIsAnd() != null && request.getIsAnd()) {
                    othersReq += "and (" + eltReq + ") ";
                } else {
                    othersReq += "or (" + eltReq + ") ";
                }
                index++;
            }
        }
        String req = "";
        if (!mainReq.isEmpty()) {
            req += " and (" + mainReq + ") ";
        }
        req += othersReq;

        //order
        if(Direction.fromOptionalString(dto.getOrderDirection()).orElse(null) != null && Utilities.notBlank(dto.getOrderField())) {
            req += " order by e."+dto.getOrderField()+" "+dto.getOrderDirection();
        }
        else {
            req += " order by  e.id desc";
        }
        return req;
    }

    /**
     * generate sql query for dto
     * @param dto
     * @param param
     * @param index
     * @param locale
     * @return
     * @throws Exception
     */
    default String generateCriteria(RecordImageDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUrl()) || Utilities.searchParamIsNotEmpty(dto.getUrlParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("url", dto.getUrl(), "e.url", "String", dto.getUrlParam(), param, index, locale));
            }
            if (dto.getStatusId() != null || Utilities.searchParamIsNotEmpty(dto.getStatusIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("statusId", dto.getStatusId(), "e.statusId", "Integer", dto.getStatusIdParam(), param, index, locale));
            }
            if (dto.getUpdatedBy() != null || Utilities.searchParamIsNotEmpty(dto.getUpdatedByParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("updatedBy", dto.getUpdatedBy(), "e.updatedBy", "Integer", dto.getUpdatedByParam(), param, index, locale));
            }
            if (dto.getIsDeleted() != null || Utilities.searchParamIsNotEmpty(dto.getIsDeletedParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("isDeleted", dto.getIsDeleted(), "e.isDeleted", "Boolean", dto.getIsDeletedParam(), param, index, locale));
            }
            if (dto.getCreatedBy() != null || Utilities.searchParamIsNotEmpty(dto.getCreatedByParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdBy", dto.getCreatedBy(), "e.createdBy", "Integer", dto.getCreatedByParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDeletedAt()) || Utilities.searchParamIsNotEmpty(dto.getDeletedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("deletedAt", dto.getDeletedAt(), "e.deletedAt", "Date", dto.getDeletedAtParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUpdatedAt()) || Utilities.searchParamIsNotEmpty(dto.getUpdatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("updatedAt", dto.getUpdatedAt(), "e.updatedAt", "Date", dto.getUpdatedAtParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCreatedAt()) || Utilities.searchParamIsNotEmpty(dto.getCreatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdAt", dto.getCreatedAt(), "e.createdAt", "Date", dto.getCreatedAtParam(), param, index, locale));
            }
                        if (dto.getActiviteId() != null || Utilities.searchParamIsNotEmpty(dto.getActiviteIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("activiteId", dto.getActiviteId(), "e.activite.id", "Integer", dto.getActiviteIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getActiviteLibelle()) || Utilities.searchParamIsNotEmpty(dto.getActiviteLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("activiteLibelle", dto.getActiviteLibelle(), "e.activite.libelle", "String", dto.getActiviteLibelleParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
