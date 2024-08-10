package com.epic.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
public class ProjectDevConfig {
    @Value("${userconfig.constant.interval.prod}")
    private Integer currentInterval;


    @Value("${userconfig.constant.host.prod}")
    private String currentHost;

    @Value("${userconfig.constant.page_link.dashboard.out}")
    private String dashboardOutLink;

    @Value("${userconfig.constant.page_link.dashboard.post}")
    private String dashboardPostLink;

    @Value("${userconfig.constant.page_link.dashboard.bb}")
    private String dashboardBbLink;

    @Value("${userconfig.constant.page_link.dashboard.xdchute}")
    private String dashboardXdChuteLink;

    @Value("${userconfig.constant.page_link.dashboard.prv}")
    private String dashboardPrvLink;

    @Value("${userconfig.constant.page_link.dashboard.c2m2}")
    private String dashboardC2M2Link;

    @Value("${userconfig.constant.page_link.dashboard.pkgtd}")
    private String dashboardPkgTdLink;

    @Value("${userconfig.constant.page_link.dashboard.zkz}")
    private String dashboardZkzLink;

}
