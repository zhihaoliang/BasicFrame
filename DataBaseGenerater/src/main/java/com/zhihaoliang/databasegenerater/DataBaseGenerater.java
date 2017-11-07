package com.zhihaoliang.databasegenerater;

import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class DataBaseGenerater {

    //要和Config的版本号保持一致
    private static final int VERSION = 1;

    public static void main(String[] args) throws Exception {
        DataBaseGenerater testDaoGenerator = new DataBaseGenerater();
        testDaoGenerator.generate();
    }

    private final Schema mSchemaResp;

    private DataBaseGenerater() {
        mSchemaResp = new Schema(VERSION, "com.zhihaoliang.basicframe.mode.database");
        mSchemaResp.setDefaultJavaPackageDao("com.zhihaoliang.basicframe.dao");

        createDataLogin();

    }

    private void generate() throws Exception {
        org.greenrobot.greendao.generator.DaoGenerator daoGenerator = new org.greenrobot.greendao.generator.DaoGenerator();
        daoGenerator.generateAll(mSchemaResp, "./app/src/main/java");
    }

    /**
     * 个人信息
     */
    private void createDataLogin() {
        Entity simple = mSchemaResp.addEntity("DaoInfo");
        simple.addIdProperty();
        simple.addStringProperty("phone").javaDocField("手机账号");
        simple.addStringProperty("password");
        simple.addStringProperty("empCode");
        simple.addStringProperty("orgCode");
        simple.addStringProperty("orgName");
        simple.addStringProperty("empName");
        simple.addStringProperty("encryptKey");
        simple.addIntProperty("deviceId");
        simple.addBooleanProperty("isSavePassword");
        simple.addContentProvider().readOnly();
    }

}
