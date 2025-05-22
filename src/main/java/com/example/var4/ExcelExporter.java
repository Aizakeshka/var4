package com.example.var4;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {
    public static void export(List<Character> characters, String filename) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Characters");

            Row header = sheet.createRow(0);
            String[] titles = {
                    "Имя", "Пол", "Раса", "Класс", "Сила", "Ловкость", "Интеллект",
                    "Выносливость", "Харизма", "Удача", "Уровень"
            };
            for (int i = 0; i < titles.length; i++) {
                header.createCell(i).setCellValue(titles[i]);
            }

            int rowNum = 1;
            for (Character c : characters) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(c.getName());
                row.createCell(1).setCellValue(c.getGender());
                row.createCell(2).setCellValue(c.getRace());
                row.createCell(3).setCellValue(c.getCharacterClass());
                row.createCell(4).setCellValue(c.getStrength());
                row.createCell(5).setCellValue(c.getAgility());
                row.createCell(6).setCellValue(c.getIntelligence());
                row.createCell(7).setCellValue(c.getEndurance());
                row.createCell(8).setCellValue(c.getCharisma());
                row.createCell(9).setCellValue(c.getLuck());
                row.createCell(10).setCellValue(c.getLevel());
            }

            try (FileOutputStream fos = new FileOutputStream(filename)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
