package sunat;

import Pages.sunat.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SunatTest {
    private WebDriver driver;

    @Test
    public void testSunat(){
        // Inputs:
        /*String  regimenAsociado = "41 - Dua Exportación 41",
                codigoAduana = "118",
                anoDeclaracion = "2022",
                numDeclaracion = "1673",
                numSerie = "30",
                viaTransporte = "",
                numConocimiento = "CAP211429";*/

        String  regimenAsociado = "41 - Dua Exportación 41",
                codigoAduana = "235",
                anoDeclaracion = "2022",
                numDeclaracion = "777",
                numSerie = "2",
                viaTransporte = "",
                numConocimiento = "420320584";

        /*String  regimenAsociado = "41 - Dua Exportación 41",
                codigoAduana = "046",
                anoDeclaracion = "2022",
                numDeclaracion = "1138",
                numSerie = "1",
                viaTransporte = "",
                numConocimiento = "SEAU913704392";*/

        // Outputs:
        String  anoManifiesto = "",
                numManifiesto = "",
                fob = "",
                valorAduana= "",
                pesoNeto = "",
                consignatario = "";

        ConsultaDUAPage consultaDUA = new ConsultaDUAPage();
        consultaDUA.open();
        consultaDUA.selectRegimenAsociado(regimenAsociado);
        consultaDUA.selectCodAduana(codigoAduana);
        consultaDUA.setAnoDeclaracion(anoDeclaracion);
        consultaDUA.setNumDeclaracion(numDeclaracion);

        ReporteDUAPage reporteDUAPage = consultaDUA.clickConsultarButton();
        anoManifiesto = reporteDUAPage.getAnoManifiesto();
        numManifiesto = reporteDUAPage.getNumManifiesto();
        viaTransporte = reporteDUAPage.getViaTransporte();
        DeclaracionSeriePage declaracionSeriePage = reporteDUAPage.selectNumSerie(numSerie);

        fob = declaracionSeriePage.getFob();
        valorAduana = declaracionSeriePage.getValorAduana();
        pesoNeto = declaracionSeriePage.getPesoNeto();

        declaracionSeriePage.close();
        consultaDUA.close();

        switch (codigoAduana){
            case "118":
                System.out.println("switch " + codigoAduana);
                ConsultaManifiestoMaritimoPage consultaManifiestoMaritimoPage = new ConsultaManifiestoMaritimoPage();
                consultaManifiestoMaritimoPage.open();
                consultaManifiestoMaritimoPage.setAnoManifiesto(anoManifiesto);
                consultaManifiestoMaritimoPage.setNumManifiesto(numManifiesto);
                ReporteManifiestoMaritimoPage reporteManifiestoMaritimoPage = consultaManifiestoMaritimoPage.clickConsultarButton();
                consignatario = reporteManifiestoMaritimoPage.getConsignatario(numConocimiento);
                reporteManifiestoMaritimoPage.close();
                consultaManifiestoMaritimoPage.close();
                //System.out.println("Consignatario maritimo: " + consignatario);
                break;
            case "235":
                System.out.println("switch " + codigoAduana);
                ConsultaManifiestoAereoPage consultaManifiestoAereoPage = new ConsultaManifiestoAereoPage();
                consultaManifiestoAereoPage.open();
                consultaManifiestoAereoPage.setAnoManifiesto(anoManifiesto);
                consultaManifiestoAereoPage.setNumManifiesto(numManifiesto);
                ReporteManifiestoAereoPage reporteManifiestoAereoPage = consultaManifiestoAereoPage.clickConsultarButton();
                consignatario = reporteManifiestoAereoPage.getConsignatario(numConocimiento);
                reporteManifiestoAereoPage.close();
                consultaManifiestoAereoPage.close();
                //System.out.println("Consignatario aereo: " + consignatario);
                break;
            default:
                System.out.println("switch " + codigoAduana);
                ConsultaOtrosManifiestosPage consultaOtrosManifiestosPage = new ConsultaOtrosManifiestosPage();
                consultaOtrosManifiestosPage.open();
                consultaOtrosManifiestosPage.setAnoManifiesto(anoManifiesto);
                consultaOtrosManifiestosPage.setNumeroManifiesto(numManifiesto);
                consultaOtrosManifiestosPage.selectCodAduana(codigoAduana);
                consultaOtrosManifiestosPage.selectViaTransporte(viaTransporte);
                ReporteOtrosManifiestoPage reporteOtrosManifiestoPage = consultaOtrosManifiestosPage.clickConsultarButton();
                consignatario = reporteOtrosManifiestoPage.getConsignatario(numConocimiento);
                reporteOtrosManifiestoPage.close();
                consultaOtrosManifiestosPage.close();
                //System.out.println("Consignatario otra aduana: " + consignatario);
                break;
        }

        System.out.println("[+] Entradas:");
        System.out.println("------------");
        System.out.println("\tRegimen Asociado: " + regimenAsociado);
        System.out.println("\tCodigo de Aduana: " + codigoAduana);
        System.out.println("\tAño: " + anoDeclaracion);
        System.out.println("\tNúmero de Declaracion: " + numDeclaracion);
        System.out.println("\tNúmero de Serie: " + numSerie);
        System.out.println("\tNúmero de Conocimiento: " + numConocimiento + "\n");


        System.out.println("[+] Salidas:");
        System.out.println("------------");
        System.out.println("\tAño de Manifiesto: " + anoManifiesto);
        System.out.println("\tNúmero de Manifiesto: " + numManifiesto);
        System.out.println("\tFOB: " + fob);
        System.out.println("\tValor Aduana: " + valorAduana);
        System.out.println("\tPeso Neto: " + pesoNeto);
        System.out.println("\tCódigo de Via de Transporte: " + viaTransporte);
        System.out.println("\tConsignatario: " + consignatario);
    }


}
