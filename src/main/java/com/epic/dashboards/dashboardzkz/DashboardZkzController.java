package com.epic.dashboards.dashboardzkz;

import com.epic.base.BaseController;
import com.epic.base.BaseDashboard;
import com.epic.configurations.ProjectDevConfig;
import com.epic.general.DashboardForm;
import com.epic.general.DashboardQuery;
import com.epic.general.DashboardQueryService;
import com.epic.general.GridItem;
import com.epic.views.MainLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.spring.annotation.UIScope;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Route(value = "zkz", layout = MainLayout.class)
@RouteAlias("zkz/:warehouseNr/:pageNumber")
@UIScope
@Slf4j
public class DashboardZkzController extends BaseController implements BeforeEnterObserver {

    private DashboardZkzMap dashboardZkzMap;
    public DashboardZkzController(DashboardQueryService dashboardQueryService, ProjectDevConfig projectDevConfig, DashboardQuery dashboardQuery){
        this.dashboardQuery = dashboardQuery;
        this.dashboardQueryService = dashboardQueryService;
        this.projectDevConfig = projectDevConfig;
        this.dashboardZkzMap = new DashboardZkzMap(dashboardQuery);
        this.mainLayout = new MainLayout(projectDevConfig);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        warehouseNr = beforeEnterEvent.getRouteParameters().get("warehouseNr").get();
        pageNumber = beforeEnterEvent.getRouteParameters().get("pageNumber").get();

        currentDashboard = getCurrentDashboardByWarehouseNrAndPageNumber(warehouseNr, pageNumber);

        List<GridItem> gr = Objects.requireNonNullElse(currentDashboard.getGridItems(), Collections.emptyList());
        while(gr.isEmpty()){
            currentDashboard = getCurrentDashboardByWarehouseNrAndPageNumber(warehouseNr, String.valueOf(currentDashboard.getNextPage()));
            gr = Objects.requireNonNullElse(currentDashboard.getGridItems(), Collections.emptyList());
        }
        this.nextPage = currentDashboard.getNextPage();
        this.currentHost = projectDevConfig.getCurrentHost();
        this.dashboardLink = projectDevConfig.getDashboardZkzLink();
        this.currentInterval = projectDevConfig.getCurrentInterval();

        mainLayout.addToNavbar(addFormTitle(currentDashboard.getFormTitle()));
        this.dashboardForm = new DashboardForm(currentDashboard);
        add(mainLayout);
        add(dashboardForm);

    }

    private BaseDashboard getCurrentDashboardByWarehouseNrAndPageNumber(String warehouseNr, String pageNumber){
        BaseDashboard baseDashboard = dashboardZkzMap.getDashboardsZkz().get(warehouseNr+pageNumber);
        baseDashboard.setGridItems(dashboardQueryService.getInfoByQuery(baseDashboard.getDashboardQuery(), false));
        return baseDashboard;
    }
}
