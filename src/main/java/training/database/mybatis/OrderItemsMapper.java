package training.database.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderItemsMapper
{
    
    List<OrderItem> selectAll();
}
