package changan.frameworks.context.test;

import com.example.frameworks.domain.core.GlobalClockResetter;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.time.Instant;

public class FixClockTimeExtension implements BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeEach(ExtensionContext context) {
        FixClockTime annotation = context.getRequiredTestClass().getDeclaredAnnotation(FixClockTime.class);
        GlobalClockResetter.fixAt(Instant.parse(annotation.value()));
    }

    @Override
    public void afterEach(ExtensionContext context) {
        GlobalClockResetter.reset();
    }

}
