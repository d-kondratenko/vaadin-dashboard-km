package com.epic.dashboards.dashboardxdchute;

import com.epic.base.BaseDashboard;
import com.epic.general.DashboardQuery;
import com.epic.general.GridColumnHeaders;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DashboardXdChuteMap {
    Map<String, BaseDashboard> dashboardsXdCute = new HashMap<>();
    private DashboardQuery dashboardQuery;

    public DashboardXdChuteMap(DashboardQuery dashboardQuery){
        this.dashboardQuery = dashboardQuery;

        dashboardsXdCute.put("KM1", new BaseDashboard("Запис постачальників XD на поточний день", List.of("val10", "val11","val12","val13","val14","val16"), new GridColumnHeaders().getRecordOfSuppliers(), dashboardQuery.getDashboardXdKmQuery1(), new ArrayList<>(), 2));
        dashboardsXdCute.put("KM2", new BaseDashboard("Продуктивність комірників приймання XD", List.of("val10","val11","val12","val13","val14","val15"), new GridColumnHeaders().getStorekeeperDeliveryProductivityA(), dashboardQuery.getDashboardXdKmQuery2(), new ArrayList<>(), 4));
        dashboardsXdCute.put("KM4", new BaseDashboard("Підозрілий обмір XD", List.of("val10", "val11","val12","val13","val14","val15","val16"), new GridColumnHeaders().getSuspiciousAmount(), dashboardQuery.getDashboardXdKmQuery4(), new ArrayList<>(), 5));
        dashboardsXdCute.put("KM5", new BaseDashboard("Продуктивність обмір XD", List.of("val10", "val11","val12","val13","val14"), new GridColumnHeaders().getMeasureXdProductivity(), dashboardQuery.getDashboardXdKmQuery5(), new ArrayList<>(), 1));
    }
}
