package com.books.user.services;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.books.user.model.Book;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class BookPDFExporter {
	  private List<Book> listUsers;
	  
	  public BookPDFExporter(List<Book> listUsers) {
	        this.listUsers = listUsers;
	    }
	  
	   private void writeTableHeader(PdfPTable table) {
	        PdfPCell cell = new PdfPCell();
	        cell.setBackgroundColor(Color.BLUE);
	        cell.setPadding(4);
	         
	        Font font = FontFactory.getFont(FontFactory.HELVETICA);
	        font.setColor(Color.WHITE);
	         
	        cell.setPhrase(new Phrase("Book ID", font));
	         
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Title", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("Conten", font));
	        table.addCell(cell);
	         
	        cell.setPhrase(new Phrase("User", font));
	        table.addCell(cell);
	         
	        
	    }
	     
	    private void writeTableData(PdfPTable table) {
	        for (Book book : listUsers) {
	            table.addCell(String.valueOf(book.getId()));
	            table.addCell(book.getBook_tittle());
	            table.addCell(book.getBook_content());
	            table.addCell(book.getUser().getUsername());
	           
	        }
	    }
	     
	    public void export(HttpServletResponse response) throws DocumentException, IOException {
	        Document document = new Document(PageSize.A4);
	        PdfWriter.getInstance(document, response.getOutputStream());
	         
	        document.open();
	        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
	        font.setSize(18);
	        font.setColor(Color.BLUE);
	         
	        Paragraph p = new Paragraph("List of Book", font);
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	         
	        document.add(p);
	         
	        PdfPTable table = new PdfPTable(4);
	        table.setWidthPercentage(100f);
	        table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f});
	        table.setSpacingBefore(10);
	         
	        writeTableHeader(table);
	        writeTableData(table);
	         
	        document.add(table);
	         
	        document.close();
	         
	    }
}
