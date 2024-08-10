package com.epic.base;

import com.epic.general.GridItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseDashboard {
    private String formTitle;
    private List<String> gridColumns;
    private Map<String, String> gridHeaders;
    private String dashboardQuery;
    private List<GridItem> gridItems;
    private Integer nextPage;
}
