package com.epic.general;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class DashboardQuery {
    @Value("${userconfig.query.dashboardkm.out.query1}")
    private String dashboardOutKmQuery1;
    @Value("${userconfig.query.dashboardkm.out.query2}")
    private String dashboardOutKmQuery2;
    @Value("${userconfig.query.dashboardkm.out.query3}")
    private String dashboardOutKmQuery3;

    @Value("${userconfig.query.dashboardkm.bb.query1}")
    private String dashboardBbKmQuery1;
    @Value("${userconfig.query.dashboardkm.bb.query2}")
    private String dashboardBbKmQuery2;
    @Value("${userconfig.query.dashboardkm.bb.query3}")
    private String dashboardBbKmQuery3;
    @Value("${userconfig.query.dashboardkm.bb.query4}")
    private String dashboardBbKmQuery4;


    @Value("${userconfig.query.dashboardkm.xd.query1}")
    private String dashboardXdKmQuery1;
    @Value("${userconfig.query.dashboardkm.xd.query2}")
    private String dashboardXdKmQuery2;
    @Value("${userconfig.query.dashboardkm.xd.query4}")
    private String dashboardXdKmQuery4;
    @Value("${userconfig.query.dashboardkm.xd.query5}")
    private String dashboardXdKmQuery5;


    @Value("${userconfig.query.dashboardkm.pkg_td.query1}")
    private String dashboardPkgTdKmQuery1;
    @Value("${userconfig.query.dashboardkm.pkg_td.query2}")
    private String dashboardPkgTdKmQuery2;
    @Value("${userconfig.query.dashboardkm.pkg_td.query3}")
    private String dashboardPkgTdKmQuery3;
    @Value("${userconfig.query.dashboardkm.pkg_td.query4}")
    private String dashboardPkgTdKmQuery4;
    @Value("${userconfig.query.dashboardkm.pkg_td.query5}")
    private String dashboardPkgTdKmQuery5;


    @Value("${userconfig.query.dashboardkm.zkz.query1}")
    private String dashboardZkzKmQuery1;
    @Value("${userconfig.query.dashboardkm.zkz.query2}")
    private String dashboardZkzKmQuery2;
    @Value("${userconfig.query.dashboardkm.zkz.query3}")
    private String dashboardZkzKmQuery3;
}
