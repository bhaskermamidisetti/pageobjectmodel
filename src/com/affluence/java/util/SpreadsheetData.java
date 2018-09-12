package com.affluence.java.util;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;

/**
 * @author satheesh.guduru
 *
 */
public class SpreadsheetData {

    /**
     * 
     */
    private transient Collection<Object[]> data = null;

     private boolean skipFirstRow=true;
     private String sheetName=null;
    public SpreadsheetData(final InputStream excelInputStream,String sheetName) throws IOException {
    	this.sheetName=sheetName;
    	System.out.println("sheetName---->"+sheetName);
        this.data = loadFromSpreadsheet(excelInputStream);
    }

    /**
     * @return
     */
    public Collection<Object[]> getData() {
    	System.out.println("******************************data**********************************--->"+data);
        return data;
    }

    /**
     * @param excelFile
     * @return
     * @throws IOException
     */
    private Collection<Object[]> loadFromSpreadsheet(final InputStream excelFile)
            throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook(excelFile);

        data = new ArrayList<Object[]>();
        
        Sheet sheet = workbook.getSheet(sheetName);

        int numberOfColumns = countNonEmptyColumns(sheet);
        List<Object[]> rows = new ArrayList<Object[]>();
        List<Object> rowData = new ArrayList<Object>();

        for (Row row : sheet) {
            if (isEmpty(row)) {
                break;
            } else {
            	if(skipFirstRow){
            		skipFirstRow=false;
            		continue;
            	}
                rowData.clear();
                for (int column = 0; column < numberOfColumns; column++) {
                    Cell cell = row.getCell(column);
                    rowData.add(objectFrom(workbook, cell));
                }
                rows.add(rowData.toArray());
            }
        }
        return rows;
    }

    /**
     * @param row
     * @return
     */
    private boolean isEmpty(final Row row) {
        Cell firstCell = row.getCell(0);
        boolean rowIsEmpty = (firstCell == null)
                || (firstCell.getCellType() == Cell.CELL_TYPE_BLANK);
        return rowIsEmpty;
    }

    /**
     * Count the number of columns, using the number of non-empty cells in the
     * first row.
     */
    /**
     * @param sheet
     * @return
     */
    private int countNonEmptyColumns(final Sheet sheet) {
        Row firstRow = sheet.getRow(0);
        return firstEmptyCellPosition(firstRow);
    }

    /**
     * @param cells
     * @return
     */
    private int firstEmptyCellPosition(final Row cells) {
        int columnCount = 0;
        for (Cell cell : cells) {
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                break;
            }
            columnCount++;
        }
        return columnCount;
    }

    /**
     * @param workbook
     * @param cell
     * @return
     */
    private Object objectFrom(final HSSFWorkbook workbook, final Cell cell) {
        Object cellValue = null;

        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            cellValue = cell.getRichStringCellValue().getString();
        } else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            cellValue = getNumericCellValue(cell);
        } else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            cellValue = cell.getBooleanCellValue();
        } else if (cell.getCellType()  ==Cell.CELL_TYPE_FORMULA) {
            cellValue = evaluateCellFormula(workbook, cell);
        }

        return cellValue;
    
    }

    /**
     * @param cell
     * @return
     */
    private Object getNumericCellValue(final Cell cell) {
        Object cellValue;
        if (DateUtil.isCellDateFormatted(cell)) {
            cellValue = new Date(cell.getDateCellValue().getTime());
        } else {
            cellValue = cell.getNumericCellValue();
        }
        return cellValue;
    }

    /**
     * @param workbook
     * @param cell
     * @return
     */
    private Object evaluateCellFormula(final HSSFWorkbook workbook, final Cell cell) {
        FormulaEvaluator evaluator = workbook.getCreationHelper()
                .createFormulaEvaluator();
        CellValue cellValue = evaluator.evaluate(cell);
        Object result = null;
        
        if (cellValue.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            result = cellValue.getBooleanValue();
        } else if (cellValue.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            result = cellValue.getNumberValue();
        } else if (cellValue.getCellType() == Cell.CELL_TYPE_STRING) {
            result = cellValue.getStringValue();   
        }
        
        return result;
    }
}