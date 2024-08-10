package com.epic.dashboards.dashboardxdchute;

import com.epic.base.*;
import com.epic.configurations.ProjectDevConfig;
import com.epic.general.DashboardForm;
import com.epic.general.DashboardQuery;
import com.epic.general.DashboardQueryService;
import com.epic.views.MainLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.UIScope;
import lombok.extern.slf4j.Slf4j;

@Route(value = "xdchute", layout = MainLayout.class)
//@RouteAlias("dashboards/xdchute/:warehouseNr/:pageNumber") //test
@RouteAlias("xdchute/:warehouseNr/:pageNumber") //prod
@UIScope
@Slf4j
public class DashboardXdChuteController extends BaseController implements BeforeEnterObserver {

    private DashboardXdChuteMap dashboardXdChuteMap;
    public DashboardXdChuteController(DashboardQueryService dashboardQueryService, ProjectDevConfig projectDevConfig, DashboardQuery dashboardQuery){
        this.dashboardQuery = dashboardQuery;
        this.dashboardQueryService = dashboardQueryService;
        this.projectDevConfig = projectDevConfig;
        this.dashboardXdChuteMap = new DashboardXdChuteMap(dashboardQuery);
        this.mainLayout = new MainLayout(projectDevConfig);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        warehouseNr = beforeEnterEvent.getRouteParameters().get("warehouseNr").get();
        pageNumber = beforeEnterEvent.getRouteParameters().get("pageNumber").get();

        currentDashboard = getCurrentDashboardByWarehouseNrAndPageNumber(warehouseNr, pageNumber);

        while(currentDashboard.getGridItems().isEmpty()){
            currentDashboard = getCurrentDashboardByWarehouseNrAndPageNumber(warehouseNr, String.valueOf(currentDashboard.getNextPage()));
        }
        this.nextPage = currentDashboard.getNextPage();
        this.currentHost = projectDevConfig.getCurrentHost();
        this.dashboardLink = projectDevConfig.getDashboardXdChuteLink();
        this.currentInterval = projectDevConfig.getCurrentInterval();

        mainLayout.addToNavbar(addFormTitle(currentDashboard.getFormTitle()));
        this.dashboardForm = new DashboardForm(currentDashboard);
        add(mainLayout);
        add(dashboardForm);

    }

    private BaseDashboard getCurrentDashboardByWarehouseNrAndPageNumber(String warehouseNr, String pageNumber){
        BaseDashboard baseDashboard = dashboardXdChuteMap.getDashboardsXdCute().get(warehouseNr+pageNumber);
        baseDashboard.setGridItems(dashboardQueryService.getInfoByQuery(baseDashboard.getDashboardQuery(), false));
        return baseDashboard;
    }
}
