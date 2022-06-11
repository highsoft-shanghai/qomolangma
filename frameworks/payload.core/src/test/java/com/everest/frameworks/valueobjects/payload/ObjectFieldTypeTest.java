package com.everest.frameworks.valueobjects.payload;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class ObjectFieldTypeTest {
    @Test
    void should_be_able_to_convert_into_objects_from_maps() {
        assertThat(ObjectFieldType.asObject().from(Map.of("a", "b")).get("a", StringFieldType.asString())).isEqualTo("b");
    }

    @Test
    void should_be_able_to_convert_into_objects_from_null_values() {
        assertThat(ObjectFieldType.asObject().nullToEmpty().from(null).get("a", StringFieldType.asString().allowNull())).isEqualTo(null);
    }
}
