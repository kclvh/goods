package com.inssa.goods.Controller;

import com.inssa.goods.Service.GoodsSercvice;
import com.inssa.goods.VO.GoodsVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class GoodsController {
    Logger log = LoggerFactory.getLogger("GoodsController");

    @Autowired
    GoodsSercvice goodsSercvice; //주입식

    @GetMapping("/")
    public ModelAndView start(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        log.info("index페이지 작업"); //안내문 출력
        //ModelAndView() ==> 브라우저에 출력할 JSP, HTML 파일
        ModelAndView mav = new ModelAndView("/index");
        return mav;
    }
    //상품목록
    @GetMapping("/goods-list")
    public ModelAndView list(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        log.info("목록페이지 작업"); //안내문 출력
        //메소드의 선언된 모양 그대로(GoodsService)
        //public List<GoodsVO> selectAll() throws Exception;
        //( )입력값 없음, List<GoodsVO> 배열로 값을 가져온다.
        log.info("목록 데이터베이스 처리"); //안내문 출력
        List<GoodsVO> lists = goodsSercvice.selectAll(); //데이터베이스 처리

        log.info("목록페이지 이동"); //안내문 출력
        ModelAndView mav = new ModelAndView("/goods/list");
        mav.addObject("lists", lists); //위에 처리된 변수명을 전달
        return mav;
    }
    //상품상세페이지
    @GetMapping("/goods-view")
    public ModelAndView view(@RequestParam("gno") int gno, HttpServletRequest request, HttpServletResponse response) throws  Exception {
        //화면을 출력하기 전에 필요한 값을 읽어서 전달
        //public GoodsVO selectByGno(int gno) throws Exception;
        //(int gno) 입력값은 번호를 받아서, 1개의 GoodsVO을 가져온다.
        GoodsVO list = goodsSercvice.selectByGno(gno); //인수값을 전달받도록 값을 받을 수 있도록 선언

        ModelAndView mav = new ModelAndView("/goods/view");
        mav.addObject("list", list);
        return mav;
    }
    //상품등록
    @GetMapping("/goods-insert")
    public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        //등록페이지에 아무것도 없는 페이지출력
        ModelAndView mav = new ModelAndView("/goods/insert");
        return mav;
    }
    //상품처리
    @PostMapping("/goods-insert")
    public ModelAndView insertProc(@ModelAttribute("GoodsVO") GoodsVO goodsVO, @RequestParam("file") MultipartFile uploadFile, HttpServletRequest request, HttpServletResponse response) throws  Exception {
        //등록페이지에서 등록번튼을 클릭했을 때...데이터베이스에 값을 저장
        //이미지 업로드 작업
        String fileName = uploadFile.getOriginalFilename(); //파일명을 읽기
        //webapp/images/
        String filePath = request.getSession().getServletContext().getRealPath("/images/"); //저장위치

        try {
            uploadFile.transferTo(new File(filePath+fileName)); //클라이언트에서 서버로 파일을 전송
            //업로드를 성공했으면
            goodsVO.setGimgfile(fileName); //파일이름을 VO에 저장해서 데이터베이스에 파일명을 저장되도록

            //파일처리 오류시 데이터베이스 처리도 중단
            //goodsSercvice.insert(goodsVO);
        } catch(IllegalStateException| IOException e) {
            e.printStackTrace();;
        }
        //파일처리 오류가 발생해도 데이터베이스는 처리
        goodsSercvice.insert(goodsVO);


        ModelAndView mav = new ModelAndView("redirect:/goods-list2");
        return mav;
    }
    //상품수정/삭제
    @GetMapping("/goods-update")
    public ModelAndView update(@RequestParam("gno") int gno,HttpServletRequest request, HttpServletResponse response) throws  Exception {
        //수정을 번호를 받아서 해당 자료를 데이터베이스에서 읽어서 전달
        //public GoodsVO selectByGno(int gno) throws Exception;
        GoodsVO list =  goodsSercvice.selectByGno(gno);

        ModelAndView mav = new ModelAndView("/goods/update");
        mav.addObject("list", list);
        return mav;
    }
    //상품수정처리
    @PostMapping("/goods-update")
    public ModelAndView updateProc(@ModelAttribute("GoodsVO") GoodsVO goodsVO, HttpServletRequest request, HttpServletResponse response) throws  Exception {
        //수정페이지에서 수정버튼을 클릭했을 때 수정할 내용을 가져와서 데이터베이스 처리
        //public void updateByGno(GoodsVO goodsVO) throws Exception;
        goodsSercvice.updateByGno(goodsVO);

        ModelAndView mav = new ModelAndView("redirect:/goods-list2");
        return mav;
    }
    //상품삭제처리
    @GetMapping("/goods-delete")
    public ModelAndView deleteProc(@RequestParam("gno") int gno, HttpServletRequest request, HttpServletResponse response) throws  Exception {
        //수정페이지에서 삭제버튼을 클릭했을 때 해당번호의 자료를 데이터베이스에서 처리
        //public void deleteByGno(int gno) throws Exception;
        goodsSercvice.deleteByGno(gno);

        ModelAndView mav = new ModelAndView("redirect:/goods-list2");
        return mav;
    }
    //관리자 상품목록
    @GetMapping("/goods-list2")
    public ModelAndView list2(HttpServletRequest request, HttpServletResponse response) throws  Exception {
        List<GoodsVO> lists = goodsSercvice.selectAll();

        ModelAndView mav = new ModelAndView("/goods/list2");
        mav.addObject("lists", lists);
        return mav;
    }
}
