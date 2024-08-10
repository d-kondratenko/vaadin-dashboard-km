package com.epic.dashboards.dashboardpkgtd;

import com.epic.base.BaseDashboard;
import com.epic.general.DashboardQuery;
import com.epic.general.GridColumnHeaders;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DashboardPkgTdMap {
    Map<String, BaseDashboard> dashboardsPkgTd = new HashMap<>();
    private DashboardQuery dashboardQuery;

    public DashboardPkgTdMap(DashboardQuery dashboardQuery){
        this.dashboardQuery = dashboardQuery;

        dashboardsPkgTd.put("KM1", new BaseDashboard("Активні роботи 'штабелера'", List.of("val10","val11","val12","val13"), new GridColumnHeaders().getActiveWorkForStacker(),dashboardQuery.getDashboardPkgTdKmQuery1(), new ArrayList<>(),2));
        dashboardsPkgTd.put("KM2", new BaseDashboard("Продуктивність роботи 'штабелера'", List.of("val10","val11","val12","val13","val14","val15","val16"), new GridColumnHeaders().getProductivityWorkForStackerA(),dashboardQuery.getDashboardPkgTdKmQuery2(), new ArrayList<>(),3));
        dashboardsPkgTd.put("KM3", new BaseDashboard("Активні роботи Picking", List.of("val10","val11","val12","val13","val14","val15","val16","val17","val18","val19"), new GridColumnHeaders().getPickingA(),dashboardQuery.getDashboardPkgTdKmQuery3(), new ArrayList<>(),4));
        dashboardsPkgTd.put("KM4", new BaseDashboard("Продуктивність Picking", List.of("val10","val11","val12","val13","val14","val15"), new GridColumnHeaders().getPickingProductivityA(),dashboardQuery.getDashboardPkgTdKmQuery4(), new ArrayList<>(),5));
        dashboardsPkgTd.put("KM5", new BaseDashboard("Продуктивність роботи Електровізок", List.of("val10","val11","val12"), new GridColumnHeaders().getProductivityWorkTrolley(),dashboardQuery.getDashboardPkgTdKmQuery5(), new ArrayList<>(),1));

    }
}
