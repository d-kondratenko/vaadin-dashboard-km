package com.epic.dashboards.dashboardout;

import com.epic.base.*;
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

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Route(value = "out", layout = MainLayout.class)
//@RouteAlias("dashboards/out/:warehouseNr/:pageNumber") //test
@RouteAlias("out/:warehouseNr/:pageNumber") //prod
@UIScope
public class DashboardOutController extends BaseController implements BeforeEnterObserver {


    private DashboardOutMap dashboardOutMap;
    public DashboardOutController(DashboardQueryService dashboardQueryService, ProjectDevConfig projectDevConfig, DashboardQuery dashboardQuery){
        this.dashboardQueryService = dashboardQueryService;
        this.projectDevConfig = projectDevConfig;
        this.dashboardQuery = dashboardQuery;
        this.dashboardOutMap = new DashboardOutMap(dashboardQuery);
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
        this.dashboardLink = projectDevConfig.getDashboardOutLink();
        this.currentInterval = projectDevConfig.getCurrentInterval();

        mainLayout.addToNavbar(addFormTitle(currentDashboard.getFormTitle()));
        this.dashboardForm = new DashboardForm(currentDashboard);
        add(mainLayout);
        add(dashboardForm);

    }

    private BaseDashboard getCurrentDashboardByWarehouseNrAndPageNumber(String warehouseNr, String pageNumber){
        BaseDashboard baseDashboard = dashboardOutMap.getDashboardsOut().get(warehouseNr+pageNumber);
        baseDashboard.setGridItems(dashboardQueryService.getInfoByQuery(baseDashboard.getDashboardQuery(), false));
        return baseDashboard;
    }

}
