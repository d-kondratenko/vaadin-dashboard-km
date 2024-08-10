package com.epic.dashboards.dashboardout;

import com.epic.base.BaseDashboard;
import com.epic.general.DashboardQuery;
import com.epic.general.GridColumnHeaders;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class DashboardOutMap {
    Map<String, BaseDashboard> dashboardsOut = new HashMap<>();
    private DashboardQuery dashboardQuery;


    public DashboardOutMap(DashboardQuery dashboardQuery){
        this.dashboardQuery = dashboardQuery;

        dashboardsOut.put("KM1", new BaseDashboard("Продуктивність комірників завантаження", List.of("val10", "val11", "val12"), new GridColumnHeaders().getStorekeeperLoadingProductivity(), dashboardQuery.getDashboardOutKmQuery1(), new ArrayList<>(), 2));
        dashboardsOut.put("KM2", new BaseDashboard("Авто під рампою", List.of("val10", "val11","val12","val13","val14"),  new GridColumnHeaders().getCarUnderRamp(), dashboardQuery.getDashboardOutKmQuery2(), new ArrayList<>(), 3));
        dashboardsOut.put("KM3", new BaseDashboard("Комплектація Посилок (UNP)", List.of("val10","val11"), new GridColumnHeaders().getParcelCreateProductivity(), dashboardQuery.getDashboardOutKmQuery3(), new ArrayList<>(),1));
    }
}
