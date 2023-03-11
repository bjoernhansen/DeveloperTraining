package training.database.mybatis;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CustomerMapper
{
    @Select("SELECT * FROM customers")
    @Results({
        @Result(column = "customer_id", property = "customerIdentification")
    })
    List<Customer> selectAll();
}
