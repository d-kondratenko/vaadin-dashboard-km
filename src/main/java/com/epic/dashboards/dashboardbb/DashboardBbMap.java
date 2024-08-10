package com.epic.dashboards.dashboardbb;

import com.epic.base.BaseDashboard;
import com.epic.general.DashboardQuery;
import com.epic.general.GridColumnHeaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DashboardBbMap {

    Map<String, BaseDashboard> dashboardsBb = new HashMap<>();
    private DashboardQuery dashboardQuery;

    public DashboardBbMap(DashboardQuery dashboardQuery){
        this.dashboardQuery = dashboardQuery;

        dashboardsBb.put("KM1", new BaseDashboard("Запис постачальників ВВ  на поточний день", List.of("val10", "val11", "val12", "val13", "val14","val16") ,  new GridColumnHeaders().getRecordOfSuppliers(), dashboardQuery.getDashboardBbKmQuery1(), new ArrayList<>(), 2));
        dashboardsBb.put("KM2", new BaseDashboard("Продуктивність комірників приймання BB", List.of("val10","val11","val12","val13","val14","val15")  ,  new GridColumnHeaders().getStorekeeperDeliveryProductivityA(), dashboardQuery.getDashboardBbKmQuery2(),new ArrayList<>(), 3));
        dashboardsBb.put("KM3", new BaseDashboard("Продуктивність комплектувальників розподілу BB", List.of("val10","val11","val12","val13","val14","val15")  ,  new GridColumnHeaders().getStorekeeperDistributionProductivityA(), dashboardQuery.getDashboardBbKmQuery3(),new ArrayList<>(), 4));
        dashboardsBb.put("KM4", new BaseDashboard("Аналітика PBL", List.of("val10","val11","val12","val13","val14")  ,  new GridColumnHeaders().getNotDistributedPblA(), dashboardQuery.getDashboardBbKmQuery4(),new ArrayList<>(), 1));
    }
}
