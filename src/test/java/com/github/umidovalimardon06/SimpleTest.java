package com.github.umidovalimardon06;

import com.github.umidovalimardon06.entity.Dog;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleTest {

    @Test
    @DisplayName("Equality-by-reference")
    public void equalityCheckByReference() {
        Dog fido = Dog.builder()
                .name("Fido")
                .weight(5.25F)
                .build();

        Dog fidosClone = Dog.builder()
                .name("Fido")
                .weight(5.25F)
                .build();

        assertThat(fido).isNotEqualTo(fidosClone);
    }


    @Test
    @DisplayName("Equality-by-fields")
    public void equalityCheckByFields() {
        Dog fido = Dog.builder()
                .name("Fido")
                .weight(5.25F)
                .build();

        Dog fidosClone = Dog.builder()
                .name("Fido")
                .weight(5.25F)
                .build();

        assertThat(fido).isEqualToComparingFieldByFieldRecursively(fidosClone);
    }


    @Test
    @DisplayName("Truth-checking")
    public void truthChecking() {
        assertThat("".isEmpty()).isTrue();
    }


    @Test
    @DisplayName("Collection-checking")
    public void collectionChecking() {
        List<String> list = Arrays.asList("1","2","3");
        assertThat(list)
                .contains("1")
                .isNotEmpty()
                .startsWith("1")
                .doesNotContain("7")
        ;
    }


    @Test
    @DisplayName("Class-assertions")
    public void classAssertions() {
        assertThat(Runnable.class).isInterface();
    }

    @Test
    @DisplayName("File-assertions")
    public void fileAssertions() {
        File readme = new File("README.md");
        assertThat(readme)
                .exists()
                .canRead()
                .canWrite()
//                .isDirectory()
        ;
    }


    @Test
    @DisplayName("Map-assertions")
    public void mapAssertions() {
        Map<Integer,String> simpleMap = new HashMap<>();

        simpleMap.put(1,"A");
        simpleMap.put(2,"B");
        simpleMap.put(3,"C");

        assertThat(simpleMap)
                .isNotEmpty()
                .containsKey(1)
                .contains(entry(2,"B"))
                ;
    }


    @Test
    @DisplayName("Custom-description-to-assertions")
    public void customDesAssertions() {
        Map<Integer,String> simpleMap = new HashMap<>();

        simpleMap.put(1,"A");
        simpleMap.put(2,"B");
        simpleMap.put(3,"C");

        assertThat(simpleMap)
                .as("Checking the map...")
                .isNotEmpty()
                .containsKey(1)
                .contains(entry(2,"B"))
        ;
    }




}





