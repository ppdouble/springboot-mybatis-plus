package com.pxample.pemo;

import com.pxample.pemo.model.UsrStatRecordEntity;
import com.pxample.pemo.service.UsrStatRecordService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UsrStatRecordServiceTest {

    @Resource
    private UsrStatRecordService usrStatRecordService;

    @Test
    public void testAddRecord() {
        UsrStatRecordEntity usrStatRecordEntity = new UsrStatRecordEntity();
        usrStatRecordEntity.setUserName("Henry");
        usrStatRecordEntity.setStatus(3);
        usrStatRecordEntity.setCreateTime(LocalDateTime.now());
        usrStatRecordEntity.setUpdateTime(LocalDateTime.now());

        usrStatRecordService.addRecord(usrStatRecordEntity);
        assertThat(usrStatRecordEntity.getId()).isNotNull();
    }

    @Test
    public void testUpdateByUserName() {
        UsrStatRecordEntity usrStatRecordEntity = new UsrStatRecordEntity();
        String userName = "Bob";
        usrStatRecordEntity.setStatus(5);
        usrStatRecordService.updateByUserName(usrStatRecordEntity, userName);
        assertThat(usrStatRecordEntity.getStatus()).isEqualTo(5);
    }

    @Test
    public void testUpdateByTime() {
        boolean r = usrStatRecordService.updateByTime();
        assertThat(r);
    }


}