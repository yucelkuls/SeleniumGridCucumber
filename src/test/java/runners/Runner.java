package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/reports/html-reports/default-cucumber-reports.html",//html formatında rapor için
                "json:target/reports/json-reports/cucumber1.json",//json formatında rapor için
                "junit:target/reports/xml-reports/cucumber1.xml",//xml formatında rapor için
                "rerun:target/failedScenarios.txt",//Fail olan testleri bu text dosyasına yazar ve tekrar çalıştırılmalarına yardımcı olur.
                "pretty"//Konsola daha güzel renkli yazdırma yapar.
        },
        features = "src/test/resources/features",
        glue = "stepdefinitions",
        tags = "@XYZBank",
        dryRun = false//'dryRun = true' testi çalıştırmaz, eksik step deinitionları bulur.
)

public class Runner {

}
