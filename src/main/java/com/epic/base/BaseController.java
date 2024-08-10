package com.epic.base;

import com.epic.configurations.ProjectDevConfig;
import com.epic.general.DashboardForm;
import com.epic.general.DashboardQuery;
import com.epic.general.DashboardQueryService;
import com.epic.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.router.AfterNavigationEvent;
import com.vaadin.flow.router.AfterNavigationObserver;

public class BaseController extends VerticalLayout implements AfterNavigationObserver {
    public String warehouseNr;
    public String pageNumber;
    public String nextPageLink;
    public Integer nextPage;
    public String currentHost;
    public String dashboardLink;
    public Integer currentInterval;
    public BaseDashboard currentDashboard;
    public DashboardQueryService dashboardQueryService;

    public DashboardQuery dashboardQuery;
    public ProjectDevConfig projectDevConfig;

    public MainLayout mainLayout;
    public DashboardForm dashboardForm;

    @Override
    public void afterNavigation(AfterNavigationEvent afterNavigationEvent) {
        buildNextPageLink();
        setJavaScript();
    }

    public Component addFormTitle(String formTitleName){
        VerticalLayout formTitle = new VerticalLayout();
        formTitle.add(new H2(formTitleName));
        formTitle.setHorizontalComponentAlignment(Alignment.CENTER);
        formTitle.getStyle().setMarginLeft("500px");
        return formTitle;
    }

    public void buildNextPageLink(){
        nextPageLink = currentHost+  dashboardLink + warehouseNr + "/" + nextPage;
    }

    public void setJavaScript(){
        Page page = UI.getCurrent().getPage();
        page.executeJs("var intervalId = setInterval(function() {" +
                "  window.location.href = '" + nextPageLink + "';" +
                "}," +  currentInterval + ");");
        page.executeJs("var scrollDownInterval = setInterval(function() {\n" +
                "        window.scrollBy(0, 500); // Змініть значення, щоб визначити, на скільки прокручувати\n" +
                "    }, 10000);\n" +
                "\n" +
                "    // Автоматична прокрутка вгору кожні 4000 мілісекунд (4 секунди)\n" +
                "    var scrollUpInterval = setInterval(function() {\n" +
                "        window.scrollBy(0, -5000); // Змініть значення, щоб визначити, на скільки прокручувати\n" +
                "    }, 30000);");
    }

    public void redirectToUrl(String url) {
        UI.getCurrent().getPage().setLocation(url);
    }
}
