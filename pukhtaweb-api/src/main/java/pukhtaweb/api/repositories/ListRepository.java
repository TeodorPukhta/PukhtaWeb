package pukhtaweb.api.repositories;

import pukhtaweb.api.entities.ListEntity;
import pukhtaweb.api.models.ListDataResponse;

import java.sql.SQLException;
import java.util.List;


public interface ListRepository extends GeneralRepository<ListEntity,Integer>{

    List<ListDataResponse> selectAll2() throws SQLException;
}
