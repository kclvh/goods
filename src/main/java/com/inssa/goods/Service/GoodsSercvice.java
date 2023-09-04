package com.inssa.goods.Service;

import com.inssa.goods.VO.GoodsVO;

import java.util.List;

public interface GoodsSercvice {
    //DAO의 내용을 복사
    public List<GoodsVO> selectAll() throws Exception;
    public void insert(GoodsVO goodsVO) throws Exception;
    public GoodsVO selectByGno(int gno) throws Exception;
    public void updateByGno(GoodsVO goodsVO) throws Exception;
    public void deleteByGno(int gno) throws Exception;
}
