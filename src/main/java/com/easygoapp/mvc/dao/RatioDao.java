package com.easygoapp.mvc.dao;

import java.util.List;

/**
 * Created by SCJP on 27.02.2015.
 */
public interface RatioDao {
    void saveRatio(Long tripId, Long userId, Integer ratio);
    List<Integer> getRatioByUserId(Long userId);
}
