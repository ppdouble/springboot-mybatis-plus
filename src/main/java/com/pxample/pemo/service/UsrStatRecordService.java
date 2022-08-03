package com.pxample.pemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pxample.pemo.model.UsrStatRecordEntity;

public interface UsrStatRecordService extends IService<UsrStatRecordEntity> {

    boolean addRecord(UsrStatRecordEntity usrStatRecordEntity);
    boolean updateByUserName(UsrStatRecordEntity usrStatRecordEntity, String accountId);

    boolean updateByTime();
}