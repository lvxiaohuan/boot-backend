package com.zw.admin.server.model;

import io.swagger.annotations.ApiModelProperty;

/**
 * @program: springboot <br/>
 * @Date: 2018/12/27 0027 11:48 <br/>
 * @Author: lvxh <br/>
 * @Description: <br/>
 */
public class ProjectInfo {
    @ApiModelProperty("网络协议")
    private String networkProtocol;
    @ApiModelProperty("网络ip")
    private String ip;
    @ApiModelProperty("端口号")
    private String port;
    @ApiModelProperty("项目发布名称")
    private String projectName;
    @ApiModelProperty("网络协议+ip+端口+项目发布名称")
    private String url;

    public ProjectInfo() {
    }

    public ProjectInfo(String networkProtocol, String ip, String port, String projectName, String url) {
        this.networkProtocol = networkProtocol;
        this.ip = ip;
        this.port = port;
        this.projectName = projectName;
        this.url = url;
    }

    public String getNetworkProtocol() {
        return networkProtocol;
    }

    public void setNetworkProtocol(String networkProtocol) {
        this.networkProtocol = networkProtocol;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
