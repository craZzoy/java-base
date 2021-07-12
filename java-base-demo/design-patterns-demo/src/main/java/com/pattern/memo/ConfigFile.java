package com.pattern.memo;

import java.util.Date;

/**
 * 配置信息类
 */
public class ConfigFile {

    private String versionNum;

    private String content;

    private Date datetime;

    private String operator;

    public ConfigFile(String versionNum, String content, Date datetime, String operator) {
        this.versionNum = versionNum;
        this.content = content;
        this.datetime = datetime;
        this.operator = operator;
    }

    public String getVersionNum() {
        return versionNum;
    }

    public void setVersionNum(String versionNum) {
        this.versionNum = versionNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "ConfigFile{" +
                "versionNum='" + versionNum + '\'' +
                ", content='" + content + '\'' +
                ", datetime=" + datetime +
                ", operator='" + operator + '\'' +
                '}';
    }
}
