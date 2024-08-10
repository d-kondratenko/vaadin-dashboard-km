package com.epic.views;

import com.epic.configurations.ProjectDevConfig;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

/**
 * The main view is a top-level placeholder for other views.
 */
@Route("/")
@UIScope
public class MainLayout extends AppLayout {
    private final ProjectDevConfig projectDevConfig;
    private Integer basePageNumber = 1;

    private String currentHost;


    public MainLayout(ProjectDevConfig projectDevConfig) {
        this.projectDevConfig = projectDevConfig;
        this.currentHost = projectDevConfig.getCurrentHost();
        setPrimarySection(Section.DRAWER);
        addHeaderContent();
        
        addClassName("main-layout-app-layout-1");

    }

    private MenuBar createNavigation() {
        MenuBar menuBar = new MenuBar();
        menuBar.setOpenOnHover(true);
        
        
        MenuItem mainMenu = menuBar.addItem(VaadinIcon.MENU.create());
        mainMenu.add(new Text("Dashboards Menu"));

        SubMenu mainMenuSubMenu = mainMenu.getSubMenu();
        MenuItem dashboardA = mainMenuSubMenu.addItem("Dashboard KM");
        SubMenu dashboardASubMenu = dashboardA.getSubMenu();
        dashboardASubMenu.addItem("OUT").addClickListener(e -> redirectView(projectDevConfig.getDashboardOutLink(), "KM"));
        dashboardASubMenu.addItem("BB").addClickListener(e -> redirectView(projectDevConfig.getDashboardBbLink(), "KM"));
        dashboardASubMenu.addItem("XD").addClickListener(e -> redirectView(projectDevConfig.getDashboardXdChuteLink(), "KM"));
        dashboardASubMenu.addItem("ZKZ").addClickListener(e -> redirectView(projectDevConfig.getDashboardZkzLink(), "KM"));
        dashboardASubMenu.addItem("PKG+TD").addClickListener(e -> redirectView(projectDevConfig.getDashboardPkgTdLink(), "KM"));


        return menuBar;
    }

    private void addHeaderContent() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(createNavigation());
        horizontalLayout.setAlignItems(FlexComponent.Alignment.CENTER);
        horizontalLayout.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        addToNavbar(horizontalLayout);
    }

    void redirectView(String pageLink, String warehouseNr){
        Page page = UI.getCurrent().getPage();
            page.setLocation(currentHost + pageLink + warehouseNr + "/" + basePageNumber);
    }



}
