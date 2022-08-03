package com.pxample.pemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.pxample.pemo.mapper.UsrStatRecordMapper;
import com.pxample.pemo.model.UsrStatRecordEntity;
import com.pxample.pemo.service.UsrStatRecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class UsrStatRecordServiceImpl extends ServiceImpl<UsrStatRecordMapper, UsrStatRecordEntity> implements UsrStatRecordService {


    @Resource
    private UsrStatRecordMapper usrStatRecordMapper;

    @Override
    public boolean addRecord(UsrStatRecordEntity usrStatRecordEntity) {
        return save(usrStatRecordEntity);
    }

    @Override
    public boolean updateByUserName(UsrStatRecordEntity usrStatRecordEntity, String userName) {
        UpdateWrapper<UsrStatRecordEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("user_name", userName);
        int ret = usrStatRecordMapper.update(usrStatRecordEntity, updateWrapper);
        return SqlHelper.retBool(ret);
    }

    @Override
    public boolean updateByTime() {


        LocalDateTime thisMoment = LocalDateTime.now();
        LocalDateTime theMomentBeforeTwoDays = thisMoment.minus(2, ChronoUnit.DAYS);
        System.out.println(theMomentBeforeTwoDays);


        UsrStatRecordEntity usrStatRecordEntity = new UsrStatRecordEntity();
        UpdateWrapper<UsrStatRecordEntity> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("status", 5);

        usrStatRecordEntity.setStatus(3);
        usrStatRecordEntity.setUpdateTime(LocalDateTime.now());

        int rows = usrStatRecordMapper.update(usrStatRecordEntity, updateWrapper);

        /*
        Use LampdaUpdateWrapper will get warning
        https://github.com/baomidou/mybatis-plus/issues/3900


        WARNING: An illegal reflective access operation has occurred
        WARNING: Illegal reflective access by com.baomidou.mybatisplus.core.toolkit.SetAccessibleAction (file:/home/user/.m2/repository/com/baomidou/mybatis-plus-core/3.5.2/mybatis-plus-core-3.5.2.jar) to field java.lang.invoke.SerializedLambda.capturingClass
        WARNING: Please consider reporting this to the maintainers of com.baomidou.mybatisplus.core.toolkit.SetAccessibleAction
        WARNING: Use --illegal-access=warn to enable warnings of further illegal reflective access operations
        WARNING: All illegal access operations will be denied in a future release
         */
        /*
        LambdaUpdateWrapper<UsrStatRecordEntity> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();

        lambdaUpdateWrapper.eq(UsrStatRecordEntity::getStatus, 5)
                           .lt(UsrStatRecordEntity::getCreateTime, theMomentBeforeTwoDays)
                           .set(UsrStatRecordEntity::getStatus, 3)
                           .set(UsrStatRecordEntity::getUpdateTime, LocalDateTime.now());
        int rows = usrStatRecordMapper.update(null, lambdaUpdateWrapper);
        */
        System.out.println("update " + rows + " rows");
        return SqlHelper.retBool(rows);
    }

    @Override
    public boolean save(UsrStatRecordEntity usrStatRecordEntity) {
        int ret = 0;
        ret = usrStatRecordMapper.insert(usrStatRecordEntity);
        return SqlHelper.retBool(ret);
    }
}