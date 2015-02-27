package com.easygoapp.mvc.dao;

import com.easygoapp.mvc.domain.Point;

/**
 * Created by SCJP on 27.02.2015.
 */
public interface PnpDao {

    Point getPnpbyId(Long id);
    void savePnp(Point point);
    void deletePnp(Long id);
}
