package com.epic.general;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class GridColumnHeaders {
    private Map<String, String> carUnderRamp = new HashMap<>();
    private Map<String, String> storekeeperLoadingProductivity = new HashMap<>();
    private Map<String, String> parcelCreateProductivity = new HashMap<>();
    private Map<String, String> notControllerLu = new HashMap<>();
    private Map<String, String> recordOfSuppliers = new HashMap<>();
    private Map<String, String> storekeeperDeliveryProductivity = new HashMap<>();
    private Map<String, String> storekeeperDistributionProductivity = new HashMap<>();
    private Map<String, String> notDistributedLu = new HashMap<>();
    private Map<String, String> notDistributedLine = new HashMap<>();
    private Map<String, String> luInChute = new HashMap<>();
    private Map<String, String> luInRampIn = new HashMap<>();
    private Map<String, String> notPostedLuInDelivery = new HashMap<>();
    private Map<String, String> notControlledLuWithStLuNr = new HashMap<>();
    private Map<String, String> picking = new HashMap<>();
    private Map<String, String> transportOrders = new HashMap<>();
    private Map<String, String> storekeeperDeliveryProductivityA = new HashMap<>();
    private Map<String, String> storekeeperDistributionProductivityA = new HashMap<>();
    private Map<String, String> notDistributedPblA = new HashMap<>();
    private Map<String,String> storekeeperProductivityXd = new HashMap<>();
    private Map<String, String> suspiciousAmount = new HashMap<>();
    private Map<String, String> measureXdProductivity = new HashMap<>();
    private Map<String, String> luWithoutMoveInRamp = new HashMap<>();
    private Map<String, String> activeWorkForStacker = new HashMap<>();
    private Map<String, String> productivityWorkForStackerA = new HashMap<>();
    private Map<String, String> pickingA = new HashMap<>();
    private Map<String, String> pickingProductivityA = new HashMap<>();
    private Map<String, String> productivityWorkTrolley = new HashMap<>();
//    Suspicious amount


    public GridColumnHeaders(){

        productivityWorkTrolley.put("val10","Табельний номер");
        productivityWorkTrolley.put("val11","ПІБ");
        productivityWorkTrolley.put("val12","Кількість ТД");

        pickingProductivityA.put("val10","Табельний номер");
        pickingProductivityA.put("val11","ПІБ");
        pickingProductivityA.put("val12","Кількість позицій");
        pickingProductivityA.put("val13","Обʼєм");
        pickingProductivityA.put("val14","Вага");
        pickingProductivityA.put("val15","Кількість MIX");

        pickingA.put("val10","Загалом міксів");
        pickingA.put("val11","В редагуванні");
        pickingA.put("val12","Заплановано");
        pickingA.put("val13","В реалізації");
        pickingA.put("val14","Загалом ліній");
        pickingA.put("val15","В редагуванні");
        pickingA.put("val16","Заплановано");
        pickingA.put("val17","В реалізації");
        pickingA.put("val18","Фулл-палет");
        pickingA.put("val19","Персонал");

        productivityWorkForStackerA.put("val10","Табельний номер");
        productivityWorkForStackerA.put("val11","ПІБ");
        productivityWorkForStackerA.put("val12","Збір");
        productivityWorkForStackerA.put("val13","Переміщення");
        productivityWorkForStackerA.put("val14","Поставка");
        productivityWorkForStackerA.put("val15","Відправка");
        productivityWorkForStackerA.put("val16","Загалом");

        activeWorkForStacker.put("val10","Збір");
        activeWorkForStacker.put("val11","Переміщення");
        activeWorkForStacker.put("val12","Поставка");
        activeWorkForStacker.put("val13","Відправка");

        luWithoutMoveInRamp.put("val10","Носій");
        luWithoutMoveInRamp.put("val11","Постачальник");
        luWithoutMoveInRamp.put("val12","Місце");
        luWithoutMoveInRamp.put("val13","Час на місці");

        measureXdProductivity.put("val10","Табельний номер");
        measureXdProductivity.put("val11","ПІБ");
        measureXdProductivity.put("val12","Носіїв");
        measureXdProductivity.put("val13","м3");
        measureXdProductivity.put("val14","Вага");

        suspiciousAmount.put("val10", "Носій");
        suspiciousAmount.put("val11", "Об'єм м3");
        suspiciousAmount.put("val12", "Вага кг");
        suspiciousAmount.put("val13", "Довжина мм");
        suspiciousAmount.put("val14", "Ширина мм");
        suspiciousAmount.put("val15", "Висота мм");
        suspiciousAmount.put("val16", "Постачальник мм");

        notDistributedPblA.put("val10","Дата активації поставки");
        notDistributedPblA.put("val11","Зона розподілу");
        notDistributedPblA.put("val12","Постачальник");
        notDistributedPblA.put("val13","Ліній");
        notDistributedPblA.put("val14","Носіїв");

        carUnderRamp.put("val10", "№ рейсу");
        carUnderRamp.put("val11", "Напрямок");
        carUnderRamp.put("val12", "План завантаження");
        carUnderRamp.put("val13", "Номер авто");
        carUnderRamp.put("val14", "Рампа");



        storekeeperLoadingProductivity.put("val10", "Табельний номер");
        storekeeperLoadingProductivity.put("val11", "ПІБ");
        storekeeperLoadingProductivity.put("val12", "Обʼєм (m3)");

        parcelCreateProductivity.put("val10","ПІБ");
        parcelCreateProductivity.put("val11","Кількість посилок");


        notControllerLu.put("val10", "Дата створення відправки");
        notControllerLu.put("val11", "Отримуач");
        notControllerLu.put("val12", "Носій");
        notControllerLu.put("val13", "Місце");
        notControllerLu.put("val14", "Артикул");


        notControlledLuWithStLuNr.put("val10", "Дата створення відправки");
        notControlledLuWithStLuNr.put("val11", "Отримуач");
        notControlledLuWithStLuNr.put("val12", "Носій");
        notControlledLuWithStLuNr.put("val13", "Місце");
        notControlledLuWithStLuNr.put("val14", "Статичний носій");
        notControlledLuWithStLuNr.put("val15", "Артикул");



        recordOfSuppliers.put("val10","№ Резерву");
        recordOfSuppliers.put("val11","Постачальник");
        recordOfSuppliers.put("val12","Дата та час запису");
        recordOfSuppliers.put("val13","Дата та час приїзду");
        recordOfSuppliers.put("val14","Час запізнення (хв.)");
        recordOfSuppliers.put("val16","Статус");


        storekeeperDeliveryProductivity.put("val10","Табельний номер");
        storekeeperDeliveryProductivity.put("val11","ПІБ");
        storekeeperDeliveryProductivity.put("val12","Носіїв");

        storekeeperDeliveryProductivityA.put("val10","Табельний номер");
        storekeeperDeliveryProductivityA.put("val11","ПІБ");
        storekeeperDeliveryProductivityA.put("val12","Поставок");
        storekeeperDeliveryProductivityA.put("val13","Носіїв");
        storekeeperDeliveryProductivityA.put("val14","Обʼєм");
        storekeeperDeliveryProductivityA.put("val15","Вага");

        storekeeperDistributionProductivity.put("val10","Табельний номер");
        storekeeperDistributionProductivity.put("val11","ПІБ");
        storekeeperDistributionProductivity.put("val12","Ліній");
        storekeeperDistributionProductivity.put("val13","Вага (кг)");
        storekeeperDistributionProductivity.put("val14","Рейтинг");


        storekeeperProductivityXd.put("val10","Табельний номер");
        storekeeperProductivityXd.put("val11","ПІБ");
        storekeeperProductivityXd.put("val12","Ліній");
        storekeeperProductivityXd.put("val13","Вага (кг)");
        storekeeperProductivityXd.put("val14","Носіїв");
        storekeeperProductivityXd.put("val15","Обʼєм");
        storekeeperProductivityXd.put("val16","Кількість сформаваних посилок");
        storekeeperProductivityXd.put("val17","Кількість носіїв в Посилці");



        storekeeperDistributionProductivityA.put("val10","Табельний номер");
        storekeeperDistributionProductivityA.put("val11","ПІБ");
        storekeeperDistributionProductivityA.put("val12","Ліній");
        storekeeperDistributionProductivityA.put("val13","Вага (кг)");
        storekeeperDistributionProductivityA.put("val14","Носіїв");
        storekeeperDistributionProductivityA.put("val15","Обʼєм");


        notDistributedLu.put("val10","Дата створення");
        notDistributedLu.put("val11","Носій");
        notDistributedLu.put("val12","Постачальник");
        notDistributedLu.put("val13","Зона розподілу");
        notDistributedLu.put("val14","Поставка");
        notDistributedLu.put("val15","Замовлення");


        notDistributedLine.put("val10","Зона розподілу");
        notDistributedLine.put("val11","Кількість ліній");
        notDistributedLine.put("val12","Найстаріший носій від");


        luInChute.put("val10","Носій");
        luInChute.put("val11","Місце");
        luInChute.put("val12","Час на шутах");
        luInChute.put("val13","Постачальник");
        luInChute.put("val14","Артикул");

        luInRampIn.put("val10","Носій");
        luInRampIn.put("val11","Місце");
        luInRampIn.put("val12","Час на рампі");
        luInRampIn.put("val13","Артикул");

        notPostedLuInDelivery.put("val10","Поставка");
        notPostedLuInDelivery.put("val11","Кількість носіїв");
        notPostedLuInDelivery.put("val12","Постачальник");


        picking.put("val10","Складська зона");
        picking.put("val11","Мікси ON");
        picking.put("val12","Ліній ON");
        picking.put("val13","Мікси OFF");
        picking.put("val14","Ліній OFF");
        picking.put("val15","Персонал");
        picking.put("val16","Укомплектовано міксів ON");
        picking.put("val17","Укомплектовано ліній ON");
        picking.put("val18","Укомплектовано міксів OFF");
        picking.put("val19","Укомплектовано ліній OFF");


        transportOrders.put("val10","Дата");
        transportOrders.put("val11","Загалом");
        transportOrders.put("val12","Переміщення");
        transportOrders.put("val13","Відправка");
        transportOrders.put("val14","Перепакування");
        transportOrders.put("val15","Поставка");
        transportOrders.put("val16","Поповнення збору");
        transportOrders.put("val17","Підвоз");





    }


}
