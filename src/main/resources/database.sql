create table goods_tbl(
                          gno int(4) not null PRIMARY key AUTO_INCREMENT,
                          ggoods varchar(100),
                          gcontent varchar(200),
                          gprice int(4),
                          gquan int(4),
                          gimgfile varchar(200)
);

검색 SELECT * FROM `goods_tbl`
                     삽입 INSERT INTO `goods_tbl` (`gno`, `ggoods`, `gcontent`, `gprice`, `gquan`, `gimgfile`) VALUES (NULL, '연습1', '연습1', '10000', '10', 'a.jpg');
삭제 DELETE FROM goods_tbl WHERE `goods_tbl`.`gno` = 1
    수정 UPDATE `goods_tbl` SET `ggoods` = '연습11', `gcontent` = '연습11', `gprice` = '100010', `gquan` = '101', `gimgfile` = 'a1.jpg' WHERE `goods_tbl`.`gno` = 1