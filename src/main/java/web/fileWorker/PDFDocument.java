package web.fileWorker;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import web.model.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class PDFDocument extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {


        PdfPTable table = new PdfPTable(2);
        PdfPCell header1 = new PdfPCell(new Phrase("Name"));
        PdfPCell header2 = new PdfPCell(new Phrase("Surname"));
        header1.setHorizontalAlignment(Element.ALIGN_CENTER);
        header2.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(header1);
        table.addCell(header2);

        //Get data from model
        List<Person> list = (List<Person>) model.get("model");
        for (Person person : list) {
            table.addCell(person.getName());
            table.addCell(person.getSurname());
        }
        document.add(table);
    }
}
