package com.zw.admin.server.controller;

import com.zw.admin.server.model.ProjectInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Api(tags = "登陆")
@RestController
@RequestMapping
public class BaseController {
    @ApiOperation(value = "获取项目基本信息", notes = "获取项目基本信息")
    @GetMapping("/sys/getProjectInfo")
    public ProjectInfo getProjectInfo(HttpServletRequest request) {
        // 网络协议
        String networkProtocol = getScheme(request);
        // 网络ip
        String ip = getRemortIP(request);
        // 端口号
        String port = getPort(request);
        // 项目发布名称
        String projectName = getProjectName(request);
        // 网络协议+ip+端口+项目发布名称
        String urlPrefix = getCtx(request);

        ProjectInfo projectInfo = new ProjectInfo(networkProtocol, ip, port, projectName, urlPrefix);
        return projectInfo;
    }

    /**
     * 获取网络协议
     *
     * @param request
     * @return
     */
    protected String getScheme(HttpServletRequest request) {
        String scheme = request.getHeader("X-Forwarded-Scheme");
        if (StringUtils.isEmpty(scheme)) {
            return request.getScheme();
        }
        return scheme;
    }

    /**
     * 获取ip地址
     *
     * @param request
     * @return
     */
    protected String getRemortIP(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.isEmpty(ip)) {
            return request.getServerName();
        }
        return ip;
    }

    /**
     * 获取port
     *
     * @param request
     * @return
     */
    protected String getPort(HttpServletRequest request) {
        String port = String.valueOf(request.getServerPort());
        return port;
    }

    /**
     * 获取项目发布名称
     *
     * @param request
     * @return
     */
    protected String getProjectName(HttpServletRequest request) {
        String projectName = request.getContextPath();
        if (StringUtils.isEmpty(projectName)) {
            return request.getContextPath();
        }
        return projectName;
    }

    /**
     * 获取项目路径前缀
     *
     * @param request
     * @return
     */
    protected String getCtx(HttpServletRequest request) {
        String basePath = "";
        if (StringUtils.equals(getPort(request), "80") || StringUtils.equals(getPort(request), "443")) {
            basePath = getScheme(request) + "://" + getRemortIP(request) + getProjectName(request) + "/";
        } else {
            basePath =
                    getScheme(request) + "://" + getRemortIP(request) + ":" + getPort(request) + getProjectName(request) + "/";
        }
        return basePath;
    }

}

