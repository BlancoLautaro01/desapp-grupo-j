package ar.edu.unq.desapp.grupoj.desapp;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

public class ArchitectureTest {

    public static final String PATH = "ar.edu.unq.desapp.grupoj.desapp";

    @Test
    public void checkLayersAccess() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(PATH);

        ArchRule rule = layeredArchitecture()
                .layer("Controller").definedBy("..controller..")
                .layer("Service").definedBy("..service..")
                .layer("Persistence").definedBy("..repository..")
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller", "Service")
                .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Service");

        rule.check(importedClasses);
    }

    @Test
    public void classesInPackagesDTOHaveSimpleNameEndingWithDTO () {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(PATH + ".model.inout.dto");

        ArchRule rule = classes()
                .should().haveSimpleNameEndingWith("Dto");

        rule.check(importedClasses);
    }

    @Test
    public void classesInPackagesEnumHaveSimpleNameEndingWithEnum () {
        JavaClasses importedClasses = new ClassFileImporter().importPackages(PATH + ".model.enums");

        ArchRule rule = classes()
                .should().haveSimpleNameEndingWith("Enum");

        rule.check(importedClasses);
    }
}