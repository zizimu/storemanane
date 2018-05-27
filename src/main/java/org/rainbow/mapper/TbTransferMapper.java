package org.rainbow.mapper;

import org.rainbow.pojo.TbTransfer;

import java.util.List;

public interface TbTransferMapper {
	
    int addTransfer(TbTransfer transfer);
    
    List<TbTransfer> findAllCheckTransfer();
    
    TbTransfer findCheckTransfer(Long transfer_id);
    
    void updateTransfer(TbTransfer transfer);

   /* int insertSelective(TbTransfer transfer);

    int updateByPrimaryKeySelective(TbTransfer transfer);

    int updateByPrimaryKey(TbTransfer transfer);

    List<TbTransfer> selectAll();

    List<TbTransfer> getAllTbTransferName();

	TbTransfer selectByPrimaryKey(long iD);*/
}