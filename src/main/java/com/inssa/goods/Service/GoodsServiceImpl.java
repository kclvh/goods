package com.inssa.goods.Service;

import com.inssa.goods.DAO.GoodsDAO;
import com.inssa.goods.VO.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsSercvice {
    @Autowired
    GoodsDAO goodsDAO; //DAO를 주입
    //CTRl-I  인터페이스의 메소드를 삽입 전달값이 있으면 return, 없으면 생략
    //메소드명과 동일한 DAO메소드를 실행

    @Override
    public List<GoodsVO> selectAll() throws Exception {
        return goodsDAO.selectAll();
    }

    @Override
    public void insert(GoodsVO goodsVO) throws Exception {
        goodsDAO.insert(goodsVO);
    }

    @Override
    public GoodsVO selectByGno(int gno) throws Exception {
        return goodsDAO.selectByGno(gno);
    }

    @Override
    public void updateByGno(GoodsVO goodsVO) throws Exception {
        goodsDAO.updateByGno(goodsVO);
    }

    @Override
    public void deleteByGno(int gno) throws Exception {
        goodsDAO.deleteByGno(gno);
    }
}
