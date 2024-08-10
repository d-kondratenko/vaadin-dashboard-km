package com.epic.dashboards.dashboardzkz;

import com.epic.base.BaseDashboard;
import com.epic.general.DashboardQuery;
import com.epic.general.GridColumnHeaders;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
public class DashboardZkzMap {
    Map<String, BaseDashboard> dashboardsZkz = new HashMap<>();
    private DashboardQuery dashboardQuery;

    public DashboardZkzMap(DashboardQuery dashboardQuery){
        this.dashboardQuery = dashboardQuery;

        dashboardsZkz.put("KM1", new BaseDashboard("Запис постачальників Зкз на поточний день", List.of("val10", "val11","val12","val13","val14","val16"), new GridColumnHeaders().getRecordOfSuppliers(), dashboardQuery.getDashboardZkzKmQuery1(), new ArrayList<>(), 2));
        dashboardsZkz.put("KM2", new BaseDashboard("Продуктивність комірників приймання Зкз", List.of("val10","val11","val12","val13","val14","val15"), new GridColumnHeaders().getStorekeeperDeliveryProductivityA(), dashboardQuery.getDashboardZkzKmQuery2(), new ArrayList<>(), 3));
        dashboardsZkz.put("KM3", new BaseDashboard("Носії на рампах приймання (без руху більше 48 годин)", List.of("val10", "val11","val12","val13"), new GridColumnHeaders().getLuWithoutMoveInRamp(), dashboardQuery.getDashboardZkzKmQuery3(), new ArrayList<>(), 1));


    }
}
