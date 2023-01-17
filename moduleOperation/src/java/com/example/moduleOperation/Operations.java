package com.example.moduleOperation;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Objects;

public class Operations {
    private static String result;
    static String row1;
    static int row2;
    static int row3;
    //сделать i
    //
    public static void operation1(String path, String file2Path, String file3Path) throws Exception {
        int i;
        result="ФИО";
        for(i=1; result != null; i++) {
            //получаем значения фамилия и ФИО
            FileInputStream fis = new FileInputStream(path);//"/Users/macbook/Desktop/Desktop (2)/Bank account.xlsx"
            Workbook wb = new XSSFWorkbook(fis);
            result = wb.getSheetAt(0).getRow(i).getCell(0).getStringCellValue();//выбор строки
            System.out.println(result);
            String[] result2 = result.split("-");//делим ячейки первого столбца
            String bankAccount = result2[0];//получем банк аккаунт
            String initials = result2[1];// получаем инициалы
            fis.close();
            wb.close();
            //получаем фамилию
            // String[] splitInitials = initials.split(" ");
            //System.out.println(initials);
            //String surname = splitInitials[0]+" "+splitInitials[1]+" "+splitInitials[2];
            //System.out.println(surname);
            //ищем нужную строку в списке с суммами
            FileInputStream fis2 = new FileInputStream(file2Path);//"/Users/macbook/Desktop/Desktop (2)/Numbers.xlsx"
            Workbook wb2 = new XSSFWorkbook(fis2);
            Sheet sheet = wb2.getSheetAt(0);
            //найти sheet
            //метод поиска строки
            findRow(sheet, initials);// поиск индекса ячеки, значения и строки
            int Numbers = (int) wb2.getSheetAt(0).getRow(row3).getCell(row2 + 37).getNumericCellValue(); //
            System.out.println(Numbers);
            fis2.close();
            wb2.close();
            FileInputStream fis3 = new FileInputStream(file3Path);///Users/macbook/Desktop/Desktop (2)/Final.xls
            Workbook wb3 = new HSSFWorkbook(fis3);
            Sheet finalXls = wb3.getSheetAt(1);
            findRow(finalXls, bankAccount);
            finalXls.getRow(row3).getCell(row2 + 1).setCellValue(Numbers);
            //int finalNumbers = (int) wb3.getSheetAt(0).getRow(row3).getCell(row2 + 37).getNumericCellValue();
            OutputStream Ops = new FileOutputStream(file3Path);
            wb3.write(Ops);
            ///System.out.println(finalNumbers);
        }
        //  wb.getSheetAt(1).getRow(6).getCell(1).setCellValue("123567");
        //   FileOutputStream outFile = new FileOutputStream("/Users/macbook/Desktop/Desktop (2)/2.xls");
        // wb.write(outFile);
        //   outFile.close();
    }
    //поиск ячейки
    public static void findRow(Sheet sheet, String initials) throws RuntimeException {
        for (Row row : sheet) {
            for (Cell cell : row) {
                try{
                    if (Objects.equals(initials, cell.getStringCellValue())){ //сравниваем инициалы с содержимым ячейки
                        row2 = cell.getColumnIndex();//присваевается
                        row3 = cell.getRowIndex(); //присваевается индекс ячейки
                        row1 = cell.getStringCellValue();//присваевается значения ячейки
                    }
                }catch (RuntimeException ignored){
                }
            }
        }
        System.out.println(row1);
        System.out.println(row2);
        System.out.println(row3);
    }
    }
