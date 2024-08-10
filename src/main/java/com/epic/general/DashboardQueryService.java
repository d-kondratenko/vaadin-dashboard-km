package com.epic.general;

import com.epic.configurations.DateTimeFormat;
import com.epic.db.OraConnectionProd;
import com.epic.db.OraConnectionStb;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class DashboardQueryService {

    private final OraConnectionStb oraConnectionStb;
    private final OraConnectionProd oraConnectionProd;
    private final DashboardQuery dashboardQuery;
    private final DateTimeFormat dateTimeFormat;

    public List<GridItem> getInfoForDashboardOutKm1(){
        try {
            List<GridItem> gridItems = new ArrayList<>();
            Connection con = oraConnectionProd.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(dashboardQuery.getDashboardOutKmQuery1());

            while (rs.next()){
                GridItem gridItem = new GridItem();
                gridItem.setVal10(rs.getString(1));
                gridItem.setVal11(rs.getString(2));
                gridItem.setVal12(rs.getString(3));


                gridItems.add(gridItem);
            }
            con.close();
            return gridItems;
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
        return null;
    }


    public List<GridItem> getInfoForDashboardOutKm2(){
        try {
            List<GridItem> gridItems = new ArrayList<>();
            Connection con = oraConnectionProd.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(dashboardQuery.getDashboardOutKmQuery2());

            while (rs.next()){
                GridItem gridItem = new GridItem();
                gridItem.setVal10(rs.getString(1));
                gridItem.setVal11(rs.getString(2));
                gridItem.setVal12(rs.getString(3));
                gridItem.setVal13(rs.getString(4));
                gridItem.setVal14(rs.getString(5));


                gridItems.add(gridItem);
            }
            con.close();
            return gridItems;
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
        return null;
    }


    public List<GridItem> getInfoForDashboardOutKm3(){
        try {
            List<GridItem> gridItems = new ArrayList<>();
            Connection con = oraConnectionProd.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(dashboardQuery.getDashboardOutKmQuery3());

            while (rs.next()){
                GridItem gridItem = new GridItem();
                gridItem.setVal10(rs.getString(1));
                gridItem.setVal11(rs.getString(2));


                gridItems.add(gridItem);
            }
            con.close();
            return gridItems;
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
        return null;
    }


    public List<GridItem> getInfoForDashboardBbKm1(){
        try {
            List<GridItem> gridItems = new ArrayList<>();
            Connection con = oraConnectionProd.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(dashboardQuery.getDashboardBbKmQuery1());

            while (rs.next()){
                GridItem gridItem = new GridItem();
                gridItem.setVal10(rs.getString(1));
                gridItem.setVal11(rs.getString(2));
                gridItem.setVal12(rs.getString(3));
                gridItem.setVal13(rs.getString(4));
                gridItem.setVal14(rs.getString(5));
                gridItem.setVal15(rs.getString(6));
                if(Objects.equals(gridItem.getVal15(), "OK")){
                    gridItem.setVal16("Не приїхав");
                } else if ("UL".equals(gridItem.getVal15())) {
                    gridItem.setVal16("Вигрузка");
                } else {
                    gridItem.setVal16("На території");
                }

                gridItems.add(gridItem);
            }
            con.close();
            return gridItems;
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
        return null;
    }

    public List<GridItem> getInfoForDashboardBbKm2(){
        try {
            List<GridItem> gridItemList = new ArrayList<>();
            Connection con = oraConnectionStb.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(dashboardQuery.getDashboardBbKmQuery2());

            while (rs.next()){
                GridItem gridItem = new GridItem();
                gridItem.setVal10(rs.getString(1));
                gridItem.setVal11(rs.getString(2));
                gridItem.setVal12(rs.getString(3));
                gridItem.setVal13(rs.getString(4));
                gridItem.setVal14(rs.getString(5));
                gridItem.setVal15(rs.getString(6));


                gridItemList.add(gridItem);
            }
            con.close();
            return gridItemList;
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
        return null;
    }

    public List<GridItem> getInfoForDashboardBbKm3(){
        try {
            List<GridItem> gridItemList = new ArrayList<>();
            Connection con = oraConnectionStb.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(dashboardQuery.getDashboardBbKmQuery3());

            while (rs.next()){
                GridItem gridItem = new GridItem();
                gridItem.setVal10(rs.getString(1));
                gridItem.setVal11(rs.getString(2));
                gridItem.setVal12(rs.getString(3));
                gridItem.setVal13(rs.getString(4));
                gridItem.setVal14(rs.getString(5));
                gridItem.setVal15(rs.getString(6));


                gridItemList.add(gridItem);
            }
            con.close();
            return gridItemList;
        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
        return null;
    }

    public List<GridItem> getInfoByQuery(String query, boolean formatData){
        try{
            List<GridItem> gridItems = new ArrayList<>();
            Connection con = oraConnectionProd.createConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            int columnCount = rs.getMetaData().getColumnCount();
            while(rs.next()) {
                if (columnCount == 2) {
                    GridItem gridItem = GridItem.builder()
                            .val10(rs.getString(1))
                            .val11(rs.getString(2))
                            .build();
                    gridItems.add(gridItem);
                } else if (columnCount == 3) {
                    GridItem gridItem = GridItem.builder()
                            .val10(rs.getString(1))
                            .val11(rs.getString(2))
                            .val12(rs.getString(3))
                            .build();
                    gridItems.add(gridItem);
                } else if (columnCount == 4){
                    GridItem gridItem = GridItem.builder()
                            .val10(rs.getString(1))
                            .val11(rs.getString(2))
                            .val12(rs.getString(3))
                            .val13(rs.getString(4))
                            .build();
                    gridItems.add(gridItem);
                } else if (columnCount == 5){
                    GridItem gridItem = GridItem.builder()
                            .val10(rs.getString(1))
                            .val11(rs.getString(2))
                            .val12(rs.getString(3))
                            .val13(rs.getString(4))
                            .val14(rs.getString(5))
                            .build();
                    if(formatData){
                        gridItem.setVal10(dateTimeFormat.reloadDateCreated(rs.getTimestamp(1).toLocalDateTime()));
                    } else {
                        gridItem.setVal10(rs.getString(1));
                    }
                    gridItems.add(gridItem);
                } else if (columnCount == 6){
                    GridItem gridItem = new GridItem();
                    if(formatData){
                        gridItem.setVal10(dateTimeFormat.reloadDateCreated(rs.getTimestamp(1).toLocalDateTime()));
                    } else {
                        gridItem.setVal10(rs.getString(1));
                    }
                    gridItem.setVal11(rs.getString(2));
                    gridItem.setVal12(rs.getString(3));
                    gridItem.setVal13(rs.getString(4));
                    gridItem.setVal14(rs.getString(5));
                    if(formatData){
                        gridItem.setVal20(rs.getInt(6));
                    } else {
                        gridItem.setVal15(rs.getString(6));
                    }

                    if(Objects.equals(gridItem.getVal15(), "OK")){
                        gridItem.setVal16("Не приїхав");
                    } else if ("UL".equals(gridItem.getVal15())) {
                        gridItem.setVal16("Вигрузка");
                    } else {
                        gridItem.setVal16("На території");
                    }
                    gridItems.add(gridItem);
                } else if (columnCount == 7){
                    GridItem gridItem = new GridItem();
                            if(formatData){
                                gridItem.setVal10(dateTimeFormat.reloadDateCreated(rs.getTimestamp(1).toLocalDateTime()));
                            } else {
                                gridItem.setVal10(rs.getString(1));
                            }
                            gridItem.setVal11(rs.getString(2));
                            gridItem.setVal12(rs.getString(3));
                            gridItem.setVal13(rs.getString(4));
                            gridItem.setVal14(rs.getString(5));
                            gridItem.setVal15(rs.getString(6));
                            if(formatData){
                                gridItem.setVal20(rs.getInt(7));
                            } else {
                                gridItem.setVal16(rs.getString(7));
                            }
                    gridItems.add(gridItem);
                } else if (columnCount == 8){
                    GridItem gridItem = GridItem.builder()
                            .val10(rs.getString(1))
                            .val11(rs.getString(2))
                            .val12(rs.getString(3))
                            .val13(rs.getString(4))
                            .val14(rs.getString(5))
                            .val15(rs.getString(6))
                            .val16(rs.getString(7))
                            .val17(rs.getString(8))
                            .build();
                    gridItems.add(gridItem);
                } else if (columnCount == 9){
                    GridItem gridItem = GridItem.builder()
                            .val10(rs.getString(1))
                            .val11(rs.getString(2))
                            .val12(rs.getString(3))
                            .val13(rs.getString(4))
                            .val14(rs.getString(5))
                            .val15(rs.getString(6))
                            .val16(rs.getString(7))
                            .val17(rs.getString(8))
                            .val18(rs.getString(9))
                            .build();
                    gridItems.add(gridItem);
                } else if (columnCount == 10){
                    GridItem gridItem = GridItem.builder()
                            .val10(rs.getString(1))
                            .val11(rs.getString(2))
                            .val12(rs.getString(3))
                            .val13(rs.getString(4))
                            .val14(rs.getString(5))
                            .val15(rs.getString(6))
                            .val16(rs.getString(7))
                            .val17(rs.getString(8))
                            .val18(rs.getString(9))
                            .val19(rs.getString(10))
                            .build();
                    gridItems.add(gridItem);
                }


            }
            con.close();
            return gridItems;

        } catch (Exception e){
            log.error(e.getLocalizedMessage());
        }
        return null;
    }

}
