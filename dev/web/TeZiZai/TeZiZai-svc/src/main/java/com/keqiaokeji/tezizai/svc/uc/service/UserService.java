package com.keqiaokeji.tezizai.svc.uc.service;

import com.keqiaokeji.tezizai.common.app.JsonResultContants;
import com.keqiaokeji.tezizai.common.cache.CacheCtrl;
import com.keqiaokeji.tezizai.common.cache.token.TokenCtrl;
import com.keqiaokeji.tezizai.common.character.DesEncrypt;
import com.keqiaokeji.tezizai.common.character.StringUtils;
import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfo;
import com.keqiaokeji.tezizai.common.dbmapper.uc.domain.UcUserInfoExample;
import com.keqiaokeji.tezizai.common.dbmapper.uc.mapper.UcUserInfoMapper;
import com.keqiaokeji.tezizai.common.jqgrid.JQGridPage;
import com.keqiaokeji.tezizai.common.utils.JsonResult;
import com.keqiaokeji.tezizai.svc.uc.domain.UserContants;
import com.keqiaokeji.tezizai.svc.uc.domain.UserInfo;
import com.keqiaokeji.tezizai.svc.uc.mapper.UserInfoMapper;
import com.keqiaokeji.tezizai.svc.utils.AppContents;
import com.keqiaokeji.tezizai.svc.utils.MailSendUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户操作实现类
 */
@Service("userService")
public class UserService {

    @Autowired
    private UcUserInfoMapper ucUserInfoMapper;//该错误提示仅仅在编译器中提示，但不影响程序使用，可以忽略

    @Autowired
    private UserInfoMapper userInfoMapper;


    @Autowired
    CacheCtrl cacheCtrl;

    @Autowired
    MailSendUtils mailSendUtils;

    Logger logger = Logger.getLogger(UserService.class.getName());

    public JsonResult loginUser(String username, String password) {
        JsonResult result = null;
        UcUserInfo ucUserinfo = login(username, password);
        if (ucUserinfo == null) {
            result = new JsonResult(JsonResultContants.LOGIN_USERNAME_PASSWORD_ERROR, JsonResultContants.LOGIN_USERNAME_PASSWORD_ERROR_MSG);
        } else if (ucUserinfo.getStatus().equals(UserContants.STATE_FORBIDDEN)) {
            result = new JsonResult(JsonResultContants.USER_STATE_FORBIDDEN, JsonResultContants.USER_STATE_FORBIDDEN_MSG);
        } else if (ucUserinfo.getStatus().equals(UserContants.STATE_FREEZE)) {
            result = new JsonResult(JsonResultContants.USER_STATE_FREEZE, JsonResultContants.USER_STATE_FREEZE_MSG);
        } else {
            String token = cacheCtrl.getTokenCtrl().addToken(ucUserinfo);
            result = new JsonResult();
            result.setStatusCode(JsonResultContants.LOGIN_SUCCESS);
            result.setStatusMsg(JsonResultContants.LOGIN_SUCCESS_MSG);
            result.setToken(token);
            ucUserinfo.setPassword(null);
            result.setContentToJsonString(ucUserinfo);
        }
        return result;
    }

    public UcUserInfo login(String username, String password) {
        UcUserInfo ucUserInfo = null;
        UcUserInfoExample example = new UcUserInfoExample();
        example.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(DesEncrypt.encrypt(password, UserContants.PASSWORD_DES));
        List<UcUserInfo> ucUserInfos = ucUserInfoMapper.selectByExample(example);
        if (ucUserInfos != null && ucUserInfos.size() > 0) {
            ucUserInfo = ucUserInfos.get(0);
        }
        return ucUserInfo;
    }


    public JsonResult regUser(UserInfo userInfo) {
        JsonResult result = null;
        UcUserInfo userCheck = regCheck(userInfo);
        if (userCheck != null) {
            if (userCheck.getEmail().equals(userInfo.getEmail())) {
                result = new JsonResult(JsonResultContants.REG_EMAIL_EXSIT, JsonResultContants.REG_EMAIL_EXSIT_MSG);
            } else if (userCheck.getUsername().equals(userInfo.getUsername())) {
                result = new JsonResult(JsonResultContants.REG_USERNAME_EXSIT, JsonResultContants.REG_USERNAME_EXSIT_MSG);
            }
        } else {
            add(userInfo);
            result = new JsonResult(JsonResultContants.REG_SUCCESS, JsonResultContants.REG_SUCCESS_MSG);
        }
        return result;

    }


    public UcUserInfo regCheck(UserInfo userInfo) {
        UcUserInfo ucUserInfo = null;
        UcUserInfoExample example = new UcUserInfoExample();
        example.or(example.createCriteria().andEmailEqualTo(userInfo.getEmail()));
        example.or(example.createCriteria().andUsernameEqualTo(userInfo.getUsername()));
        List<UcUserInfo> ucUserInfos = ucUserInfoMapper.selectByExample(example);
        if (ucUserInfos != null && ucUserInfos.size() > 0) {
            ucUserInfo = ucUserInfos.get(0);
        }
        return ucUserInfo;
    }


    public JsonResult findPasswordUser(String email) {
        JsonResult result = null;
        UcUserInfo userCheck = findPasswordCheck(email);
        if (userCheck != null) {
            String password = DesEncrypt.decrypt(userCheck.getPassword(), UserContants.PASSWORD_DES);
            try {
                mailSendUtils.sendFindPasswordMail(email, password);
                result = new JsonResult(JsonResultContants.FIND_PASSWORD_SUCCESS, JsonResultContants.FIND_PASSWORD_SUCCESS_MSG);
            } catch (Exception e) {
                logger.error(e);
                result = new JsonResult(JsonResultContants.FIND_PASSWORD_FAIL, JsonResultContants.FIND_PASSWORD_FAIL_MSG);
            }
        } else {
            result = new JsonResult(JsonResultContants.FIND_PASSWORD_EMAIL_NOT_EXSIT, JsonResultContants.FIND_PASSWORD_EMAIL_NOT_EXSIT_MSG);
        }
        return result;

    }


    public UcUserInfo findPasswordCheck(String email) {
        UcUserInfo ucUserInfo = null;
        UcUserInfoExample example = new UcUserInfoExample();
        example.createCriteria().andEmailEqualTo(email);
        List<UcUserInfo> ucUserInfos = ucUserInfoMapper.selectByExample(example);
        if (ucUserInfos != null && ucUserInfos.size() > 0) {
            ucUserInfo = ucUserInfos.get(0);
        }
        return ucUserInfo;
    }


    public JQGridPage getUserInfoList(JQGridPage pageJQGrid) {
        pageJQGrid.initJqGrid();
        List<UserInfo> userInfoList = userInfoMapper.getUserListJQgrid(pageJQGrid);
        for (UserInfo user : userInfoList) {
            user.initUserInfo();
            user.setPassword(DesEncrypt.decrypt(user.getPassword(), UserContants.PASSWORD_DES));
        }
        pageJQGrid.setDataRows(userInfoList);
        Integer count = userInfoMapper.getUserListCountJQgrid(pageJQGrid);
        if (count != null) {
            pageJQGrid.setRecords(count);
        }
        return pageJQGrid;
    }


    public void update(UcUserInfo userInfo) {
        if (StringUtils.isNotBlank(userInfo.getPassword())) {
            userInfo.setPassword(DesEncrypt.encrypt(userInfo.getPassword(), UserContants.PASSWORD_DES));
        }
        userInfo.setLastModifyTime(new Date().getTime());
        userInfo.setRecordStatus(AppContents.RECORD_STATUS_UPDATE);
        ucUserInfoMapper.updateByPrimaryKeySelective(userInfo);
    }


    public void delete(String userId) {
        ucUserInfoMapper.deleteByPrimaryKey(userId);
    }


    public void add(UcUserInfo userInfo) {
        userInfo.setPassword(DesEncrypt.encrypt(userInfo.getPassword(), UserContants.PASSWORD_DES));
        userInfo.setStatus(UserContants.STATUS_NORMOR);
        userInfo.setRecordStatus(AppContents.RECORD_STATUS_INSERT);
        userInfo.setUserId(StringUtils.getUUID());
        userInfo.setCreateTime(new Date().getTime());
        userInfo.setLastModifyTime(new Date().getTime());
        ucUserInfoMapper.insert(userInfo);
    }
}
