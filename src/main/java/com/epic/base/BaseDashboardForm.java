package com.epic.base;

import com.epic.general.GridItem;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.UIScope;

@UIScope
public class BaseDashboardForm extends VerticalLayout {
    public Grid<GridItem> dashboardGrid = new Grid<>(GridItem.class);

    public BaseDashboardForm(){
        VerticalLayout verticalLayout = new VerticalLayout();
        dashboardGrid.setAllRowsVisible(true);
        dashboardGrid.addThemeVariants(GridVariant.LUMO_NO_BORDER);
        verticalLayout.add(dashboardGrid);

        add(verticalLayout);
    }
}
