package com.epic.general;

import com.epic.base.BaseDashboardForm;
import com.epic.base.BaseDashboard;
import com.vaadin.flow.component.grid.ColumnTextAlign;
import com.vaadin.flow.component.grid.Grid;

import java.util.List;
import java.util.Objects;

public class DashboardForm extends BaseDashboardForm {

    private BaseDashboard dashboard;

    public DashboardForm(BaseDashboard dashboard){
        this.dashboard = dashboard;

        dashboardGrid.setItems(dashboard.getGridItems());
        setGridColumnsStyle();

    }

    void setGridColumnsStyle(){
        List<Grid.Column<GridItem>> dashboardsColumn = dashboardGrid.getColumns();
        for(Grid.Column<GridItem> column : dashboardsColumn){
            if(!dashboard.getGridColumns().contains(column.getKey())){
                column.setVisible(false);
            } else {
                column.setHeader(dashboard.getGridHeaders().get(column.getKey())).setTextAlign(ColumnTextAlign.CENTER).setFrozenToEnd(true);
            }
        }

        dashboardGrid.addClassName("styling");
        dashboardGrid.setPartNameGenerator(dashboard -> {
            if(dashboard.getVal20() >= 3){
                return "ul-status";
            }
            if(dashboard.getVal15() != null && Objects.equals(dashboard.getVal15(), "UL"))
                return "ul-status";
            if(dashboard.getVal15() != null &&  dashboard.getVal15().equals("IT")){
                return "it-status";
            }
            return null;
        });

    }
}
