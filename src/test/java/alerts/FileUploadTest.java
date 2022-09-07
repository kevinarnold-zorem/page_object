package alerts;

import Pages.FileUploadPage;
import base.BaseTest;
import static org.testng.Assert.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {

    @Test
    public void testFileUpload(){
        FileUploadPage fileUploadPage = this.homePage.clickFileUpload();
        fileUploadPage.uploadFile("C:\\Users\\mmiranch\\OneDrive - NTT DATA EMEAL\\Documentos\\02 SEMANA 02\\LUNES\\webdriver_java\\resources\\file.txt");
        assertEquals(fileUploadPage.getUploadedFiles(), "file.txt", "Uploaded incorrect");
    }
}
