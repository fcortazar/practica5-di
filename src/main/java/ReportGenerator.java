import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportGenerator {
    public static void main(String[] args) {
        try {
            // Crear datos de prueba
            List<FamilyMember> familyMembers = new ArrayList<>();

            FamilyMember member1 = new FamilyMember();
            member1.setNombre("Juan");
            member1.setApellidos("Perez");
            member1.setFechaNacimiento(new Date());
            member1.setLugarNacimiento("Madrid");
            member1.setDireccion("Calle Falsa 123");
            member1.setMunicipio("Madrid");
            member1.setProvincia("Madrid");
            member1.setTelefono("123456789");
            familyMembers.add(member1);

            // Crear la fuente de datos
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(familyMembers);

            // Compilar el informe
            String reportSource = "C:\\Users\\thext\\JaspersoftWorkspace\\MyReports\\Ej1.jrxml";
            String compiledReport = JasperCompileManager.compileReportToFile(reportSource);

            // Llenar el informe
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(compiledReport, parameters, dataSource);

            // Exportar el informe a un archivo PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "F:\\output.pdf");

            System.out.println("Informe generado con éxito.");
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}