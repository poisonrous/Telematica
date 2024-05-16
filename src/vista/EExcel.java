package vista;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;

import javax.swing.JTable;
import javax.swing.table.TableModel;

// Clase de funcionalidad de EExcel
public class EExcel {

    // Metodo contrustor de exportacion a excel JTable y filePath
        static void exportToExcel(JTable table, String filePath) throws Exception {
            TableModel model = table.getModel();
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet();
            Row row;
            Cell cell;


            // Se escriben los topes de las columnas
            row = sheet.createRow(0);
            for (int c = 0; c < model.getColumnCount(); c++) {
                cell = row.createCell(c);
                cell.setCellValue(model.getColumnName(c));
            }

            // Se escriben las filas de datos
            for (int r = 0; r < model.getRowCount(); r++) {
                row = sheet.createRow(r+1);
                for (int c = 0; c < model.getColumnCount(); c++) {
                    cell = row.createCell(c);
                    Object value = model.getValueAt(r, c);
                    if (value instanceof String) {
                        cell.setCellValue((String)value);
                    }
                  //  else
                    //    cell.setCellValue((int)value);

                }
            }

            //Se genera el archivo excel
            FileOutputStream out = new FileOutputStream(filePath);
            workbook.write(out);
            out.close();
            workbook.close();

        }
    }

