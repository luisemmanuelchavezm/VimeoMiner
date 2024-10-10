package AISS.vimeo.services;

import AISS.vimeo.model.Caption.Caption;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CaptionServiceTest {
    @Autowired
    CaptionService service;
    @Test
    @DisplayName("Get all captions given a videoId")
    void findAllCaptions() {
        List<Caption> captions = service.findAllCaptions("468185464");
        assertFalse(captions.isEmpty(), "The list of captions is empty!");
        System.out.println(captions);
    }

}