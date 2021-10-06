package com.khodko.forestry;

import com.khodko.forestry.entity.*;
import com.khodko.forestry.service.*;
import com.khodko.forestry.session.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Properties;
import java.util.Scanner;
import java.util.UUID;

public class Menu {

    private final ForesterService foresterService;
    private final ForestryService forestryService;
    private final ForestTypeService forestTypeService;
    private final VillageService villageService;
    private final PlantingService plantingService;
    private final TreeService treeService;
    private final TreeKindService treeKindService;

    public Menu() {
        foresterService = new ForesterService();
        forestryService = new ForestryService();
        forestTypeService = new ForestTypeService();
        villageService = new VillageService();
        plantingService = new PlantingService();
        treeService = new TreeService();
        treeKindService = new TreeKindService();
    }

    public void batch() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        for (int i = 0; i < 100; i++ ) {
            int batchSize = 10;
            if (i % batchSize == 0) {
                session.flush();
                session.clear();
            }
            Village village = createVillage();
            session.save(village);
        }
        tx1.commit();
        session.close();
    }

    public void printMenu() {
        do {
            Scanner scan = new Scanner(System.in);
            System.out.println("1.Вывести таблицу\n"
                    + "2.Добавить элемент в таблицу\n"
                    + "3.Обновить элемент в таблице\n"
                    + "4.Удалить элемент из таблицы\n"
                    + "5.Выход\n");
            if (scan.hasNextInt()) {
                int n = scan.nextInt();
                switch (n) {
                    case 1:
                        printTableNames();
                        printTableData(inputMenuItem());
                        break;
                    case 2:
                        printTableNames();
                        addItem(inputMenuItem());
                        break;
                    case 3:
                        printTableNames();
                        updateItem(inputMenuItem());
                        break;
                    case 4:
                        printTableNames();
                        deleteItem(inputMenuItem());
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Пункт меню введен не верно");
                }
            } else {
                System.out.println("Пункт меню введен не верно");
            }
        } while (true);
    }

    private void printTableNames() {
        String tableNames = "1.Forester\n" +
                "2.Forestry\n" +
                "3.Forest type\n" +
                "4.Planting\n" +
                "5.Tree\n" +
                "6.Tree kind\n" +
                "7.Village\n";
        System.out.println(tableNames);
    }

    private int inputMenuItem() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    private void printTableData(int i) {
        switch (i) {
            case 1:
                System.out.println(foresterService.findAll());
                break;
            case 2:
                System.out.println(forestryService.findAll());
                break;
            case 3:
                System.out.println(forestTypeService.findAll());
                break;
            case 4:
                System.out.println(plantingService.findAll().toString());
                break;
            case 5:
                System.out.println(treeService.findAll());
                break;
            case 6:
                System.out.println(treeKindService.findAll());
                break;
            case 7:
                System.out.println(villageService.findAll());
                break;
        }
    }

    private void addItem(int i) {

        switch (i) {
            case 1:
                Forester forester = createForester();
                foresterService.save(forester);
                break;
            case 2:
                Forestry forestry = createForestry(inputValues());
                forestryService.save(forestry);
                break;
            case 3:
                ForestType forestType = createForestType();
                forestTypeService.save(forestType);
                break;
            case 4:
                Planting planting = createPlanting(inputValues());
                plantingService.save(planting);
                break;
            case 5:
                Tree tree = createTree(inputValues());
                treeService.save(tree);
                break;
            case 6:
                TreeKind treeKind = createTreeKind(inputValues());
                treeKindService.save(treeKind);
                break;
            case 7:
                Village village = createVillage();
                villageService.save(village);
                break;
        }
    }

    private String[] inputValues() {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        data = data.trim();
        return data.split("\\s+");
    }

    private void updateItem(int i) {
        Scanner scan = new Scanner(System.in);
        long id = scan.nextLong();

        switch (i) {
            case 1:
                Forester forester = createForester();
                forester.setId(id);
                foresterService.update(forester);
                break;
            case 2:
                Forestry forestry = createForestry(inputValues());
                forestry.setId(id);
                forestryService.update(forestry);
                break;
            case 3:
                ForestType forestType = createForestType();
                forestType.setId(id);
                forestTypeService.update(forestType);
                break;
            case 4:
                Planting planting = createPlanting(inputValues());
                planting.setId(id);
                plantingService.update(planting);
                break;
            case 5:
                Tree tree = createTree(inputValues());
                tree.setId(id);
                treeService.update(tree);
                break;
            case 6:
                TreeKind treeKind = createTreeKind(inputValues());
                treeKind.setId(id);
                treeKindService.update(treeKind);
                break;
            case 7:
                Village village = createVillage();
                village.setId(id);
                villageService.update(village);
                break;
        }
    }

    private String generateUUID() {
        return UUID.randomUUID().toString();
    }

    private int generateInt() {
        return (int) (Math.random() * 100);
    }

    private double generateDouble() {
        return Math.random() * 10;
    }

    private Forester createForester() {
        return Forester.builder()
                .firstName(generateUUID())
                .lastName(generateUUID())
                .build();
    }

    private Forestry createForestry(String[] values) {
        long foresterId = Long.parseLong(values[0]);
        long villageId = Long.parseLong(values[1]);
        Forester forester = foresterService.findById(foresterId);
        Village village = villageService.findById(villageId);
        return Forestry.builder()
                .name(generateUUID())
                .forester(forester)
                .village(village)
                .build();
    }

    private ForestType createForestType() {
        return ForestType.builder()
                .name(generateUUID())
                .build();
    }

    private Planting createPlanting(String[] values) {
        long forestryId = Integer.parseInt(values[0]);
        long treeKindId = Integer.parseInt(values[1]);
        Forestry forestry = forestryService.findById(forestryId);
        TreeKind treeKind = treeKindService.findById(treeKindId);
        return Planting.builder()
                .name(generateUUID())
                .square(generateInt())
                .forestry(forestry)
                .treeKind(treeKind)
                .build();
    }

    private Tree createTree(String[] values) {
        long plantingId = Long.parseLong(values[0]);
        Planting planting = plantingService.findById(plantingId);
        return Tree.builder()
                .age(generateInt())
                .latitude(generateDouble())
                .longitude(generateDouble())
                .planting(planting)
                .build();
    }

    private TreeKind createTreeKind(String[] values) {
        long forestTypeId = Long.parseLong(values[0]);
        ForestType forestType = forestTypeService.findById(forestTypeId);
        return TreeKind.builder()
                .name(generateUUID())
                .forestType(forestType)
                .build();
    }

    private Village createVillage() {
        return Village.builder()
                .name(generateUUID())
                .build();
    }


    private void deleteItem(int i) {
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        switch (i) {
            case 1:
                Forester forester = foresterService.findById(id);
                foresterService.delete(forester);
                break;
            case 2:
                Forestry forestry = forestryService.findById(id);
                forestryService.delete(forestry);
                break;
            case 3:
                ForestType forestType = forestTypeService.findById(id);
                forestTypeService.delete(forestType);
                break;
            case 4:
                Planting planting = plantingService.findById(id);
                plantingService.delete(planting);
                break;
            case 5:
                Tree tree = treeService.findById(id);
                treeService.delete(tree);
                break;
            case 6:
                TreeKind treeKind = treeKindService.findById(id);
                treeKindService.delete(treeKind);
                break;
            case 7:
                Village village = villageService.findById(id);
                villageService.delete(village);
                break;
        }
    }
}
